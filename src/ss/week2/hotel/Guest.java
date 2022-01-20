package ss.week2.hotel;

/**
 * From the HTML file the following methods are demanded: \n
 * Modifier and Type        	Method      	        Description \n
 * boolean	                    checkin(Room room)      Rents a Room to this Guest.
 * boolean	                    checkout()	            Sets the Room of this Guest to null.
 * java.lang.String	            getName()	            Returns the name of this Guest.
 * Room	                        getRoom()	            Returns the Room that is rented by this Guest.
 * java.lang.String             toString()
 */

public class Guest {
    private String name;
    public Room room;

// Build the contructor as  shown in the HTML link
    public Guest(String name){ //Constructor bouwen voor nieuwe gast invoor
    this.name = name; //Paars is goed This. is om ervoor te zorgen dat alles soepel loopt

    } //Einde constructor

 // Build methods as shown in  HTML

    // Returns the name of this Guest
    /*@ pure  */   public String getName(){

        return this.name;
    }

    // Room rented by this Guest; null if this Guest does not rent a room
    /*@ pure  */    public Room getRoom(){
        return room;
    }

    // Rents a Room to this Guest (boolean)

   /*@ requires Room.room;
        ensures return == true || false;
   */
   public boolean checkin(Room room) {
        if (this.room == null && room.getGuest() == null) {
            this.room = room;
            room.setGuest(this);
            return true;
        }
        return false;
    }

    // Sets the Room of this Guest to null (boolean)

    /*@ ensures return == true || false;
   */

    public boolean checkout(){
        if( this.room != null && this.room.getGuest() == this){
            this.room.setGuest(null);
            this.room = null;
            return true;
        }

        return false;
    }

    /**
     * P2-15, add method to GUEST/Rome
     * @return Guest = guest
     */
     public String toString(){
        return new String("Guest = " + this.name);
    }

}
