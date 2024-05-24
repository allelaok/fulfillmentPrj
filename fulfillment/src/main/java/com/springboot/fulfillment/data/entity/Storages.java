package com.springboot.fulfillment.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "storage")
public class Storages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storage_no")
	private Long no;
	
	@Column(name = "storage_id", length = 100)
	private String wStorageNo;
	
	@Column(nullable = false, name = "storage_name")
	private String name;
	
	@Column(nullable = false, name = "storage_location")
	private String location;
	
	@ColumnDefault("100")
	@Column(name = "storage_capacity")
	private Integer capacity;

}
