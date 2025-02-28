package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.dao.RoomRepository;

import datatransfer.RoomsWrapper;
import entity.Room;

@Controller
@RequestMapping(path = "/room")
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;

	// Endpoint to show all data from all rooms
	@GetMapping(path = "/all")
	public ResponseEntity<RoomsWrapper> getAllRooms() {
		List<Room> rooms = (List<Room>) roomRepository.findAll();
		RoomsWrapper wrapper = new RoomsWrapper(rooms);
		return ResponseEntity.ok(wrapper);
	}
}
