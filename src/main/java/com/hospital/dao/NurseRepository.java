package com.hospital.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.Nurse;

public interface NurseRepository extends CrudRepository<Nurse, Integer> {
    @Query("SELECT n FROM Nurse n WHERE n.nombre LIKE %:name%")
    List<Nurse> findByNameContaining(@Param("name") String name);

}