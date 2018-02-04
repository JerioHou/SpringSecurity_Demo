package com.jerio.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Jerio on 2018/1/24.
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("prehandle ...");
        httpServletRequest.setAttribute("start",new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("posthandle ...");
        long start = (long) httpServletRequest.getAttribute("start");
        System.out.println("耗时 ： "+(new Date().getTime() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(" atfer completion");
        Long start = (Long) httpServletRequest.getAttribute("start");
        System.out.println("time interceptor 耗时:"+ (new Date().getTime() - start));
        System.out.println("exception is "+e);
    }
}
