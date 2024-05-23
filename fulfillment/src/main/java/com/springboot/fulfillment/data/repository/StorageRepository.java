package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Storages;
import org.springframework.stereotype.Repository;

@Repository("storageRepository")
public interface StorageRepository extends JpaRepository<Storages, Long> {

}
