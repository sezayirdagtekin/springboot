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
@Table(name = "GUEST")
@Getter
@Setter
@ToString
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GUEST_ID")
	private long guestId;

	@Column(name="FIRST_NAME")
    private String firstName;
	
    @Column(name="LAST_NAME")
    private String lastName;
    
    @Column(name="EMAIL_ADDRESS")
    private String emailAddress;
    
    @Column(name="ADDRESS")
    private String address;
    
    @Column(name="COUNTRY")
    private String country;
    
    @Column(name="STATE")
    private String state;
    
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
}
