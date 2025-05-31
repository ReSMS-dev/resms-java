package dev.resms.repository;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dev.resms.config.ReSMSConfig;
import dev.resms.model.request.SendSmsRequest;
import dev.resms.model.response.SendSmsResponse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


/**
 * Generic API client for HTTP requests
 */
public class SmsRepository {
    private final ReSMSConfig config;
    private final JsonAdapter<SendSmsRequest> requestAdapter;
    private final JsonAdapter<SendSmsResponse> responseAdapter;


    public SmsRepository(ReSMSConfig config) {
        this.config = config;
        Moshi moshi = new Moshi.Builder()
                .build();

        this.requestAdapter = moshi.adapter(SendSmsRequest.class);
        this.responseAdapter = moshi.adapter(SendSmsResponse.class);
    }


    /**
     * Executes a POST request
     *
     * @param requestBody Request body object
     * @return Parsed response object
     * @throws Exception if fails
     */
    public SendSmsResponse post(SendSmsRequest requestBody) throws Exception {

        String jsonBody = requestAdapter.toJson(requestBody);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(config.getUrl() + "sms/send"))
                .header("Content-Type", "application/json")
                .header("x-api-key", config.getApiKey())
                .timeout(Duration.ofSeconds(config.getTimeoutSeconds()))
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();


        HttpResponse<String> response = config.getHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new Exception(response.statusCode() + " " + response.body());
        }

        return responseAdapter.fromJson(response.body());
    }
}