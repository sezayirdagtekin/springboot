package com.sezo.demo.entity;

import java.time.LocalDate;
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
@Table(name = "RESERVATION")
@Getter
@Setter
@ToString
public class Reservation {

	@Id
	@Column(name = "RESERVATION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long reservationId;

	@Column(name = "ROOM_ID")
	private long roomId;

	@Column(name = "GUEST_ID")
	private long guestId;

	@Column(name = "RES_DATE")
	private LocalDate reservationDate;

}
