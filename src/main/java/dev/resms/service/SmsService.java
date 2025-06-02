package dev.resms.service;

import dev.resms.api.ReSMSApiClient;
import dev.resms.config.ReSMSConfig;
import dev.resms.exception.ReSMSException;
import dev.resms.model.request.SendSmsRequest;
import dev.resms.model.response.SendSmsResponse;
import dev.resms.validator.SendSmsValidator;
import lombok.NonNull;

/** SMS service for sending SMS messages */
public class SmsService {
  private final ReSMSApiClient apiClient;

  public SmsService(@NonNull ReSMSConfig config) {
    this.apiClient = new ReSMSApiClient(config);
  }

  /**
   * Sends an SMS message using request object
   *
   * @param request SendSmsRequest object
   * @return SendSmsResponse containing the message ID and status
   * @throws ReSMSException if fails
   */
  public SendSmsResponse send(@NonNull SendSmsRequest request) throws ReSMSException {
    SendSmsValidator.validate(request);
    return apiClient.sendSms(request);
  }
}
