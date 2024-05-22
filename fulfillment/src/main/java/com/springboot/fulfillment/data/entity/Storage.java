package com.springboot.fulfillment.data.entity;

import java.util.ArrayList;
import java.util.List;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "storage")
public class Storage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storage_no")
	private Long no;
	
	@Column(name = "w_storage_no")
	private String wStorageNo;
	
	@Column(nullable = false, name = "storage_name")
	private String name;
	
	@Column(nullable = false, name = "storage_location")
	private String location;
	
	@ColumnDefault("100")
	@Column(name = "storage_capacity")
	private Integer capacity;
	
	@Column(nullable = false, name = "storage_status")
	private Integer status;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "storage_id")
//	private List<Stock> stocks = new ArrayList<>();
}
