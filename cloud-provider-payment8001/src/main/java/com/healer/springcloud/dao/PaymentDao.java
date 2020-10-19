package com.healer.springcloud.dao;

import com.healer.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    /**
     * 创建一个新的payment
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 根据 id查询payment
     * @param id
     * @return
     */
    public Payment getPaymentyId(@Param("id") Long id);
}
