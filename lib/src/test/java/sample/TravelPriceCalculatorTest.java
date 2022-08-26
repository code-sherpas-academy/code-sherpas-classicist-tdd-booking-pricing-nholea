package sample;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TravelPriceCalculatorTest {

    @Mock
    TravelTimeCalculator travelTimeCalculator;
    @Mock
    TravelDiscountRepository travelDiscountRepository;
    @Mock
    TravelRateRepository travelRateRepository;
    @InjectMocks
    TravelPriceCalculator travelPriceCalculator;

    String travelId = "456";
    @Test
    void given_a_travel_time_in_minutes_and_a_travel_rate_return_a_travel_price() {
        when(travelTimeCalculator.getTravelTime(travelId)).thenReturn(15);
        when(travelRateRepository.getTravelRate(travelId)).thenReturn(0.2);

        assertThat(travelTimeCalculator.getTravelTime(travelId) * travelRateRepository.getTravelRate(travelId)).isEqualTo(3.0);
    }

    @Test
    void given_a_travel_time_rounded_in_minutes_and_a_travel_rate_return_a_travel_price() {
        when(travelTimeCalculator.getTravelTime(travelId)).thenReturn(3);
        when(travelRateRepository.getTravelRate(travelId)).thenReturn(0.2);

        assertThat(Precision.round(travelTimeCalculator.getTravelTime(travelId) * travelRateRepository.getTravelRate(travelId), 2)).isEqualTo(0.6);
    }

    @Test
    void given_a_travel_time_in_minutes_less_than_1_and_a_travel_rate_return_0() {
        when(travelTimeCalculator.getTravelTime(travelId)).thenReturn(0);
        when(travelRateRepository.getTravelRate(travelId)).thenReturn(0.2);

        assertThat(Precision.round(travelTimeCalculator.getTravelTime(travelId) * travelRateRepository.getTravelRate(travelId), 2)).isEqualTo(0.0);
    }
    @Test
    void given_a_travel_time_in_minutes_a_travel_rate_and_a_travel_discount_percentage_return_a_travel_price_with_travel_discount_applied(){
        when(travelTimeCalculator.getTravelTime(travelId)).thenReturn(3);
        when(travelRateRepository.getTravelRate(travelId)).thenReturn(0.2);
        when(travelDiscountRepository.getTravelDiscount(travelId)).thenReturn(0.8);

        assertThat(Precision.round(travelTimeCalculator.getTravelTime(travelId) * travelRateRepository.getTravelRate(travelId) *travelDiscountRepository.getTravelDiscount(travelId), 2)).isEqualTo(0.48);
    }

    @Test
    void given_a_travel_time_in_minutes_and_a_percentage_discount_travel_rate_return_a_travel_price(){
        int percentageDiscount = 10;

        when(travelTimeCalculator.getTravelTime(travelId)).thenReturn(3);
        when(travelRateRepository.getTravelRate(travelId,percentageDiscount)).thenReturn(0.18);

        assertThat(Precision.round( travelTimeCalculator.getTravelTime(travelId) * travelRateRepository.getTravelRate(travelId,percentageDiscount),2)).isEqualTo(0.54);
    }

}