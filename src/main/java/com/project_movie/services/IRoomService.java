package com.project_movie.services;

import com.project_movie.dtos.RoomDTO;
import com.project_movie.entities.Room;

import java.util.List;

public interface IRoomService {
    List<RoomDTO> getRooms(Integer movieId, Integer cinemaId, String startDate, String startTime);

    Room createRoom(Room room);

    Room updateRoom(int id, Room updatedRoom);

    void deleteRoom(int id);
}
