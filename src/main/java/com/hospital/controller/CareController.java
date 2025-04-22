package com.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.dao.CareRepository;

import datatransfer.Wrapper;
import entity.Care;

@Controller
@RequestMapping(path = "/care")
public class CareController {
	@Autowired
	private CareRepository careRepository;


	// Endpoint to get all cares by patient ID, wrapped in a Wrapper
	@GetMapping("/bypatientid/{id}")
	public ResponseEntity<Wrapper<Care>> getAllCaresByPatientId(@PathVariable("id") Integer idPatient) {
	    // Search for all cares associated with the patient using the patient's ID
	    List<Care> cares = careRepository.findByPatient_IdPatient(idPatient);

	    // Wrap the list of cares (empty or not) in a Wrapper and return it
	    Wrapper<Care> wrapper = new Wrapper<>(cares);
	    return ResponseEntity.ok(wrapper);
	}

	// Endpoint to get care by its ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getCareById(@PathVariable("id") Integer id) {
	    // Check if ID is null (although the PathVariable ensures an ID is passed)
	    if (id == null) {
	        return ResponseEntity.badRequest().body("Invalid ID");
	    }

	    // Search for care by ID
	    Optional<Care> care = careRepository.findById(id);

	    // If no care is found with the given ID
	    if (care.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Care not found");
	    }

	    // If care is found, return the care data
	    return ResponseEntity.ok(care.get());
	}
	
	@PostMapping
    public ResponseEntity<?> createCare(@RequestBody Care care) {
        try {
            careRepository.save(care);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cura creada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear la cura: " + e.getMessage());
        }
    }
}
