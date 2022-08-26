package sample;

import org.apache.commons.math3.util.Precision;

public class TravelPriceCalculator {

    private final TravelTimeCalculator travelTimeCalculator;
    private final TravelRateRepository travelRateRepository;
    private final TravelDiscountRepository travelDiscountRepository;

    private final TravelPass travelPass;

    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator,
                                 TravelRateRepository travelRateRepository,
                                 TravelDiscountRepository travelDiscountRepository,
                                 TravelPass travelPass
    ) {

        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;
        this.travelDiscountRepository = travelDiscountRepository;
        this.travelPass = travelPass;

    }

    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator, TravelRateRepository travelRateRepository, TravelDiscountRepository travelDiscountRepository) {
        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;
        this.travelDiscountRepository = travelDiscountRepository;
        this.travelPass = null;
    }

    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator, TravelRateRepository travelRateRepository) {
        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;
        this.travelDiscountRepository = null;
        this.travelPass = null;

    }


    public Double getPrice(String travelId) {
        int travelTime = travelTimeCalculator.getTravelTime(travelId);
        Double travelRate = travelRateRepository.getTravelRate(travelId);
        Double travelDiscount = travelDiscountRepository.getTravelDiscount(travelId);
        Double travelPassRate = travelPass.getTravelPassRate(travelId, travelTime);

        if (travelDiscountRepository != null && travelPass != null) {
            return Precision.round(travelPassRate, 2);

        } else if(travelDiscountRepository != null){
            return Precision.round(travelTime * travelRate * travelDiscount, 2);
        }
        return Precision.round(travelTime * travelRate, 2);
    }


}
