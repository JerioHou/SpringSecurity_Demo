package com.jerio.security.core.properties;

/**
 * Created by Jerio on 2018/2/7.
 */
public class SocialProperties {

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String processesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}
