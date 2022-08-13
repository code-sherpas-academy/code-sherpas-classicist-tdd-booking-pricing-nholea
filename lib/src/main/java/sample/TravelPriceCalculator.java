package sample;

import org.apache.commons.math3.util.Precision;

public class TravelPriceCalculator {

    private final TravelTimeCalculator travelTimeCalculator;
    private final TravelRateRepository travelRateRepository;
    private final TravelDiscountRepository travelDiscountRepository;


    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator,
                                 TravelRateRepository travelRateRepository,
                                 TravelDiscountRepository travelDiscountRepository
    ) {

        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;
        this.travelDiscountRepository = travelDiscountRepository;

    }

    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator,
                                 TravelRateRepository travelRateRepository
    ) {

        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;
        this.travelDiscountRepository = null;

    }

    public Double getPrice(String travelId) {
        if (travelDiscountRepository!=null) {
            return Precision.round((travelTimeCalculator.getTravelTime(travelId) * travelRateRepository.getTravelRate(travelId))* travelDiscountRepository.getTravelDiscount(travelId),2);
        }
        return Precision.round(travelTimeCalculator.getTravelTime(travelId) * travelRateRepository.getTravelRate(travelId),2);

    }

    public static void main(String[] args){
        System.out.println(new TravelPriceCalculator(new TravelTimeCalculator(),new TravelRateRepository()).getPrice("15"));
        System.out.println(new TravelPriceCalculator(new TravelTimeCalculator(),new TravelRateRepository(),new TravelDiscountRepository()).getPrice("15"));
    }
}
