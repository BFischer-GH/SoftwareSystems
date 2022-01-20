package ss.week2;
import ss.utils.TextIO; //the location folder of TextIO.

public class DollarsAndCentsCounter {
    public int totaldollar;
    public int totalcents;


    public int dollars(){
        return this.totaldollar;
    }
        //The dollar count.
        //@ensures a return value that is bigger or equal to 0
    public int cents(){
        return this.totalcents;
    }
    //The cents count.
    //@ensures a return value in the range of 0 to 99
    public void add(int dollars, int cents){
        if ((this.totalcents+cents) >= 100){
            this.totalcents = (cents + this.totalcents)%100;
            this.totaldollar = dollars + this.totaldollar + 1;
        }
        else{
            this.totaldollar += dollars;
            this.totalcents += cents;
        }
    }
    //Adds the specified dollars and cents to this Counter.

    public void reset(){
        totalcents=0;
        totaldollar=0;
    }
    //Reset this Counter to 0.
    //@ensures this Counter is set to 0 dollars and 0 cents

}
