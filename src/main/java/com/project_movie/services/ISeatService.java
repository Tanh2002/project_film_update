package com.project_movie.services;

import com.project_movie.dtos.SeatDTO;
import com.project_movie.entities.Seat;

import java.util.List;

public interface ISeatService {
    List<SeatDTO> getSeatsByScheduleId(Integer scheduleId);

    List<Seat> getAllSeats();

    Seat getSeatById(int id);

    Seat createSeat(Seat seat);

    Seat updateSeat(int id, Seat updatedSeat);

    void deleteSeat(int id);
}
