package com.jerio.security.core.social.qq.config;

import com.jerio.security.core.properties.QQProperties;
import com.jerio.security.core.properties.SecurityProperties;
import com.jerio.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * Created by Jerio on 2018/2/7.
 */
@Configuration
@ConditionalOnProperty(prefix = "jerio.security.socail.qq",name = "app_id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qq = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qq.getProviderId(),qq.getAppId(),qq.getAppSecret());
    }
}
