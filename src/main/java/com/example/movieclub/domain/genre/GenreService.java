package com.example.movieclub.domain.genre;

import com.example.movieclub.domain.genre.dto.GenreDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
