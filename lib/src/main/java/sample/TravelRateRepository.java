package sample;

import java.util.Random;
import org.apache.commons.math3.util.Precision;

public class TravelRateRepository {

    public Double getTravelRate(String travelId, int ratePercentDiscount) {
    Double rateDiscount = (100 - ratePercentDiscount) /100.;
        return Precision.round(new Random().nextDouble()* rateDiscount,2) ;
    }

    public Double getTravelRate(String travelId) {

        return Precision.round(new Random().nextDouble(),2);
    }

}
