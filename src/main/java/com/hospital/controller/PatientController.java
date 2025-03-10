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

import datatransfer.Wrapper;
import entity.Patient;

@Controller
@RequestMapping(path = "/patient")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;

	// Endpoint to show all data from all patients
	@GetMapping("/all")
	public ResponseEntity<Wrapper<Patient>> getAllPatients() {
		List<Patient> patients = (List<Patient>) patientRepository.findAll();
		Wrapper<Patient> wrapper = new Wrapper<Patient>(patients);
		return ResponseEntity.ok(wrapper);
	}

	// Endpoint to get all patients by room ID, wrapped in a Wrapper
	@GetMapping("/byroomid/{id}") // findpatientsbyROOMid
	public ResponseEntity<Wrapper<Patient>> getAllPatientsByRoomId(@PathVariable("id") Integer idRoom) {
	    // Search for all patients in the specified room
	    List<Patient> patients = patientRepository.findByRoom_IdRoom(idRoom);

	    // Return the patients wrapped in a Wrapper (empty list if no patients found)
	    Wrapper<Patient> wrapper = new Wrapper<>(patients);
	    return ResponseEntity.ok(wrapper);
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
