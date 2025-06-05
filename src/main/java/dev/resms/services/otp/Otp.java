package dev.resms.services.otp;

import dev.resms.core.exception.ReSMSException;
import dev.resms.core.net.AbstractHttpResponse;
import dev.resms.core.net.HttpMethod;
import dev.resms.core.service.BaseService;
import dev.resms.services.otp.model.CreateOtpOptions;
import dev.resms.services.otp.model.CreateOtpResponse;
import dev.resms.services.otp.model.DeleteOtpResponse;
import dev.resms.services.otp.model.VerifyOtpOptions;
import dev.resms.services.otp.model.VerifyOtpResponse;

public class Otp extends BaseService {
  private static final String CREATE_OTP_PATH = "/otp";
  private static final String VERIFY_OTP_PATH = "/otp/verify";
  private static final String DELETE_OTP_PATH = "/otp";

  /**
   * Constructs an instance of the {@code Otp} class.
   *
   * @param apiKey The apiKey used for authentication.
   */
  public Otp(final String apiKey) {
    super(apiKey);
  }

  /**
   * Create an OTP based on the provided OTP request
   *
   * @param createOtpOptions The request containing OTP details.
   * @return The response indicating the status of the OTP creation.
   * @throws ReSMSException If an error occurs while creating the OTP.
   */
  public CreateOtpResponse create(CreateOtpOptions createOtpOptions) throws ReSMSException {
    String payload = super.reSMSMapper.toJson(createOtpOptions);

    AbstractHttpResponse<String> response =
        super.httpClient.perform(CREATE_OTP_PATH, apiKey, HttpMethod.POST, payload);

    if (!response.isSuccessful()) {
      throw new ReSMSException(
          "Failed to create otp: " + response.getCode() + " " + response.getBody());
    }

    return reSMSMapper.fromJson(response.getBody(), CreateOtpResponse.class);
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

  /**
   * Delete an OTP based on its id
   *
   * @param otpId The id of the OTP to delete.
   * @return The response indicating the status of the OTP deletion.
   * @throws ReSMSException If an error occurs while deleting the OTP.
   */
  public DeleteOtpResponse delete(String otpId) throws ReSMSException {
    String payload = "{\"otpId\": \"" + otpId + "\"}";

    AbstractHttpResponse<String> response =
        super.httpClient.perform(DELETE_OTP_PATH, apiKey, HttpMethod.DELETE, payload);

    if (!response.isSuccessful()) {
      throw new ReSMSException(
          "Failed to create otp: " + response.getCode() + " " + response.getBody());
    }

    return reSMSMapper.fromJson(response.getBody(), DeleteOtpResponse.class);
  }
}
