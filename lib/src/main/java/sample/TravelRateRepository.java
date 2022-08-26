package sample;

import java.util.Date;
import java.util.Random;
import org.apache.commons.math3.util.Precision;

public class TravelRateRepository {


    public Double getTravelRate(String travelId) {

        return Precision.round(new Random().nextDouble(),2);
    }

    public Double getTravelRate(String travelId, int percentageDiscount){
        double discount = 1 -(percentageDiscount / 100.);

        return Precision.round(new Random().nextDouble() * discount,2);
    }


}
