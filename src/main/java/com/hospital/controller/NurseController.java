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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.dao.NurseRepository;
import com.hospital.dao.PatientRepository;
import com.hospital.dao.RoomRepository;

import entity.Nurse;
import entity.Patient;
import entity.RemoteMessage;
import entity.Room;
import datatransfer.NursesWrapper;
import datatransfer.RoomsWrapper;
import datatransfer.PatientsWrapper;

@Controller
@RequestMapping(path = "/nurse")
public class NurseController {
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private PatientRepository patientRepository;

	// Endpoint to show all data from all nurses
	@GetMapping(path = "/allnurses")
	public ResponseEntity<NursesWrapper> getAllNurses() {
	    List<Nurse> nurses = (List<Nurse>) nurseRepository.findAll();
	    NursesWrapper wrapper = new NursesWrapper(nurses);
	    return ResponseEntity.ok(wrapper);
	}

	// Endpoint to show all data from all rooms
	@GetMapping(path = "/allrooms")
	public ResponseEntity<RoomsWrapper> getAllRooms() {
	    List<Room> rooms = (List<Room>) roomRepository.findAll();
	    RoomsWrapper wrapper = new RoomsWrapper(rooms);
	    return ResponseEntity.ok(wrapper);
	}

	// Endpoint to show all data from all patients
	@GetMapping(path = "/allpatients")
	public ResponseEntity<PatientsWrapper> getAllPatients() {
		List<Patient> patients = (List<Patient>) patientRepository.findAll();
		PatientsWrapper wrapper = new PatientsWrapper(patients);
		return ResponseEntity.ok(wrapper);
	}
	
	
	// Endpoint for login
	@PostMapping("/login")
	public @ResponseBody ResponseEntity<Nurse> login(@RequestParam Integer nurseNumber) {
	    // Search for a nurse with the provided nurseNumber
	    Optional<Nurse> nurse = nurseRepository.findByNurseNumber(nurseNumber);

	    if (nurse.isPresent()) {
	        // If the login is successful, return the Nurse entity with HTTP status 200 (OK)
	        System.out.println("Login successful: Nurse Number " + nurse.get().getNurseNumber());
	        return ResponseEntity.ok(nurse.get());
	    }

	    // If no matching nurse is found, return HTTP status 401 (Unauthorized) with an empty body
	    System.out.println("Unsuccessful login: Nurse Number " + nurseNumber);
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
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
	public ResponseEntity<RemoteMessage> createNurse(@RequestBody Nurse nurse) {
	    // Validar datos
	    if (nurse.getName() == null || nurse.getName().isEmpty() ||
	        nurse.getUsername() == null || nurse.getUsername().isEmpty() ||
	        nurse.getPassword() == null || nurse.getPassword().isEmpty()) {
	    	return ResponseEntity.ok(new RemoteMessage("Error: Invalid Data!"));
	        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Invalid Data");
	    }

	    // Guardar la enfermera
	    Nurse savedNurse = nurseRepository.save(nurse);

	    // Respuesta de éxito
	    return ResponseEntity.ok(new RemoteMessage("Nurse created successfully"));
	    //return ResponseEntity.status(HttpStatus.CREATED).body("Nurse created successfully");
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



