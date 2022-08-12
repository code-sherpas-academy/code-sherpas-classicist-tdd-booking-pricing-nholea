package sample;

import java.util.Random;

public class TravelRateRepository {

    public Double getTravelRate(String travelId) {

        return new Random().nextDouble();
    }
}
