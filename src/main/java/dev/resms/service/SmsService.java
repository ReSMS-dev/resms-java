package dev.resms.service;

import dev.resms.repository.SmsRepository;
import dev.resms.config.ReSMSConfig;
import dev.resms.model.request.SendSmsRequest;
import dev.resms.model.response.SendSmsResponse;
import dev.resms.util.ValidationUtil;

/**
 * SMS service for sending SMS messages
 */
public class SmsService {
    private final SmsRepository apiClient;

    public SmsService(ReSMSConfig config) {
        this.apiClient = new SmsRepository(config);
    }

    /**
     * Sends an SMS message
     *
     * @param to Phone number to send the message to
     * @param message Message content
     * @return SendSmsResponse containing the message ID and status
     * @throws Exception if fails
     */
    public SendSmsResponse send(String to, String message) throws Exception {
        ValidationUtil.validatePhoneNumber(to);
        ValidationUtil.validateMessage(message);
        SendSmsRequest request = new SendSmsRequest(to, message);
        return apiClient.post(request);
    }

    /**
     * Sends an SMS message using request object
     *
     * @param request SendSmsRequest object
     * @return SendSmsResponse containing the message ID and status
     * @throws Exception if fails
     */
    public SendSmsResponse send(SendSmsRequest request) throws Exception {
        ValidationUtil.validateSendSmsRequest(request);
        return apiClient.post(request);
    }
}
