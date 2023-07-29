package com.example.movieclub.domain.movie;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAllByPromotedIsTrue();
    List<Movie> findAllByGenre_NameIgnoreCase(String genre);
    @Query("SELECT m FROM Movie m JOIN m.ratings r GROUP BY m ORDER BY AVG(r.rating) DESC")
    List<Movie> findTopByRating(Pageable page);
}
