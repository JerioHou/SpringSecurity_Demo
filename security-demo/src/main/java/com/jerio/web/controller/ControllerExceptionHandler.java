package com.jerio.web.controller;

import com.jerio.exception.UserNotExistException;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
import java.util.Objects;

/**
 * Created by Jerio on 2018/1/24.
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handleUserNotException(UserNotExistException ex){
        Map<String,Object> result = new HashedMap();
        result.put("id",ex.getId());
        result.put("message",ex.getMessage());
        return result;
    }
}
