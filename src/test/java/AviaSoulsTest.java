import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
    Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
    Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
    Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
    Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
    Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
    Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
    Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);

    @Test
    public void sortOnPrice() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);

        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};
        Ticket[] actual = souls.search("MSK", "SPB", Ticket::compareTo);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroTickets() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = souls.search("MSK", "NEW", Ticket::compareTo);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneTickets() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);

        Ticket[] expected = {ticket7};
        Ticket[] actual = souls.search("NEW", "LA", Ticket::compareTo);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsWithComparator() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket8, ticket1, ticket2, ticket6, ticket4};
        Ticket[] actual = souls.search("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortZeroTicketWithComparator() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = souls.search("NEW", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneTicketWithComparator() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = souls.search("UFA", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
