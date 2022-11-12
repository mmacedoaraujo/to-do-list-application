package com.mmacedo.todolist.resource.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 2841839082848693638L;
    private Long timeStamp;
    private Integer status;
    private String message;

    public StandardError() {
    }

    public StandardError(Long timeStamp, Integer status, String message) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
