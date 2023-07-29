package com.example.movieclub.domain.rating;

import com.example.movieclub.domain.movie.Movie;
import com.example.movieclub.domain.movie.MovieRepository;
import com.example.movieclub.domain.user.User;
import com.example.movieclub.domain.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, MovieRepository movieRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    public void addOrUpdateRating(String userEmail, long movieId, int rating){
        Rating ratingToSaveOrUpdate = ratingRepository
                .findByUser_EmailAndMovie_Id(userEmail, movieId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setMovie(movie);
        ratingToSaveOrUpdate.setRating(rating);
        ratingRepository.save(ratingToSaveOrUpdate);
    }

    public Optional<Integer> getUserRatingForMovie(String userEmail, long movieId){
        return ratingRepository.findByUser_EmailAndMovie_Id(userEmail, movieId)
                .map(Rating::getRating);
    }
}
