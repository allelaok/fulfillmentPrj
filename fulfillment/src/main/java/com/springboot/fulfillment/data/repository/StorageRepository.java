package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Storage;

public interface StorageRepository extends JpaRepository<Storage, Long> {

}
