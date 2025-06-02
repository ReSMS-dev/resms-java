package dev.resms.repository;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dev.resms.config.ReSMSConfig;
import dev.resms.exception.ReSMSException;
import dev.resms.exception.sms.CountryDetectionFailedException;
import dev.resms.exception.sms.InsufficientSmsQuotaException;
import dev.resms.exception.sms.MessageStatusUpdateFailedException;
import dev.resms.exception.sms.PhoneNumberParsingFailedException;
import dev.resms.exception.user.InvalidApiKeyException;
import dev.resms.model.ErrorResponse;
import dev.resms.model.request.SendSmsRequest;
import dev.resms.model.response.SendSmsResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.apache.hc.core5.http.HttpStatus;

/** Generic API client for HTTP requests */
public class SmsRepository {
  private static final String SEND_SMS_PATH = "sms/send";

  private final ReSMSConfig config;
  private final JsonAdapter<SendSmsRequest> requestAdapter;
  private final JsonAdapter<SendSmsResponse> responseAdapter;
  private final JsonAdapter<ErrorResponse> errorResponseAdapter;

  public SmsRepository(ReSMSConfig config) {
    this.config = config;

    Moshi moshi = new Moshi.Builder().build();

    this.requestAdapter = moshi.adapter(SendSmsRequest.class);
    this.responseAdapter = moshi.adapter(SendSmsResponse.class);
    this.errorResponseAdapter = moshi.adapter(ErrorResponse.class);
  }

  /**
   * Executes a POST request
   *
   * @param requestBody Request body object
   * @return Parsed response object
   * @throws ReSMSException if fails
   */
  public SendSmsResponse sendSms(SendSmsRequest requestBody) throws ReSMSException {
    String jsonBody = requestAdapter.toJson(requestBody);

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(ReSMSConfig.BASE_URL + SEND_SMS_PATH))
            .header("Content-Type", "application/json")
            .header("X-Api-Key", config.getApiKey())
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();

    HttpResponse<String> httpResponse;
    try {
      httpResponse = config.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      throw new ReSMSException("Failed to send HTTP request", e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ReSMSException("HTTP request was interrupted", e);
    }

    if (httpResponse.statusCode() == HttpStatus.SC_OK) {
      try {
        return responseAdapter.fromJson(httpResponse.body());
      } catch (IOException e) {
        throw new ReSMSException("Failed to parse response body", e);
      }
    } else {
      try {
        ErrorResponse errorResponse = errorResponseAdapter.fromJson(httpResponse.body());

        String errorName = errorResponse.getError().getName();
        String errorMessage = errorResponse.getError().getMessage();

        switch (errorName) {
          case "INVALID_API_KEY" -> throw new InvalidApiKeyException(errorMessage);
          case "COUNTRY_DETECTION_FAILED" ->
              throw new CountryDetectionFailedException(errorMessage);
          case "PHONE_NUMBER_PARSING_FAILED" ->
              throw new PhoneNumberParsingFailedException(errorMessage);
          case "INSUFFICIENT_SMS_QUOTA" -> throw new InsufficientSmsQuotaException(errorMessage);
          case "MESSAGE_STATUS_UPDATE_FAILED" ->
              throw new MessageStatusUpdateFailedException(errorMessage);
          default -> throw new ReSMSException(errorResponse.getStatus() + " " + errorMessage);
        }

      } catch (IOException e) {
        throw new ReSMSException("Failed to parse error response", e);
      }
    }
  }
}
