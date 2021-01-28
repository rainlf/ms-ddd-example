package com.rainlf.ms.shopgoods.adapter.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : rain
 * @date : 2021/1/28 20:23
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

    public static WebResponse error(String message) {
        return new WebResponse(false, null, message);
    }
}
