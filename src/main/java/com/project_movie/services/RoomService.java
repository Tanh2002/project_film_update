package com.project_movie.services;

import com.project_movie.dtos.RoomDTO;
import com.project_movie.entities.Room;
import com.project_movie.repositories.IRoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RoomDTO> getRooms(Integer movieId, Integer cinemaId, String startDate, String startTime) {
        return roomRepository.getRoomByCinemaAndMovieAndSchedule(movieId,cinemaId, LocalDate.parse(startDate), LocalTime.parse(startTime))
                .stream().map(room -> modelMapper.map(room,RoomDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(int id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id).orElse(null);
        if (existingRoom != null) {
            existingRoom.setName(updatedRoom.getName());
            existingRoom.setCapacity(updatedRoom.getCapacity());
            existingRoom.setTotalArea(updatedRoom.getTotalArea());
            existingRoom.setImgURL(updatedRoom.getImgURL());
            existingRoom.setCinema(updatedRoom.getCinema());
            return roomRepository.save(existingRoom);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }
}
