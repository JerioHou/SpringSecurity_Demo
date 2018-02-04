package com.jerio.security.core.validate.code.sms;

import com.jerio.security.core.properties.SecurityProperties;
import com.jerio.security.core.validate.code.ValidateCode;
import com.jerio.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Jerio on 2018/2/4.
 */
@Component("smsValidateCodeGenerator")
public class SmsValidateCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        int expireInt = securityProperties.getCode().getSms().getExpireInt();
        return new ValidateCode(code,expireInt);
    }
}
