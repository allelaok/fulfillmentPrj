package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Storages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KMSStorageDTO {
    private Long no;
    private String wStorageNo;
    private String name;
    private String location;
    private Integer capacity;

    private KMSStorageDTO fromStorage(Storages storages) {
        this.no = storages.getNo();
        this.wStorageNo = storages.getWStorageNo();
        this.name = storages.getName();
        this.location = storages.getLocation();
        this.capacity = storages.getCapacity();
        return this;
    }

    public static KMSStorageDTO storageFactory(Storages storages) {
        KMSStorageDTO kmsStorageDTO = new KMSStorageDTO();
        kmsStorageDTO.fromStorage(storages);
        return kmsStorageDTO;
    }
}
