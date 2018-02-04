package com.jerio.exception;

/**
 * Created by Jerio on 2018/1/24.
 */

public class UserNotExistException extends RuntimeException{
    private static final long serialVersionUID = -6112780192479692859L;

    private String id;

    public UserNotExistException(String id){
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
