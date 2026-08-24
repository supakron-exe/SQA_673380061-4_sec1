package sqa.lab.service;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double
 * Instructor: Asst.Prof. Chitsutha Soomlek
 */
public class MovieShowing {
    private final String title;
    private final String cinemaType;

    public MovieShowing(String title, String cinemaType) {
        this.title = title;
        this.cinemaType = cinemaType;
    }

    public String getTitle() {
        return title;
    }

    public String getCinemaType() {
        return cinemaType;
    }
}
