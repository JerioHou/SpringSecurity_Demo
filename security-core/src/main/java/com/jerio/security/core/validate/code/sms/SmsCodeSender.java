package com.jerio.security.core.validate.code.sms;

/**
 * Created by Jerio on 2018/2/4.
 */
public interface SmsCodeSender {
    void send(String mobile,String code);
}
