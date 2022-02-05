package com.sezo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sezo.demo.entity.Guest;

@Repository
public interface GuestRepository  extends JpaRepository<Guest, Long>{

}
