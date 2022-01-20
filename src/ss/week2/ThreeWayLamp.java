package ss.week2;

import ss.utils.TextIO;

public class ThreeWayLamp {

    public enum States {
        OFF, LOW,MEDIUM, HIGH,
    }

    public enum Commands {
        STATE, NEXT, HELP
    }
    private boolean exit = false;
    private static final States defaultState = States.OFF;
    //@ private invariant defaultState == States.OFF;

    private States LampSetting = defaultState;


    public void getInput() {
        this.printMenu();
        while(!exit) {
            System.out.println("Enter command: ");
            String input = TextIO.getlnString();

            switch (input) {
                case "OFF":
                    this.setLampSetting(States.OFF);
                    break;
                case "LOW":
                    this.setLampSetting(States.LOW);
                    break;
                case "MEDIUM":
                    this.setLampSetting(States.MEDIUM);
                    break;
                case "HIGH":
                    this.setLampSetting(States.HIGH);
                    break;
                case "STATE":
                    this.getSetting();
                    System.out.println("The current state is: " + this.LampSetting);
                    break;
                case "NEXT":
                    this.switchSetting();
                    break;
                case "HELP":
                    this.printMenu();
                    break;
                case "EXIT":
                    this.exit = true;
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }
    }


    // returns the current state of the lamp
    /**
     * @ensures \result instanceof States;
     * @ensures \result == this.LampSetting;
     */
    public States getSetting() {
        return this.LampSetting;
    }

    // prints the menu of the options
    /*@
       requires this.LampSetting == States.HELP;
    */
    public void printMenu() {
        System.out.println("The lamp settings are: " + java.util.Arrays.asList(States.values()));
        System.out.println("Other commands are: " + java.util.Arrays.asList(Commands.values()));
    }


    /**
     * @requires newState instanceof States;
     * @ensures this.LampSetting == newState;
     */
    public States setLampSetting(States newState) {
        return this.LampSetting = newState;
    }
    // Changes the state of the lamp

    /**
     * @ensures \old(this.LampSetting) == States.OFF ==> this.LampSetting = States.LOW;
     * @ensures \old(this.LampSetting) == States.LOW ==> this.LampSetting = States.MEDIUM;
     * @ensures \old(this.LampSetting) == States.MEDIUM ==> this.LampSetting = States.HIGH;
     * @ensures \old(this.LampSetting) == States.HIGH ==> this.LampSetting = States.OFF;
     */
    public void switchSetting() {
        switch (LampSetting) {
            case OFF:
                this.LampSetting = States.LOW;
                break;
            case LOW:
                this.LampSetting = States.MEDIUM;
                break;
            case MEDIUM:
                this.LampSetting = States.HIGH;
                break;
            case HIGH:
                this.LampSetting = States.OFF;
                break;
        }
    }
    // Changes the lamp setting to the next state.

    public static void main(String[] args) {
        ThreeWayLamp lamp = new ThreeWayLamp();
        lamp.getInput();
    }

}