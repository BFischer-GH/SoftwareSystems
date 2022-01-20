package ss.week3.hotel;

public class Safe {
    private boolean opened;
    private boolean activated;

    public Safe() {
        this.opened = false;
        this.activated = false;
    }

    public void activate() {
        this.activated = true;
    }

    public void deactivate() {
        this.activated = false;
    }

    public void open() {
        if(this.isActive()) {
            this.opened = true;
        }
    }

    public void close() {
        this.opened = false;
    }

    public boolean isActive() {
        if (this.activated == true) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isOpen() {
        if (this.opened == true) {
            return true;
        }
        else {
            return false;
        }
    }
}