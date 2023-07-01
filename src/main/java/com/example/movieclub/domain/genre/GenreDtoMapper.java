package com.example.movieclub.domain.genre;

import com.example.movieclub.domain.genre.dto.GenreDto;

class GenreDtoMapper {
    static GenreDto map(Genre genre){
        return new GenreDto(
                genre.getId(),
                genre.getName(),
                genre.getDescription()
        );
    }
}
