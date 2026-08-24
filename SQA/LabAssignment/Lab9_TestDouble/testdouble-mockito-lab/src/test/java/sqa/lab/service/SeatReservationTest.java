package sqa.lab.service;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double (Activity 9.2)
 *
 * Mockito stub of SeatDAO replaces the real database response when
 * testing available seat numbers through SeatReservation.
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SeatReservationTest {

    @Mock
    private SeatDAO seatDAO;

    @InjectMocks
    private SeatReservation seatReservation;

    @Test
    void returnsTrueWhenSeatNumberIsAvailable() throws SQLException {
        List<String> availableSeats = Arrays.asList("A1", "A2", "B5", "C10");
        when(seatDAO.fetchAvailableSeats()).thenReturn(availableSeats);

        assertTrue(seatReservation.checkSeatAvailability("A1"));
        assertTrue(seatReservation.checkSeatAvailability("C10"));
    }

    @Test
    void returnsFalseWhenSeatNumberIsNotAvailable() throws SQLException {
        when(seatDAO.fetchAvailableSeats()).thenReturn(Arrays.asList("A1", "A2"));

        assertFalse(seatReservation.checkSeatAvailability("Z99"));
    }

    @Test
    void returnsFalseWhenNoSeatsAreAvailable() throws SQLException {
        when(seatDAO.fetchAvailableSeats()).thenReturn(Collections.emptyList());

        assertFalse(seatReservation.checkSeatAvailability("A1"));
    }
}
