package sqa.lab.service;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double
 * Instructor: Asst.Prof. Chitsutha Soomlek
 *
 * Filters the movie playlist so only titles playing in the requested
 * cinema type are shown (for example VIP or IMAX with Laser).
 */
import java.util.List;
import java.util.stream.Collectors;

public class NowPlaying {
    private final MovieService movieService;

    public NowPlaying(MovieService movieService) {
        this.movieService = movieService;
    }

    public String getMoviesByCinemaType(String location, String date, String cinemaType) {
        List<MovieShowing> playlist = movieService.getMovies(location, date);
        return playlist.stream()
                .filter(movie -> movie.getCinemaType().equalsIgnoreCase(cinemaType))
                .map(MovieShowing::getTitle)
                .collect(Collectors.joining(", "));
    }
}
