package com.healer.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data       //Lombok 自动生成set和get方法
@AllArgsConstructor     //全参构造方法
@NoArgsConstructor      //无参构造方法
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
