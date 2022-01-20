package ss.week3.hotel;

import ss.week3.bill.Bill;
import ss.week3.password.Password;

public class PricedSafe extends Safe implements Bill.Item{
    private Password passWord;
    private double price;

    public PricedSafe(double price) {
        this.price = price;
        this.passWord = new Password(); // je creeert een nieuw password
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void activate(String passWord){
//        assert this.passWord.testWord(passWord);
//        System.out.println(this.passWord.testWord(passWord));
        if(this.passWord.testWord(passWord)) {
            super.activate();
        }
    }

    public void activate(){
        System.out.println("Active");
    }

    public void deactivate(){
        super.close();
        super.deactivate();
    }

    public void open(String passWord){
//        assert this.passWord.equals(passWord);
        if(this.passWord.testWord(passWord)) {
            super.open();
        }

    }

    public void close(){
        super.close();
    }

    public Password getPassword(){
        return this.passWord;
    }

    public String toString() {
        return String.format("This safe is: %s",getPrice());
    }

//    public static void main(String[] args){
//        PricedSafe newSafe = new PricedSafe(6.30);
//        newSafe.activate("WrongPassword");
//    }

}