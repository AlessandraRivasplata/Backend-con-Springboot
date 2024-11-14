package com.hospital.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.dao.NurseRepository;

import entity.Nurse;

@Controller
@RequestMapping(path = "/nurse")
public class NurseController {
	@Autowired
	private NurseRepository nurseRepository;

	// Endpoint to show all data from all nurses
	@GetMapping(path = "/allnurses")
	public ResponseEntity<Iterable<Nurse>> getAllNurses() {
		Iterable<Nurse> nurses = nurseRepository.findAll();
		return ResponseEntity.ok(nurses);
	}

	// Endpoint for login
	@PostMapping("/login")//pruebapipeline
	public @ResponseBody ResponseEntity<Boolean> login(@RequestParam String username, @RequestParam String password) {
	    // Directly search for a nurse with the provided username and password
	    Optional<Nurse> nurse = nurseRepository.findByUsernameAndPassword(username, password);

	    if (nurse.isPresent()) {
	        System.out.println("Login successful: " + nurse.get().getUsername());
	        return ResponseEntity.ok(Boolean.TRUE);
	    }


	    // If no matching nurse is found, return 401 Unauthorized status
	    System.out.println("Unsuccessful login: " + username);
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	}

	// Endpoint to find nurses by name
	@GetMapping("/findnursebyname")
	public @ResponseBody ResponseEntity<?> getNursesByName(@RequestParam(required = false) String name) {
		// Check if name is not null or empty
		if (name == null || name.trim().isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid name");
		}

		// Search nurse by name
		List<Nurse> nurses = nurseRepository.findByNameContaining(name);

		// If no nurses are found by name
		if (nurses.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nurse not found");
		}

		// If nurses are found by name
		return ResponseEntity.ok(nurses);
	}

	// Endpoint to update nurse information
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<String> updateNurse(@PathVariable int id, @RequestParam String name,
			@RequestParam String username, @RequestParam String password) {
		// Check if any required field is null or empty
		if (name == null || name.isEmpty() || username == null || username.isEmpty() || password == null || password.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Invalid Data"); // 400 Bad Request
		}

		// Find the nurse by id
		Optional<Nurse> optionalNurse = nurseRepository.findById(id);
		if (!optionalNurse.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Nurse not found"); // 404 Not Found
		}

		// Update nurse information
		Nurse nurseToUpdate = optionalNurse.get();
		nurseToUpdate.setName(name);
		nurseToUpdate.setUsername(username);
		nurseToUpdate.setPassword(password);

		nurseRepository.save(nurseToUpdate);
		return ResponseEntity.ok("Nurse Updated"); // 200 OK
	}


	// Endpoint to find nurse by id
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<?> getNurseById(@PathVariable int id) {
	    // Find nurse by id
	    Optional<Nurse> nurse = nurseRepository.findById(id);

	    // If nurse is not found
	    if (!nurse.isPresent()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nurse not found"); // 404 Not Found
	    }

	    // If nurse is found
	    return ResponseEntity.ok(nurse.get()); // 200 OK
	}

	// #PR05 1.1 Crear un nuevo enfermero (201 ok, 400 kc)
	@PostMapping
	public ResponseEntity<String> createNurse(@RequestParam String name, 
	                                          @RequestParam String username, 
	                                          @RequestParam String password) {
		// Validate that the data is not empty
	    if (name == null || name.isEmpty() || username == null || username.isEmpty() || password == null || password.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Invalid Data");
	    }

	 // Create and save the new nurse
	    Nurse newNurse = new Nurse();
	    newNurse.setName(name);
	    newNurse.setUsername(username);
	    newNurse.setPassword(password);

	    nurseRepository.save(newNurse);
	    
	    return ResponseEntity.status(HttpStatus.CREATED).body("Nurse created successfully");
	}
	
	// #PR05 1.4 Delete nurse by ID (200 OK, 404 Not Found)
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteNurseById(@PathVariable int id) {
	    // Check if the nurse exists by ID
	    if (nurseRepository.existsById(id)) {
	        nurseRepository.deleteById(id); // Delete the nurse
	        return ResponseEntity.ok("Nurse deleted successfully");
	    } else {
	        // If nurse not found, return 404 Not Found
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Nurse not found");
	    }
	}


}


