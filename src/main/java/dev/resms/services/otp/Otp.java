package dev.resms.services.otp;

import dev.resms.core.exception.ReSMSException;
import dev.resms.core.net.AbstractHttpResponse;
import dev.resms.core.net.HttpMethod;
import dev.resms.core.service.BaseService;
import dev.resms.services.otp.model.SendOtpOptions;
import dev.resms.services.otp.model.SendOtpResponse;
import dev.resms.services.otp.model.VerifyOtpOptions;
import dev.resms.services.otp.model.VerifyOtpResponse;

public class Otp extends BaseService {
  private static final String SEND_OTP_PATH = "/otp";
  private static final String VERIFY_OTP_PATH = "/otp/verify";

  /**
   * Constructs an instance of the {@code Otp} class.
   *
   * @param apiKey The apiKey used for authentication.
   */
  public Otp(final String apiKey) {
    super(apiKey);
  }

  /**
   * Send an OTP based on the provided OTP request
   *
   * @param sendOtpOptions The request containing OTP details.
   * @return The response indicating the status of the OTP.
   * @throws ReSMSException If an error occurs while sending the OTP.
   */
  public SendOtpResponse send(SendOtpOptions sendOtpOptions) throws ReSMSException {
    String payload = super.reSMSMapper.toJson(sendOtpOptions);

    AbstractHttpResponse<String> response =
        super.httpClient.perform(SEND_OTP_PATH, apiKey, HttpMethod.POST, payload);

    if (!response.isSuccessful()) {
      throw new ReSMSException(
          "Failed to create otp: " + response.getCode() + " " + response.getBody());
    }

    return reSMSMapper.fromJson(response.getBody(), SendOtpResponse.class);
  }

  /**
   * Verify an OTP based on the provided OTP verify request
   *
   * @param verifyOtpOptions The request containing OTP verify details.
   * @return The response indicating the status of the OTP verification.
   * @throws ReSMSException If an error occurs while verifying the OTP.
   */
  public VerifyOtpResponse verify(VerifyOtpOptions verifyOtpOptions) throws ReSMSException {
    String payload = super.reSMSMapper.toJson(verifyOtpOptions);

    AbstractHttpResponse<String> response =
        super.httpClient.perform(VERIFY_OTP_PATH, apiKey, HttpMethod.POST, payload);

    if (!response.isSuccessful()) {
      throw new ReSMSException(
          "Failed to create otp: " + response.getCode() + " " + response.getBody());
    }

    return reSMSMapper.fromJson(response.getBody(), VerifyOtpResponse.class);
  }
}
