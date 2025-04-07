package com.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import entity.Diagnosis;

import java.util.Optional;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {

    @Query("SELECT d FROM Diagnosis d WHERE d.patient.idPatient = :idPatient")
    Optional<Diagnosis> findByPatientId(@Param("idPatient") Integer idPatient);
}

