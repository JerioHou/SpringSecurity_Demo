package com.jerio.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Jerio on 2018/2/1.
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
