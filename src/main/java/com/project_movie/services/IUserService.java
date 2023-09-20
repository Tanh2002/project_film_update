package com.project_movie.services;

import com.project_movie.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Integer id);
    void remove(Integer id);
    Optional<User> findByUsername(String username);
}
