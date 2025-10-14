package com.yourname.roommate.repository;

import com.yourname.roommate.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByLocationContainingIgnoreCase(String location);
}
