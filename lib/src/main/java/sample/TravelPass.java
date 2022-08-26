package sample;

public class TravelPass {

    public Double getTravelPassRate(String travelId, int travelTime) {
        double travelRatePass = 0.;
        if (travelTime> 2.){
            travelRatePass = (2 * 0.16) +((travelTime-2) * 0.18);

        }else {
            travelRatePass = 0.16 + 0.18;
        }
        return travelRatePass;
    }
}
