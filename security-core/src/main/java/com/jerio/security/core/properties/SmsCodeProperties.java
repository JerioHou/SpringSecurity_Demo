package com.jerio.security.core.properties;

/**
 * Created by Jerio on 2018/1/31.
 */
public class SmsCodeProperties {

    private int length = 4;
    private int expireInt = 60;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireInt() {
        return expireInt;
    }

    public void setExpireInt(int expireInt) {
        this.expireInt = expireInt;
    }
}
