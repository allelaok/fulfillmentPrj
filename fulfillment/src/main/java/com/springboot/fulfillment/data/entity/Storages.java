package com.springboot.fulfillment.data.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
