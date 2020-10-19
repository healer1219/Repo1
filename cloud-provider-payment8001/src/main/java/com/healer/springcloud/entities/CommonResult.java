package com.healer.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用Json封装体
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //404
    private Integer code;
    private String message;
    private T      data;

    /**
     * 只有code和message两个参数的构造方法
     * @param code
     * @param message
     */
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }

}
