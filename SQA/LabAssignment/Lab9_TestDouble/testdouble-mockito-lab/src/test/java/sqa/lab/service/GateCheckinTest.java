package sqa.lab.service;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab#9 – Test Double (Activity 9.2)
 *
 * Mockito double of TicketCounter replaces the dependency used by GateCheckin
 * when verifying how many customers have already passed ticket check-in.
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GateCheckinTest {

    @Mock
    private TicketCounter ticketCounter;

    @InjectMocks
    private GateCheckin gateCheckin;

    @Test
    void recordsCheckinAndUpdatesTicketCounter() {
        when(ticketCounter.getNoCheckinCustomer()).thenReturn(2);

        gateCheckin.customerEntry(101);
        gateCheckin.customerEntry(202);

        verify(ticketCounter, times(2)).changeTicketStatus(true);
        assertEquals(2, gateCheckin.getPassengersOnBoard().size());
        assertEquals(2, ticketCounter.getNoCheckinCustomer());
    }

    @Test
    void doesNotCountDuplicateTicketTwice() {
        gateCheckin.customerEntry(101);
        gateCheckin.customerEntry(101);

        verify(ticketCounter, times(1)).changeTicketStatus(true);
        verify(ticketCounter, never()).changeTicketStatus(false);
        assertEquals(1, gateCheckin.getPassengersOnBoard().size());
        assertFalse(gateCheckin.customerIsEligible(101));
    }

    @Test
    void reportsZeroCheckinCustomersBeforeAnyoneEnters() {
        when(ticketCounter.getNoCheckinCustomer()).thenReturn(0);

        assertEquals(0, gateCheckin.getPassengersOnBoard().size());
        assertEquals(0, ticketCounter.getNoCheckinCustomer());
    }
}
