package ss.week3.hotel;

/**
 * @author Elisa Verhoeven
 */

public class Guest {

    private String name;
    private Room room;

    /**
     * Creates a guest with a given name without a room.
     * @requires name instanceof String;
     */
    public Guest(String name){
        this.name = name;
        this.room = null;
    }

    /**
     * @return name of the guest
     * @requires this.name instanceof String;
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return Room rented by this guest; if this guest does not rent a room use null
     * @requires this.room instanceof Room;
     * @ensures this.room == null ==> \result == null;
     * @ensures this.room != null ==> \result == this.room;
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * @return true of the checkin succeeded; false if this guest already had a room, or room already had a guest.
     * @requires room instanceof Room;
     * @ensures this.getRoom() == null && room.getGuest() == null ==> \result == true;
     * @ensures this.getRoom() != null || room.getGuest() != null ==> \result == false;
     */
    public boolean checkin(Room room) {
        if (room.getGuest() == null) {
            this.room = room;
            room.setGuest(this);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return true if this action succeeded; false if guest does not have a room when this method is called.
     * @ensures this.room == null ==> \result == false;
     * @ensures this.room != null ==> \result == true;
     */
    public boolean checkout() {
        if (this.room == null) {
            return false;
        }
        else {
            room.setGuest(null);
            room.getSafe().deactivate();
            this.room = null;           // Ik had ze andersom staan (boven setguest). Dat is geen goed plan.
            return true;
        }
    }

    public String toString() {
        return "Guest " + this.name;
    }




}