package sample;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TravelPriceCalculatorTest {

    @Mock
    TravelTimeCalculator travelTimeCalculator;
    @Mock
    TravelDiscountRepository travelDiscountRepository;
    @Mock
    TravelRateRepository travelRateRepository;
    @InjectMocks
    TravelPriceCalculator travelPriceCalculator;


    @Test
    void calculate_price_first_case () {
        travelPriceCalculator.getPrice("456");
        when(travelTimeCalculator.getTravelTime("456")).thenReturn(15);
        when(travelRateRepository.getTravelRate("456")).thenReturn(0.2);
        assertThat(travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456")).isEqualTo(3.0);
    }

    @Test
    void calculate_price_second_case () {
        when(travelTimeCalculator.getTravelTime("456")).thenReturn(3);
        when(travelRateRepository.getTravelRate("456")).thenReturn(0.2);
        assertThat(Precision.round(travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456"),2)).isEqualTo(0.6);
    }

    @Test
    void calculate_price_third_case () {
        when(travelTimeCalculator.getTravelTime("456")).thenReturn(0);
        when(travelRateRepository.getTravelRate("456")).thenReturn(0.2);
        assertThat(Precision.round(travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456"),2)).isEqualTo(0.0);
    }

    @Test
    void calculate_price_fourth_case () {
        when(travelTimeCalculator.getTravelTime("456")).thenReturn(3);
        when(travelRateRepository.getTravelRate("456")).thenReturn(0.2);
        when(travelDiscountRepository.getTravelDiscount("456")).thenReturn(0.8);
        assertThat(Precision.round(travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456"),2)).isEqualTo(0.6);
        assertThat(Precision.round((travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456")) * travelDiscountRepository.getTravelDiscount("456"),2)).isEqualTo(0.48);
        //when(travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456")).thenReturn(0.6);
        //when((travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456")) * travelDiscountRepository.getTravelDiscount("456")).thenReturn(0.48);
    }

    @Test
    void calculate_price_fifth_case () {
        when(travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456")).thenReturn(0.6);
        when((travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456")) * travelDiscountRepository.getTravelDiscount("456")).thenReturn(0.48);
    }

}