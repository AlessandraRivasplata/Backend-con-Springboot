package com.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.dao.NurseRepository;

import entity.Nurse;

@Controller 
@RequestMapping(path = "/hospital") 
public class NurseController {
	@Autowired 
	private NurseRepository nurseRepository;
	
	 // Endpoint para mostrar todos los enfermeros
	@GetMapping(path = "/enfermeros")
	public @ResponseBody Iterable<Nurse> getAllNurses() {
		return nurseRepository.findAll();
	}
	@PostMapping("/login")
    public @ResponseBody ResponseEntity<Boolean> login(@RequestParam String username, @RequestParam String password) {
        // Obtener todos los enfermeros
        Iterable<Nurse> nurses = nurseRepository.findAll();
 
        // Busca username y password
        for (Nurse nurse : nurses) {
            if (nurse.getUsername().equals(username) && nurse.getPassword().equals(password)) {
                System.out.println("Login successful: " + nurse.getUsername());
                return ResponseEntity.ok(true);  
            }
        }
        
        // Si no se encuentra un enfermero con las credenciales correctas
        System.out.println("Unsuccessful login: " + username);
        return ResponseEntity.ok(false);
    }
	

	@GetMapping("/buscarEnfermeros")
	public @ResponseBody ResponseEntity<?> getNursesByName(@RequestParam(required = false) String name) {
	    // Validar si el nombre está vacío o es nulo
	    if (name == null || name.trim().isEmpty()) {
	        return ResponseEntity.badRequest().body("Debe proporcionar un nombre válido.");
	    }

	    // Buscar enfermeros cuyo nombre contenga la cadena proporcionada
	    List<Nurse> nurses = nurseRepository.findByNameContaining(name);

	    // Si no hay coincidencias, devolver un mensaje de error
	    if (nurses.isEmpty()) {
	        return ResponseEntity.status(404).body("Usuario no encontrado");
	    }

	    // Devolver la lista de enfermeros si hay coincidencias
	    return ResponseEntity.ok(nurses);
	}



	
	
	
	
	
	
	
}
