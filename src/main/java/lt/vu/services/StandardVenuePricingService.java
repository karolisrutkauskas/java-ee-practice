package lt.vu.services;

public class StandardVenuePricingService implements IVenuePricingService {

    @Override
    public double countPricingForVenue(int numberOfDaysPerWeek) {
        return numberOfDaysPerWeek * 100;
    }
}
