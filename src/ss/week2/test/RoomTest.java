package ss.week2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week2.hotel.Safe;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {
    private Guest guest;
    private Room room;
    private Safe safe;

    @BeforeEach
    public void setUp() {
        this.guest = new Guest("Jip");
        this.safe = new Safe();
        this.room = new Room(101,safe);
         // TODO: initialise the variable room
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    @Test // Add new test p2.17
    public void testSetSafe() {

        safe = room.getSafe();
        assertEquals(this.safe, safe);
    }
}
