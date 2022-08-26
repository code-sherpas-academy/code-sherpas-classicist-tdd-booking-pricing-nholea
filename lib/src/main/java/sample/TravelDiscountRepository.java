package sample;

import org.apache.commons.math3.util.Precision;

import java.util.Random;

public class TravelDiscountRepository {

    public Double getTravelDiscount (String travelId) {
        double randomDiscount = Precision.round(new Random().nextDouble(),2);

        return 1-randomDiscount;
    }
}
