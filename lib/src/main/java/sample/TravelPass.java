package sample;

public class TravelPass {

    private final TravelTimeCalculator travelTimeCalculator;

    public TravelPass(TravelTimeCalculator travelTimeCalculator) {
        this.travelTimeCalculator = new TravelTimeCalculator();
    }

    public Double getTravelPassRate(String travelId) {
        Double travelRatePass = 0.;
        if (travelTimeCalculator.getTravelTime(travelId) > 2.){
            travelRatePass = (2 * 0.16) +((travelTimeCalculator.getTravelTime(travelId) -2) * 0.18);

        }else {
            travelRatePass = 0.16 * 0.18;
        }
        return travelRatePass;
    }
}
