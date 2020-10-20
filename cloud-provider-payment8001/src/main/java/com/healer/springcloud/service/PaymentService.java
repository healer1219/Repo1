package com.healer.springcloud.service;

import com.healer.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentyId(Long id);
}
