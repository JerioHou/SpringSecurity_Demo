package com.jerio.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * Created by Jerio on 2018/2/7.
 */
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
