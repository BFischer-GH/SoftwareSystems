package ss.week2.hotel;

public class Hotel {

private Guest guest;
private Room room1 = new Room(101);
private Room room2 = new Room(102);


private String hotelname;
public Hotel(String name){
    this.hotelname = name;
}
 /*
 * A command checkIn that receives one String object as parameter, indicating the name of the
 * guest. The method returns a Room object with a (new) Guest of the given name checked in, or null
 * in case there is already a guest with this name or the hotel is full.
 * • A command checkOut that receives the name of a guest as a parameter. The guest is checked out,
 * and the safe in the room is deactivated. Nothing happens if there is no guest with this name.
 * • A query getFreeRoom that returns the Room into which the guest can checked in, or null if there is
 * no free room available.
 * • A query getRoom that receives the name of a guest as parameter, returning the Room object into
 * which the guest has checked in, or null if the guest cannot be found in any room.
 * • A query toString that gives a textual description of all rooms in the hotel, including the name of
 * the guest and the status of the safe in that room.
 * Additionally, the hotel should have an instance variable name with an appropriate query. This instance
 * variable is set when the object is initialised. <= constructor?
  */



    public Room checkIn(String name){
        guest = new Guest(name);

        if(guest.checkin(room1)){
            return room1;
        } else if (guest.checkin(room2)) {
            return room2;
        }
        return null;

    } // end of checkIn

    public void checkOut(String name){
        if (room1.getGuest() != null && room1.getGuest().getName().equals(name)){
            room1.getSafe().deactive();
            room1.getGuest().checkout();
            room1.setGuest(null);
            }
        else if (room2.getGuest() != null && room2.getGuest().getName().equals(name)) {
            room2.getSafe().deactive();
            room2.getGuest().checkout();
            room2.setGuest(null);
        }

    } // end of checkOut

    public Room getFreeRoom(){
        if (room1.getGuest() == null) {
            return room1;
        }
        else if (room2.getGuest() == null) {
            return room2;

        }
        return null;
    } // end of getFreeRoom
//*
    public Room getRoom(String name){
    if ( room1.getGuest() != null && room1.getGuest().getName().equals(name)) {
        return room1;
    } else if (room2.getGuest() != null && room2.getGuest().getName().equals(name)){
        return room2;
    }
    return null;

    } // end of getRoom
    public String toString() {

        return  "Room 1" + room1.getGuest() + " Safe Active: " + room1.getSafe().isActive() + " Safe Open: " + room1.getSafe().isOpen() + "\n" +
                "Room 2" + room2.getGuest() + " Safe Active: " + room2.getSafe().isActive() + " Safe Open: " + room2.getSafe().isOpen();

    }
}
