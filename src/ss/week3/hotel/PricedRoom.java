package ss.week3.hotel;

import ss.week3.bill.Bill;

public class PricedRoom extends Room implements Bill.Item{
    public int roomNumber;
    public double roomPrice;
    public double safePrice;
    public PricedSafe pricedSafe;

    public PricedRoom(int roomNumber, double roomPrice, double safePrice){
        super(roomNumber, new PricedSafe(safePrice));
        this.roomNumber = super.getNumber();
        this.roomPrice = roomPrice;
        this.safePrice = safePrice;
    }

    @Override
    public double getPrice() {
        return this.roomPrice;
    }

    public String toString(){
        return String.format("The price of the room is %.2f per night",this.roomPrice);
    }

}