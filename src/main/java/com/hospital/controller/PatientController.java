package com.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.dao.PatientRepository;

import datatransfer.PatientsWrapper;
import entity.Patient;

@Controller
@RequestMapping(path = "/patient")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;

	// Endpoint to show all data from all patients
	@GetMapping(path = "/all") // getallpatients
	public ResponseEntity<PatientsWrapper> getAllPatients() {
		List<Patient> patients = (List<Patient>) patientRepository.findAll();
		PatientsWrapper wrapper = new PatientsWrapper(patients);
		return ResponseEntity.ok(wrapper);
	}

	// Endpoint to get all patients by room ID
	@GetMapping("/byroomid/{id}") // findpatientbyROOMid
	public ResponseEntity<?> getAllPatientsByRoomId(@PathVariable("id") Integer idRoom) {
		List<Patient> patients = patientRepository.findByRoom_IdRoom(idRoom);

		if (patients.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No patients found for the given room ID");
		}
		return ResponseEntity.ok(patients);
	}

	// Endpoint to find a patient by ID
	@GetMapping("/{id}") // findpatientbyid
	public ResponseEntity<?> getPatientById(@PathVariable("id") Integer id) {
		// Check if ID is null
		if (id == null) {
			return ResponseEntity.badRequest().body("Invalid ID");
		}

		// Search patient by ID
		Optional<Patient> patient = patientRepository.findById(id);

		// If no patient is found by ID
		if (patient.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
		}

		// If patient is found
		return ResponseEntity.ok(patient.get());
	}
}
