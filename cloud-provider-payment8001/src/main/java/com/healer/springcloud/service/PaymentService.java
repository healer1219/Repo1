package com.healer.springcloud.service;

import com.healer.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentyId(Long id);
}
