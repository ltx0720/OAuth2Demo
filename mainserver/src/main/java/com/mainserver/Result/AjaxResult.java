package com.mainserver.Result;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ltx
 * @Date 20:00 2020/3/26
 */
@Data
public class AjaxResult<T> implements Serializable {
    private boolean success;
    private T data;
    private String error;

    public AjaxResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}
