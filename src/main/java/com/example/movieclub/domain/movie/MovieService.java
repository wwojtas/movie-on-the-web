package com.example.movieclub.domain.movie;

import com.example.movieclub.domain.movie.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> findAllPromotedMovies(){
        return movieRepository.findAllByPromotedIsTrue().stream()
                .map(movie -> MovieDtoMapper.map(movie))
                .collect(Collectors.toList());
    }

    public Optional<MovieDto> findMovieById(long id){
        return movieRepository.findById(id).map(movie -> MovieDtoMapper.map(movie));
    }

    public List<MovieDto> findMoviesByGenreName(String genre){
        return movieRepository.findAllByGenre_NameIgnoreCase(genre).stream()
                .map(movie -> MovieDtoMapper.map(movie))
                .collect(Collectors.toList());
    }
}
