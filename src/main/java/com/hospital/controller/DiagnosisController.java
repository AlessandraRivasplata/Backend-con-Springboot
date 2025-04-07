package com.hospital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.dao.DiagnosisRepository;

import entity.Diagnosis;

@Controller
@RequestMapping(path = "/diagnosis")
public class DiagnosisController {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @GetMapping("/{id}") // findDiagnosisByPatientId
    public ResponseEntity<?> getDiagnosisByPatientId(@PathVariable("id") Integer id) {
        // Check if ID is null
        if (id == null) {
            return ResponseEntity.badRequest().body("Invalid ID");
        }

        // Search diagnosis by patient ID
        Optional<Diagnosis> diagnosis = diagnosisRepository.findByPatientId(id);

        // If no diagnosis is found by patient ID
        if (diagnosis.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Diagnosis not found");
        }

        // If diagnosis is found
        return ResponseEntity.ok(diagnosis.get());
    }
}
