package com.rainlf.ms.shoporder.domain.entity.valueobject;

import lombok.Getter;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author : rain
 * @date : 2021/1/27 18:42
 */
public enum Status {
    CREATED(1, "created"),
    SUCCESS(2, "success"),
    FAILED(3, "failed");

    @Getter
    private Integer code;
    @Getter
    private String value;

    Status(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static Status fromCode(Integer code) {
        return Arrays.stream(Status.values())
                .filter(x -> Objects.equals(x.getCode(), code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(MessageFormat.format("no matching status with code: {0}", code)));
    }

    public static Status fromValue(String value) {
        return Arrays.stream(Status.values())
                .filter(x -> Objects.equals(x.getValue(), value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(MessageFormat.format("no matching status with value: {0}", value)));
    }
}
