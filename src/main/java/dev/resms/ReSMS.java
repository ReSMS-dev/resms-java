package dev.resms;

import dev.resms.config.ReSMSConfig;
import dev.resms.exception.ReSMSException;
import dev.resms.model.request.SendSmsRequest;
import dev.resms.model.response.SendSmsResponse;
import dev.resms.service.SmsService;

/** ReSMS Java SDK - Client principal */
public class ReSMS {
  private static final int DEFAULT_TIMEOUT = 10;
  private final SmsService smsService;

  /**
   * Creates a new ReSMS client
   *
   * @param apiKey API key for authentication
   * @param timeoutSeconds HTTP request timeout in seconds
   */
  public ReSMS(String apiKey, int timeoutSeconds) {
    ReSMSConfig config = new ReSMSConfig(apiKey, timeoutSeconds);
    this.smsService = new SmsService(config);
  }

  /**
   * Creates a new ReSMS client with a default timeout of 10 seconds
   *
   * @param apiKey API key for authentication
   */
  public ReSMS(String apiKey) {
    this(apiKey, DEFAULT_TIMEOUT);
  }

  /**
   * Sends an SMS message - Main method
   *
   * @param to Phone number to send the message to
   * @param message Message content
   * @return SendSmsResponse containing the message ID and status
   * @throws ReSMSException if fails
   */
  public SendSmsResponse send(String to, String message) throws ReSMSException {
    return smsService.send(to, message);
  }

  /**
   * Sends an SMS message using request object
   *
   * @param request SendSmsRequest object
   * @return SendSmsResponse containing the message ID and status
   * @throws ReSMSException if fails
   */
  public SendSmsResponse send(SendSmsRequest request) throws ReSMSException {
    return smsService.send(request);
  }
}
