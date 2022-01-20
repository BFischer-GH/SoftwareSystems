package ss.week1;

import ss.utils.TextIO;

public class ThreeWayLamp {


    public enum LampSetting {
        OFF, LOW,MEDIUM, HIGH
    }
    public static LampSetting Status = LampSetting.OFF; //Create the variable Status for enum Lampsetting and set Status to OFF

    public static void switchSetting() {
        switch (Status) {
            case OFF:
                Status = LampSetting.LOW;
                System.out.println("The lamp is now set to: " + Status);
                break;
            case LOW:
                Status = LampSetting.MEDIUM;
                System.out.println("The lamp is now set to: " + Status);
                break;
            case MEDIUM:
                Status = LampSetting.HIGH;
                System.out.println("The lamp is now set to: " + Status);
                break;
            case HIGH:
                Status = LampSetting.OFF;
                System.out.println("The lamp is now set to: " + Status);
                break;

        }
    }

    public static LampSetting getSetting() {

        return Status;
    }

    public static void setLampSetting(LampSetting Input) {
        switch (Input) {
            case OFF:
                Status = LampSetting.OFF;
                break;
            case LOW:
                Status = LampSetting.LOW;
                break;
            case MEDIUM:
                Status = LampSetting.MEDIUM;
                break;
            case HIGH:
                Status = LampSetting.HIGH;
                break;
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("This is the Three Way Lamp. Please type an input for the lamp or type HELP for more information.");
            String Input = TextIO.getlnString();
            switch (Input) {
                case "OFF":
                    setLampSetting(LampSetting.OFF);
                    System.out.println("The lamp is now set to: " + Status);
                    break;
                case "LOW":
                    setLampSetting(LampSetting.LOW);
                    System.out.println("The lamp is now set to: " + Status);
                    break;
                case "MEDIUM":
                    setLampSetting(LampSetting.MEDIUM);
                    System.out.println("The lamp is now set to: " + Status);
                    break;
                case "HIGH":
                    setLampSetting(LampSetting.HIGH);
                    System.out.println("The lamp is now set to: " + Status);
                    break;
                case "STATE":
                    System.out.println("The light is currently set to :" + Status);
                    break;
                case "NEXT":
                    switchSetting();
                    break;
                case "HELP":
                    System.out.println("Set lamp status to the following by typing: OFF ,LOW , MEDIUM or HIGH ");
                    System.out.println("To see the current state of the lamp type: STATE");
                    System.out.println("To switch to the next state type: NEXT");
                    System.out.println("To show this menu type: HELP");
                    System.out.println("To end this program type: EXIT");
                    break;
                case "EXIT":
                    System.exit(0);
                default:
                    System.out.println("Input not valid");
                    break;
            }
        }
    }
}