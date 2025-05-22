package resms.model.response;

import com.squareup.moshi.Json;

/**
 * Response object returned after sending an SMS
 */
public class SendSmsResponse {
    @Json(name = "id")
    private String id;

    @Json(name = "status")
    private String status;

    @Override
    public String toString() {
        return "SendSmsResponse{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}