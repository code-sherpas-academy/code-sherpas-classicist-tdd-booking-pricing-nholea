package sample;

import java.util.Random;

public class TravelTimeCalculator {

    public Integer getTravelTime (String travelId) {

        return new Random().nextInt(2000) / 60;
    }


    public static void main (String[] args){
        System.out.println(new TravelTimeCalculator().getTravelTime("5500"));
    }
}
