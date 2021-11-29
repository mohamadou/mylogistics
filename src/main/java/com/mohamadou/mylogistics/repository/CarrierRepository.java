package com.mohamadou.mylogistics.repository;

import com.mohamadou.mylogistics.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {
}
