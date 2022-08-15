package sample;

import java.util.Random;

public class TravelTimeCalculator {

    public Integer getTravelTime (String travelId) {

        int randomSecondTime = new Random().nextInt(2000);
        int randomMinuteTimes = 0;

        if (randomSecondTime < 60) {
            return 0;
        }

        if ( randomSecondTime % 60 != 0) {
            randomMinuteTimes = (randomSecondTime + 60) / 60;
        }else {
            randomMinuteTimes = randomSecondTime / 60;
        }
        return randomMinuteTimes;
    }

}
