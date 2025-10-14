package com.yourname.roommate.repository;

import com.yourname.roommate.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByLocationContainingIgnoreCase(String location);
}
