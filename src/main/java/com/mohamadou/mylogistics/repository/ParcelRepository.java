package com.mohamadou.mylogistics.repository;

import com.mohamadou.mylogistics.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}