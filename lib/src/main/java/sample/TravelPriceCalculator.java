package sample;

import org.apache.commons.math3.util.Precision;

public class TravelPriceCalculator {

    private final TravelTimeCalculator travelTimeCalculator;
    private final TravelRateRepository travelRateRepository;

    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator,
                                 TravelRateRepository travelRateRepository
    ) {

        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;

    }

    public Double getPrice(String travelId) {
        return Precision.round(travelTimeCalculator.getTravelTime(travelId) * travelRateRepository.getTravelRate(travelId),1);


    }
}
