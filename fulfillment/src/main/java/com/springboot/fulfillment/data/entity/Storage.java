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
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String location;
	
	@ColumnDefault("0")
	private Integer capacity;
	
	@Column(nullable = false)
	private Integer status;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "storage_id")
	private List<Stock> stocks = new ArrayList<>();
}
