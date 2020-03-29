package com.ftpserver.pojo;

import lombok.Data;

/**
 * @Author ltx
 * @Date 22:52 2020/3/28
 */
@Data
public class Resource {

    private String method;
    private String url;
    private String access;
}
