package sample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelPriceCalculatorTest {

    @Test
    void calculate_price_first_case () {
         TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
         TravelRateRepository travelRateRepository = new TravelRateRepository();
         TravelDiscountRepository travelDiscountRepository = new TravelDiscountRepository();

        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);

        Double price = travelPriceCalculator.getPrice("55");

        Assertions.assertThat(price).isEqualTo(3.0);
    }

}