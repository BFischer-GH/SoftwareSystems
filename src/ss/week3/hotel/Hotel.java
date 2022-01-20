package ss.week3.hotel;

import ss.week3.bill.Bill;

import java.util.ArrayList;


public class Hotel {

    public final String name;
    public static final int MAX_ROOMS = 2;
    private final ArrayList<Room> storedRooms = new ArrayList<>();
    private final ArrayList<Guest> storedGuests = new ArrayList<>();
    public PricedRoom pricedRoom;
    public static final double ROOM_PRICE = 100.00;
    public static final double SAFE_PRICE = 5.50;

    public Hotel(String name) {
        this.name = name;
        this.pricedRoom = new PricedRoom(0, ROOM_PRICE, SAFE_PRICE);
    }

    /**
     * @param name
     * @return Room object with a new Guest of the given name
     * @return  returns null
     */
    public Room checkIn(String name) {
        if (getRoom(name) == null && getFreeRoom() != null) {       //storedRooms.size() <= maxRooms
            Guest guest = new Guest(name);
            Room room = this.getFreeRoom();                        // Room room = new Room(storedRooms.size());
            guest.checkin(room);                                   // Deze was eerst ook anders
            storedRooms.add(room);
            storedGuests.add(guest);
            System.out.printf("Guest %s was succesfully checked in in room %d%n",name,room.getNumber());
            return room;
        }
        else {
            System.out.println("Hotel is fully booked");
            return null;
        }
    }

    public void checkOut(String name) {
        for(int i = 0; i < storedGuests.size(); i++) {
            if (storedGuests.get(i).getName().equals(name)) {
                System.out.printf("Guest %s was succesfully checked out of room %d%n",storedGuests.get(i).getName(),storedRooms.get(i).getNumber());
                storedGuests.get(i).checkout();
                storedRooms.remove(i);  // hier kan een foutje in zitten
                storedGuests.remove(i);
            }
        }
    }

    public Room getFreeRoom() {
        if (storedRooms.size() < MAX_ROOMS && storedRooms.size() != 0) {
            ArrayList<Integer> roomNumbers = new ArrayList<Integer>();
            for(int i = 0; i < storedRooms.size(); i++) {
                roomNumbers.add(storedRooms.get(i).getNumber());
            }
            for(int i = 0; i <= MAX_ROOMS; i++) {
                if(!roomNumbers.contains(i)) {
                    return new Room(i);                     // waarom moet hier niet Room room = new Room(i);?
                }
            }
        }
        else if (storedRooms.size() == 0) {
//            return new PricedRoom(0,ROOM_PRICE,SAFE_PRICE);
            return this.pricedRoom;
//            return new Room(0);  //????????????????
        }
        else {
            return null;
        }
        return null;
    }

    public Room getRoom(String name) {
        if (storedGuests.size() != 0) {
            for (int i = 0; i < this.storedRooms.size(); i++) {
                if (storedGuests.get(i).getName().equals(name)) {
                    System.out.format("Guest %s currently stays in room %d %n", name, storedRooms.get(i).getNumber());
                    return storedGuests.get(i).getRoom();
                }
            }
        }
        return null;
    }

    public String toString() {
        String output = String.format("The Hotel %s contains: %n", this.name);
        for (int i = 0; i < storedRooms.size(); i++) {
            if (storedRooms.get(i).getSafe().isActive()) {
                output += String.format("Room %d is occupied by Guest %s and the safe is activated %n", storedRooms.get(i).getNumber(), storedRooms.get(i).getGuest().getName());
            }
            else if (!storedRooms.get(i).getSafe().isActive()){
                output += String.format("Room %d is occupied by Guest %s and the safe is deactivated %n", storedRooms.get(i).getNumber(), storedRooms.get(i).getGuest().getName());
            }
            else {
                output += String.format("ERROR");
            }
        }
        return output;
    }

    public Bill getBill(String guestName, int numberOfNights, ss.week3.bill.Printer printer) { // The method should return an instance of bill (inside or outside the scope?)
// create the bill, add nights(forloop) isPricedRoom, build bill inside the method.
        // first make bill, if isPricedRoom == null --> bill = null; check the type.
        // Room room = getRoom(guestName);
        Bill newBill = new Bill(printer);
        Room room = getRoom(guestName);
//        Item safe = new Item("safe", SAFE_PRICE);
        Safe safe = room.getSafe();

        if (!(room instanceof PricedRoom) || !storedGuests.contains(guestName)){
            for (int i = 0; i < numberOfNights; i++) {
                newBill.addItem((PricedRoom) room); // because pricedRoom is an item of bill

            }
            if (safe.isActive()) {
                newBill.addItem((PricedSafe) safe);
            }
            newBill.close();
            return newBill;
        } else {
            return newBill = null;
        }

    }

}