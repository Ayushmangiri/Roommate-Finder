package com.yourname.roommate.service.impl;

import com.yourname.roommate.entity.Room;
import com.yourname.roommate.entity.User;
import com.yourname.roommate.repository.RoomRepository;
import com.yourname.roommate.repository.UserRepository;
import com.yourname.roommate.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Room addRoom(Long userId, Room room) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        room.setUser(user);
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> searchRooms(String location) {
        return roomRepository.findByLocationContainingIgnoreCase(location);
    }
}
