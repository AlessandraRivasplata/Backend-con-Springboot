package com.hospital.dao;

import entity.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    // Método para buscar habitaciones en un piso específico (floor)
    @Query("SELECT r FROM Room r WHERE r.floor = :floor")
    List<Room> findByFloor(@Param("floor") Integer floor);
}

