package com.healer.springcloud.service.impl;

import com.healer.springcloud.dao.PaymentDao;
import com.healer.springcloud.entities.Payment;
import com.healer.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentyId(Long id) {
        return paymentDao.getPaymentyId(id);
    }
}
