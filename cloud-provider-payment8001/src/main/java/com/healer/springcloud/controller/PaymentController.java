package com.healer.springcloud.controller;

import com.healer.springcloud.entities.CommonResult;
import com.healer.springcloud.entities.Payment;
import com.healer.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.stream.events.Comment;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果为： =====>" + result);

        if (result > 0){
            return new CommonResult(HttpStatus.OK.value(), "插入数据库成功,端口号为："+serverPort, result);
        }else {
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentyId(id);
        log.info("这次的查询结果为： =====>" + payment);

        if (payment != null){
            return new CommonResult(HttpStatus.OK.value(), "查询成功,端口号为："+serverPort, payment);
        }
        else {
            return new CommonResult(444,"没有对应记录，查询失败，查询id为："+ id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String elements : services) {
            log.info("*********element:" + elements);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"/t"+instance.getHost()+"/t"+instance.getPort()+"/t"+instance.getUri());
        }

        return discoveryClient;
    }
}
