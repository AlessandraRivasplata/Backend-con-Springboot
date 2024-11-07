package com.hospital.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.Nurse;

public interface NurseRepository extends CrudRepository<Nurse, Integer> {
	@Query("SELECT n FROM Nurse n WHERE n.name LIKE %:name%")
	List<Nurse> findByNameContaining(@Param("name") String name);

	// Método para buscar por username y password
	@Query("SELECT n FROM Nurse n WHERE n.username = :username AND n.password = :password")
	Optional<Nurse> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
