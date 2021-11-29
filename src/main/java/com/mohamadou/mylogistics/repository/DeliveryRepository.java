package com.mohamadou.mylogistics.repository;

import com.mohamadou.mylogistics.entity.Customer;
import com.mohamadou.mylogistics.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}