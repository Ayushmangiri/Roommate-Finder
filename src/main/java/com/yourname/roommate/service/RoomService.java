package com.yourname.roommate.service;

import com.yourname.roommate.entity.Room;

import java.util.List;

public interface RoomService {

    Room addRoom(Long userId, Room room);

    List<Room> getAllRooms();

    List<Room> searchRooms(String location);
}
