package com.rainlf.monolithshop.adapter.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : rain
 * @date : 2021/1/27 19:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebResponse {
    private Boolean success;
    private Object data;
    private String message;

    public static WebResponse ok(Object data) {
        return new WebResponse(true, data, null);
    }

    public static WebResponse ok(String message) {
        return new WebResponse(true, null, message);
    }

    public static WebResponse ok(Object data, String message) {
        return new WebResponse(true, data, message);
    }

    public static WebResponse error(Exception e) {
        return new WebResponse(false, null, e.getMessage());
    }
}
