package com.jerio.security.browser.support;

/**
 * Created by Jerio on 2018/1/29.
 */
public class SimpleResponse {
    public SimpleResponse(Object content){
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
