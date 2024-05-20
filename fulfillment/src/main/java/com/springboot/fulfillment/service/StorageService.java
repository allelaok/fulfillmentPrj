package com.springboot.fulfillment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.entity.Delivery;
import com.springboot.fulfillment.data.entity.Storage;
import com.springboot.fulfillment.data.repository.StorageRepository;

@Service
public class StorageService {

	@Autowired
	private StorageRepository storageRepository;
	
	public List<Storage> getStorageList() {
        
        return storageRepository.findAll();
    }
	
	public Storage updateStorage(String id, Storage storage) {
		if (storageRepository.existsById(id)) {
			storage.setId(id);
			return storageRepository.save(storage);
		}
		return null;
	}
}
