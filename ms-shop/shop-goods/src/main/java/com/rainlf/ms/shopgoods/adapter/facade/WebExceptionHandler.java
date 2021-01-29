package com.rainlf.ms.shopgoods.adapter.facade;

import com.rainlf.ms.shopgoods.adapter.dto.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : rain
 * @date : 2021/1/28 12:07
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(Exception.class)
    public WebResponse handleException(Exception e) {
        log.error("handle exception: {}", e.getMessage(), e);
        return WebResponse.error(e);
    }
}
