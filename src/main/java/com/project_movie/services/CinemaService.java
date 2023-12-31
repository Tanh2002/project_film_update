package com.project_movie.services;

import com.project_movie.dtos.CinemaDTO;
import com.project_movie.entities.Cinema;
import com.project_movie.repositories.ICinemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaService implements ICinemaService {
    @Autowired
    private ICinemaRepository cinemaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CinemaDTO> getCinemaesThatShowTheMovie(Integer movieId) {
        return cinemaRepository.getCinemaThatShowTheMovie(movieId)
                .stream().map(cinema -> modelMapper.map(cinema,CinemaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema getCinemaById(int id) {
        return cinemaRepository.findById(id).orElse(null);
    }

    @Override
    public Cinema createCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema updateCinema(int id, Cinema updatedCinema) {
        Cinema existingCinema = cinemaRepository.findById(id).orElse(null);
        if (existingCinema != null) {
            existingCinema.setName(updatedCinema.getName());
            existingCinema.setDiaChi(updatedCinema.getDiaChi());
            existingCinema.setPhoneNo(updatedCinema.getPhoneNo());
            existingCinema.setImgURL(updatedCinema.getImgURL());
            return cinemaRepository.save(existingCinema);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCinema(int id) {
        cinemaRepository.deleteById(id);
    }
}
