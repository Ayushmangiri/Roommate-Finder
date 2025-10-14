package com.yourname.roommate.controller;

import com.yourname.roommate.entity.Room;
import com.yourname.roommate.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Add Room
    @PostMapping("/add/{userId}")
    public ResponseEntity<Room> addRoom(@PathVariable Long userId, @RequestBody Room room) {
        Room savedRoom = roomService.addRoom(userId, room);
        return ResponseEntity.ok(savedRoom);
    }

    // Get All Rooms
    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    // Search Rooms by Location
    @GetMapping("/search")
    public ResponseEntity<List<Room>> searchRooms(@RequestParam String location) {
        return ResponseEntity.ok(roomService.searchRooms(location));
    }
}
