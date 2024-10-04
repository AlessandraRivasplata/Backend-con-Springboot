package com.api.hospital.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.api.hospital.models.Nurse;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/hospital")
public class NurseController {
    // Lista de enfermeros como variable de instancia
    private List<Nurse> nurses;
    // Inicializar la lista de enfermeros en el constructor
    public NurseController() {
        nurses = new ArrayList<>();
        nurses.add(new Nurse("Laura", "laurag", "password123"));
        nurses.add(new Nurse("Carlos", "carlosm", "passCarlos"));
        nurses.add(new Nurse("Marta", "martaf", "martaSecure01"));
        nurses.add(new Nurse("Juan", "juanperez", "juanPass!"));
        nurses.add(new Nurse("Ana", "ana_garcia", "ana123456"));
        nurses.add(new Nurse("Jose", "jose_lara", "josePwd789"));
        nurses.add(new Nurse("Sofia", "sofia.m", "sofPass10"));
        nurses.add(new Nurse("Pedro", "pedroruiz", "pedroKey"));
        nurses.add(new Nurse("Elena", "elena99", "elena!pass"));
        nurses.add(new Nurse("Raul", "raulh", "raulSegura"));
    }
 // Endpoint para mostrar todos los enfermeros
    @GetMapping("/enfermeros")
    public List<Nurse> getAllNurses() {
    	return nurses;
    }
 // Endpoint para validar el login
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
    
    
    //Testing
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

}