package com.example.movieclub.domain.genre;

import com.example.movieclub.domain.genre.dto.GenreDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Optional<GenreDto> findGenreByName(String name){
        return genreRepository.findByNameIgnoreCase(name)
                .map(genre -> GenreDtoMapper.map(genre));
    }

    public List<GenreDto> findAllGenres(){
         return StreamSupport.stream(genreRepository.findAll().spliterator(), false)
                 .map(genre -> GenreDtoMapper.map(genre))
                 .collect(Collectors.toList());
    }
}
