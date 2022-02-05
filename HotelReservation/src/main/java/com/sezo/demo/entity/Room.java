package com.sezo.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ROOM")
@Getter
@Setter
@ToString
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROOM_ID")
	private long id;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ROOM_NUMBER")
	private String roomNumber;
	
	@Column(name = "BED_INFO")
	private String bedInfo;

}
