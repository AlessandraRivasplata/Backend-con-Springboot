package com.hospital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import entity.Care;
import entity.VitalSignsDTO;

public interface CareRepository extends CrudRepository<Care, Integer>{

	@Query("SELECT c FROM Care c WHERE c.patient.idPatient = :id")
	List<Care> findByPatient_IdPatient(@Param("id") Integer id);

	@Query("SELECT new entity.VitalSignsDTO(c.recordedAt, c.systolicBp, c.diastolicBp, " +
		       "c.bodyTemperature, c.pulse, c.respiratoryRate) " +
		       "FROM Care c WHERE c.patient.idPatient = :patientId ORDER BY c.recordedAt ASC")
		List<VitalSignsDTO> findVitalsByPatientId(@Param("patientId") Integer patientId);
}
