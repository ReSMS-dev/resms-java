package sdk.resms;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Json;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * ReSMS Java SDK
 */
public class ReSMS {
    private static final String BASE_URL = "https://api.resms.dev/";
    private final String apiKey;
    private final HttpClient httpClient;
    private final Moshi moshi;
    private final int timeoutSeconds;

    /**
     * Creates a new ReSMS client
     *
     * @param apiKey API key for authentication
     * @param timeoutSeconds HTTP request timeout in seconds
     */
    public ReSMS(String apiKey, int timeoutSeconds) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("apiKey is required");
        }
        this.apiKey = apiKey;
        this.timeoutSeconds = timeoutSeconds;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(timeoutSeconds))
                .build();
        this.moshi = new Moshi.Builder()
                .build();
    }

    /**
     * Creates a new ReSMS client with a default timeout of 10 seconds
     *
     * @param apiKey API key for authentication
     */
    public ReSMS(String apiKey) {
        this(apiKey, 10);
    }

    /**
     * Sends an SMS message
     *
     * @param to Phone number to send the message to
     * @param message Message content
     * @return SendResult containing the message ID and status
     * @throws ReSMSException if the API request fails
     * @throws IOException if there's an error with the HTTP request
     * @throws InterruptedException if the HTTP request is interrupted
     */
    public SendResult send(String to, String message) throws ReSMSException, IOException, InterruptedException {
        SendRequest request = new SendRequest(to, message);
        JsonAdapter<SendRequest> requestAdapter = moshi.adapter(SendRequest.class);
        String requestBody = requestAdapter.toJson(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "sms/send"))
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .timeout(Duration.ofSeconds(timeoutSeconds))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new ReSMSException(response.statusCode() + " " + response.body());
        }

        JsonAdapter<SendResult> resultAdapter = moshi.adapter(SendResult.class);
        return resultAdapter.fromJson(response.body());
    }

    /**
     * Request object for sending SMS
     */
    private static class SendRequest {
        @Json(name = "to")
        private final String to;

        @Json(name = "message")
        private final String message;

        public SendRequest(String to, String message) {
            this.to = to;
            this.message = message;
        }
    }

    /**
     * Result object returned after sending an SMS
     */
    public static class SendResult {
        @Json(name = "id")
        private String id;

        @Json(name = "status")
        private String status;

        @Override
        public String toString() {
            return "SendResult{id='" + id + "', status='" + status + "'}";
        }
    }

    /**
     * Exception thrown for ReSMS API errors
     */
    public static class ReSMSException extends Exception {
        public ReSMSException(String message) {
            super(message);
        }
    }
}