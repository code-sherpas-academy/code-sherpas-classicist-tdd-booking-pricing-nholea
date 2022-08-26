package sample;

import org.apache.commons.math3.util.Precision;

public class TravelPriceCalculator {

    private final TravelTimeCalculator travelTimeCalculator;
    private final TravelRateRepository travelRateRepository;
    private final TravelDiscountRepository travelDiscountRepository;

    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator, TravelRateRepository travelRateRepository){
        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;
        this.travelDiscountRepository = null;

    }

    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator,
                                 TravelRateRepository travelRateRepository,
                                 TravelDiscountRepository travelDiscountRepository
    ) {

        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;
        this.travelDiscountRepository = travelDiscountRepository;

    }


    public Double getPrice(String travelId) {
        int travelTime = travelTimeCalculator.getTravelTime(travelId);
        Double travelRate = travelRateRepository.getTravelRate(travelId);
        Double travelDiscount = travelDiscountRepository.getTravelDiscount(travelId);

        if(travelDiscountRepository != null) {
            return Precision.round(travelTime * travelRate * travelDiscount, 2);

        }
        return Precision.round(travelTime * travelRate,2);

    }


}
