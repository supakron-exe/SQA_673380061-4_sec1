package sqa.lab.service;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double (Activity 9.1)
 *
 * Integration test of NowPlaying using MovieServiceStub instead of MoviePortal.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NowPlayingTest {
    private NowPlaying nowPlaying;

    @BeforeEach
    void setUp() {
        nowPlaying = new NowPlaying(new MovieServiceStub());
    }

    @Test
    void filtersPlaylistForVipCinemaOnly() {
        String result = nowPlaying.getMoviesByCinemaType("KKU Cinema", "2026-08-24", "VIP");

        assertEquals("Dune: Part Three, The Godfather Revisited, Midnight in Bangkok", result);
    }

    @Test
    void filtersPlaylistForImaxWithLaser() {
        String result = nowPlaying.getMoviesByCinemaType("KKU Cinema", "2026-08-24", "IMAX with Laser");

        assertEquals("The Odyssey, Spider-Man: Brand New Day, The End of Oak Street", result);
    }

    @Test
    void returnsEmptyWhenCinemaTypeHasNoMovies() {
        String result = nowPlaying.getMoviesByCinemaType("KKU Cinema", "2026-08-24", "4DX");

        assertEquals("", result);
    }
}
