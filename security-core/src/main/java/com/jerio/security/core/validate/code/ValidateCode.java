package com.jerio.security.core.validate.code;

import java.time.LocalDateTime;

/**
 * Created by Jerio on 2018/1/30.
 */
public class ValidateCode {
    private String code;
    private LocalDateTime expireTime;

    public ValidateCode(String code,int expireInt){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireInt);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
