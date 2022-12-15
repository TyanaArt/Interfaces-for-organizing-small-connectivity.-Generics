import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    @Test
    public void searchWhenFindedSeveralTickets() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Ticket ticket1 = new Ticket(1, 2600, "Novorossiysk", "Moscow", 4);
        Ticket ticket2 = new Ticket(2, 4000, "Novosibirsk", "Perm", 4);
        Ticket ticket3 = new Ticket(3, 3000, "Novosibirsk", "Moscow", 4);
        Ticket ticket4 = new Ticket(4, 2500, "Novosibirsk", "Perm", 4);
        Ticket ticket5 = new Ticket(5, 2000, "Novosibirsk", "Perm", 4);
        Ticket ticket6 = new Ticket(6, 2700, "Novosibirsk", "Perm", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {ticket5, ticket4, ticket6, ticket2};
        Ticket[] actual = manager.findAll("Novosibirsk", "Perm");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenFindedOneTicket() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Ticket ticket1 = new Ticket(1, 2600, "Novorossiysk", "Moscow", 4);
        Ticket ticket2 = new Ticket(2, 4000, "Novosibirsk", "Perm", 4);
        Ticket ticket3 = new Ticket(3, 3000, "Novosibirsk", "Moscow", 4);
        Ticket ticket4 = new Ticket(4, 2500, "Novosibirsk", "Perm", 4);
        Ticket ticket5 = new Ticket(5, 2000, "Novosibirsk", "Perm", 4);
        Ticket ticket6 = new Ticket(6, 2700, "Novosibirsk", "Perm", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.findAll("Novosibirsk", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenNotFindedTickets() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Ticket ticket1 = new Ticket(1, 2600, "Novorossiysk", "Moscow", 4);
        Ticket ticket2 = new Ticket(2, 4000, "Novosibirsk", "Perm", 4);
        Ticket ticket3 = new Ticket(3, 3000, "Novosibirsk", "Moscow", 4);
        Ticket ticket4 = new Ticket(4, 2500, "Novosibirsk", "Perm", 4);
        Ticket ticket5 = new Ticket(5, 2000, "Novosibirsk", "Perm", 4);
        Ticket ticket6 = new Ticket(6, 2700, "Novosibirsk", "Perm", 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("Novosibirsk", "Omsk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenFindedSamePriceTickets() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Ticket ticket1 = new Ticket(1, 2600, "Novorossiysk", "Moscow", 360);
        Ticket ticket2 = new Ticket(2, 4000, "Novosibirsk", "Perm", 220);
        Ticket ticket3 = new Ticket(3, 3000, "Novosibirsk", "Moscow", 400);
        Ticket ticket4 = new Ticket(4, 2500, "Novosibirsk", "Perm", 220);
        Ticket ticket5 = new Ticket(5, 2500, "Novosibirsk", "Perm", 220);
        Ticket ticket6 = new Ticket(6, 2700, "Novosibirsk", "Perm", 220);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {ticket4, ticket5, ticket6, ticket2};
        Ticket[] actual = manager.findAll("Novosibirsk", "Perm");

        Assertions.assertArrayEquals(expected, actual);
    }

}
