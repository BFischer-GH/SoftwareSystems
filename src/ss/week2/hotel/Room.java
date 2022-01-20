package ss.week2.hotel;

public class Room {
    private int number;
    private Guest guest;
    private Safe safe; // New safe added P2-17


    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param no number of the new <code>Room</code>
     */
    public Room(int number, Safe safe) {
    	this.number = number;
        this.safe = safe; // Added for P2-17 for constructor
    }

    // P2-17 constructor for safe in room
    public Room(int number) {
    this(number, new Safe());
    }

    /**
     * Returns the number of this Room
     */
    public int getNumber() {
    	return number;
    }

    /**
     * Returns the current guest living in this Room
     * @return the guest of this Room, null if not rented
     */
    public Guest getGuest() {
    	return guest;
    }


    /**
     * Assigns a Guest to this Room.
     * @param guest the new guest renting this Room, if null is given, Room is empty afterwards
     */
    public void setGuest(Guest guest) {
    	this.guest = guest;
    }

    /*
     * P2-15, add method to GUEST/Rome
     * @return Room = room
     */
    public String toString(){
        return "Room = " + number;
    }

    /**
     * Returns the safe of this Room
     */
    public Safe getSafe()  {return safe;}


}
