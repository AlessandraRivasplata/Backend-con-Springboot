package com.hospital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
    
    @Query("SELECT n FROM Patient n WHERE n.room.roomNumber = :roomNumber")
    List<Patient> findByRoom_RoomNumber(Integer roomNumber);
}


