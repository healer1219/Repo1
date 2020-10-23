package com.healer.springcloud.dao;

import com.healer.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface PaymentDao {
    /**
     * 创建一个新的payment
     * @param payment
     * @return
     */
    @Transactional
    public int create(Payment payment);

    /**
     * 根据 id查询payment
     * @param id
     * @return
     */
    @Transactional
    public Payment getPaymentyId(@Param("id") Long id);
}
