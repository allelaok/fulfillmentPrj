package com.springboot.fulfillment.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

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
	@Column(name = "storage_id")
	private String id;
	
	@Column(nullable = false, name = "storage_name")
	private String name;
	
	@Column(nullable = false, name = "storage_location")
	private String location;
	
	@ColumnDefault("0")
	@Column(name = "storage_capacity")
	private Integer capacity;
	
	@Column(nullable = false, name = "storage_status")
	private Integer status;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "storage_id")
	private List<Stock> stocks = new ArrayList<>();
}
