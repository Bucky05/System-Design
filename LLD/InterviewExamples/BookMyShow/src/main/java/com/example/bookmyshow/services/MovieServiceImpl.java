package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findMovieById(long id) {
        return this.movieRepository.findById(id);
    }
}
