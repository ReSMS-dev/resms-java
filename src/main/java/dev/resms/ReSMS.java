package dev.resms;

import dev.resms.services.otp.Otp;
import dev.resms.services.sms.Sms;
import lombok.RequiredArgsConstructor;

/** ReSMS Java SDK - Client principal */
@RequiredArgsConstructor
public class ReSMS {
  /** The API key for the ReSMS service. */
  private final String apiKey;

  /**
   * Returns an Sms object that can be used to interact with the SMS service.
   *
   * @return An Sms object.
   */
  public Sms sms() {
    return new Sms(apiKey);
  }

  /**
   * Returns an Otp object that can be used to interact with the Otp service.
   *
   * @return An Otp object.
   */
  public Otp otp() {
    return new Otp(apiKey);
  }
}
