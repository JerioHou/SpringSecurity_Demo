package com.jerio.security.browser;

import com.jerio.security.core.authentication.AbstractChannelSecurityConfig;
import com.jerio.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.jerio.security.core.properties.SecurityConstants;
import com.jerio.security.core.properties.SecurityProperties;
import com.jerio.security.core.validate.code.ValidateCodeFilter;
import com.jerio.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


/**
 * Created by Jerio on 2018/1/29.
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService myUserDetailsService;
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        applyPasswordAuthenticationConfig(http);

        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(myUserDetailsService)
                .and()
                .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                        "/user/regist")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();

    }




//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//         http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
//            .formLogin()
//            //登录页面
//            .loginPage("/authentication/require")
//            //发送这个请求时，UsernamePasswordAuthenticationFilter来处理这个请求
//            .loginProcessingUrl("/authentication/form")
//            .successHandler(myAuthenticationSuccess)
//            .failureHandler(myAuthenticationFailureHandler)
//            .and()
//            .rememberMe()
//            .tokenRepository(persistentTokenRepository())
//            .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
//            .userDetailsService(myUserDetailsService)
//            .and()
//            .authorizeRequests()
//            //匹配带这个请求是，放行
//            .antMatchers("/authentication/require", "/code/*", securityProperties.getBrowser().getLoginPage()).permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .csrf().disable()
//             .apply(smsCodeAuthenticationSecurityConfig);
//    }



}
