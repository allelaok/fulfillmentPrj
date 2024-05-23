package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Storages;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StorageDTO {
	private Long no;
	private String wStorageNo;
	private String name;
	private String location;
	private Integer capacity;
	private Integer status;
	
//	public StorageListResponseDTO fromStorage(Storage storage) {
//		this.wStorageNo = storage.getWStorageNo();
//		this.name = storage.getName();
//		this.location = storage.getLocation();
//		this.capacity = storage.getCapacity();
//		this.status = storage.getStatus();
//		return this;
//	}
//	
//	public static StorageListResponseDTO StorageFactory(Storage storage) {
//		StorageListResponseDTO storageListResponseDTO = new StorageListResponseDTO();
//		storageListResponseDTO.fromStorage(storage);
//		return storageListResponseDTO;
//	}
}
