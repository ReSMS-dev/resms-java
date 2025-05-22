package resms.model.request;

import com.squareup.moshi.Json;

/**
 * Request object for sending SMS
 */
public class SendSmsRequest {
    @Json(name = "to")
    private final String to;

    @Json(name = "message")
    private final String message;

    public SendSmsRequest(String to, String message) {
        this.to = to;
        this.message = message;
    }

    @Override
    public String toString() {
        return "SendSmsRequest{" +
                "to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }
}
