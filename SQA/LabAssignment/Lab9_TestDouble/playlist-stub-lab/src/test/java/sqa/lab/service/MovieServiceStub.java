package sqa.lab.service;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double
 *
 * Stub that replaces MoviePortal / MovieService with canned playlist data
 * so NowPlaying can be integration-tested without the external dependency.
 */
import java.util.Arrays;
import java.util.List;

public class MovieServiceStub implements MovieService {

    @Override
    public List<MovieShowing> getMovies(String location, String date) {
        return Arrays.asList(
                new MovieShowing("The Odyssey", "IMAX with Laser"),
                new MovieShowing("Spider-Man: Brand New Day", "IMAX with Laser"),
                new MovieShowing("The End of Oak Street", "IMAX with Laser"),
                new MovieShowing("Dune: Part Three", "VIP"),
                new MovieShowing("The Godfather Revisited", "VIP"),
                new MovieShowing("Midnight in Bangkok", "VIP"),
                new MovieShowing("Cartoon Parade", "Standard")
        );
    }
}
