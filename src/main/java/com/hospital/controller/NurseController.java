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
	
	 // Endpoint para validar el login
	/*
	@PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String username, @RequestParam String password) {
        for (Nurse nurse : nurses) {
            // Comparar el nombre de usuario y la contraseña
            if (username.equals(nurse.getUsername()) && password.equals(nurse.getPassword())) {
                System.out.println("Login successful: " + nurse.getUsername());
                return ResponseEntity.ok(true);  
            }
        }
        System.out.println("unsuccessful login " + username);
        return ResponseEntity.ok(false);  
    }
	 */
	
	// Endpoint para buscar por nombre
	/*
	@GetMapping("/search")
    public ResponseEntity<List<Nurse>> searchNursesByName(@RequestParam String nombre) {
        List<Nurse> result = new ArrayList<>();
        for (Nurse nurse : nurses) {
            if (nurse.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                result.add(nurse);
            }
        }
        return ResponseEntity.ok(result);
    }
	 */
}
