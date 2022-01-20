package ss.week2.hotel;

public class Safe {

// Create two (private) instance variables to keep information
//about whether the safe is open or closed, and activated or deactivated
    private boolean active;
    private boolean open;

// Create default constructor
    public Safe(){
        this.active = false;
        this.open = false;
    }

// Create proper (public) methods to query and
// modify these instance variable

/* Commands
* activate: without parameters, activates the safe;
* deactivate: without parameters, closes the safe and deactivates it;
* open: without parameters, opens the safe if it is active;
* close: without parameters, closes the safe (but does not change its active/inactive status).
*/
public void active() {

    this.active = true;
    }
public void deactive() {
    this.active = false;
    this.open = false;
}
public void open() {
    if(this.active){
        this.open = true;
    }
}
public void close() {
    this.open = false;
    }

/* Queries
* isActive: returns true if the safe is active, false otherwise;
* isOpen: returns true if the safe is open, false otherwise.
*/
    public boolean isOpen() {
        return open;
    }

    public boolean isActive() {
        return active;
    }

}
