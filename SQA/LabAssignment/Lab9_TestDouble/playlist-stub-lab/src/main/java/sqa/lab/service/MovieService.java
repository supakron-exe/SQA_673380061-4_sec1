package sqa.lab.service;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double
 * Instructor: Asst.Prof. Chitsutha Soomlek
 *
 * Sends a request for the movie playlist of a cinema (location) on a given date
 * to the external MoviePortal and returns all movies that have showtimes.
 */
import java.util.List;

public interface MovieService {
    List<MovieShowing> getMovies(String location, String date);
}
