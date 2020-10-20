package com.healer.springcloud.controller;

import com.healer.springcloud.entities.CommonResult;
import com.healer.springcloud.entities.Payment;
import com.healer.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.stream.events.Comment;

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果为： =====>" + result);

        if (result > 0){
            return new CommonResult(HttpStatus.OK.value(), "插入数据库成功", result);
        }else {
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentyId(id);
        log.info("这次的查询结果为： =====>" + payment);

        if (payment != null){
            return new CommonResult(HttpStatus.OK.value(), "查询成功", payment);
        }
        else {
            return new CommonResult(444,"没有对应记录，查询失败，查询id为："+ id, null);
        }
    }
}
