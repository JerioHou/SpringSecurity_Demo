package com.jerio.security.core.validate.code.sms;

/**
 * Created by Jerio on 2018/2/4.
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("手机号："+mobile +" 验证码 " + code);
    }
}
