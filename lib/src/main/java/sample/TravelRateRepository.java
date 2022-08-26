package sample;

import java.util.Date;
import java.util.Random;
import org.apache.commons.math3.util.Precision;

public class TravelRateRepository {


    public Double getTravelRate(String travelId) {

        return Precision.round(new Random().nextDouble(),2);
    }


}
