package sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TravelPriceCalculatorTest {

    @Mock
    TravelTimeCalculator travelTimeCalculator;
    @Mock
    TravelRateRepository travelRateRepository;
    @InjectMocks
    TravelPriceCalculator travelPriceCalculator;

    @Test
    void calculate_price_first_case () {
        when(travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456")).thenReturn(3.0);

    }

    @Test
    void calculate_price_second_case () {
        when(travelTimeCalculator.getTravelTime("456") * travelRateRepository.getTravelRate("456")).thenReturn(0.6);
    }

}