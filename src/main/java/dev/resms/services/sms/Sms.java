package dev.resms.services.sms;

import dev.resms.core.exception.ReSMSException;
import dev.resms.core.net.AbstractHttpResponse;
import dev.resms.core.net.HttpMethod;
import dev.resms.core.service.BaseService;
import dev.resms.services.sms.model.SendSmsOptions;
import dev.resms.services.sms.model.SendSmsResponse;
import dev.resms.services.sms.validator.SendSmsOptionsValidator;

public class Sms extends BaseService {
  private static final String SEND_SMS_PATH = "/sms/send";

  /**
   * Constructs an instance of the {@code Sms} class.
   *
   * @param apiKey The apiKey used for authentication.
   */
  public Sms(final String apiKey) {
    super(apiKey);
  }

  /**
   * Sends an SMS based on the provided SMS request.
   *
   * @param sendSmsOptions The request containing SMS details.
   * @return The response indicating the status of the sms sending.
   * @throws ReSMSException If an error occurs while sending the SMS.
   */
  public SendSmsResponse send(SendSmsOptions sendSmsOptions) throws ReSMSException {
    SendSmsOptionsValidator.validate(sendSmsOptions);

    String payload = super.reSMSMapper.toJson(sendSmsOptions);

    AbstractHttpResponse<String> response =
        super.httpClient.perform(SEND_SMS_PATH, apiKey, HttpMethod.POST, payload);

    if (!response.isSuccessful()) {
      throw new ReSMSException(
          "Failed to send sms: " + response.getCode() + " " + response.getBody());
    }

    String responseBody = response.getBody();

    return reSMSMapper.fromJson(responseBody, SendSmsResponse.class);
  }
}
