package com.hospital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import entity.Care;

public interface CareRepository extends CrudRepository<Care, Integer>{

	@Query("SELECT c FROM Care c WHERE c.patient.idPatient = :id")
	List<Care> findByPatient_IdPatient(@Param("id") Integer id);

}
