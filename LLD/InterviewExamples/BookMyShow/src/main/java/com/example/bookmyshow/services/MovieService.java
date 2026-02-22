package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

    List<Movie> findAllMovies();

    Optional<Movie> findMovieById(long id);
}
