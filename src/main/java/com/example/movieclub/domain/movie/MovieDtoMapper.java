package com.example.movieclub.domain.movie;

import com.example.movieclub.domain.movie.dto.MovieDto;
import com.example.movieclub.domain.rating.Rating;

class MovieDtoMapper {
    static MovieDto map(Movie movie) {
        double avgRating = movie.getRatings().stream()
                .map(Rating::getRating)
                .mapToDouble(value -> value)
                .average()
                .orElse(0);
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getOriginalTitle(),
                movie.getShortDescription(),
                movie.getDescription(),
                movie.getYoutubeTrailerId(),
                movie.getReleaseYear(),
                movie.getGenre().getName(),
                movie.isPromoted(),
                movie.getPoster(),
                avgRating,
                movie.getRatings().size());
    }
}