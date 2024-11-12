package com.hospital.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

	// Endpoint show all data from all Nurses
	@GetMapping(path = "/allnurses")
	public ResponseEntity<Iterable<Nurse>> getAllNurses() {
		Iterable<Nurse> nurses = nurseRepository.findAll();
		return ResponseEntity.ok(nurses);
	}

	@PostMapping("/login")
	public @ResponseBody ResponseEntity<Boolean> login(@RequestParam String username, @RequestParam String password) {
	    // Busca directamente una enfermera con el username y password proporcionados
	    Optional<Nurse> nurse = nurseRepository.findByUsernameAndPassword(username, password);

	    // Verifica si se encontró una coincidencia
	    if (nurse.isPresent()) {
	        System.out.println("Login successful: " + nurse.get().getUsername());
	        return ResponseEntity.ok(true);
	    }

	    // Si no se encontró ninguna coincidencia
	    System.out.println("Unsuccessful login: " + username);
	    return ResponseEntity.ok(false);
	}


	@GetMapping("/findnursebyname")
	public @ResponseBody ResponseEntity<?> getNursesByName(@RequestParam(required = false) String name) {
		// Check if var name is not null
		if (name == null || name.trim().isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid name");
		}

		// Search nurse by name
		List<Nurse> nurses = nurseRepository.findByNameContaining(name);

		// If Nurse by name not found
		if (nurses.isEmpty()) {
			return ResponseEntity.status(404).body("Nurse not found");
		}

		// If Nurse by name is found
		return ResponseEntity.ok(nurses);
	}

	@PutMapping("/updatenurse/{id}")
	public @ResponseBody ResponseEntity<String> updateNurse(@PathVariable int id, @RequestParam String name,
			@RequestParam String username, @RequestParam String password) {
		if (name == null || name.isEmpty() || username == null || username.isEmpty() || password == null || password.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Invalid Data");// 400 ko
		}

		Optional<Nurse> optionalNurse = nurseRepository.findById(id);
		if (!optionalNurse.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Nurse not found");// 404 ko
		}
		// Get nurse values
		Nurse nurseToUpdate = optionalNurse.get();
		nurseToUpdate.setName(name);
		nurseToUpdate.setUsername(username);
		nurseToUpdate.setPassword(password);

		nurseRepository.save(nurseToUpdate);
		return ResponseEntity.ok("Nurse Updated");// 200 ok
	}
	// #PR05 1.1 Crear un nuevo enfermero (201 ok, 400 kc)
	@PostMapping("/createnurse")
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

}
