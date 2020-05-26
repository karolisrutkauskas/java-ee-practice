package lt.vu.services;

import javax.enterprise.inject.Alternative;

public class ExpensiveVenuePricingService implements IVenuePricingService {

    @Override
    @Alternative
    public double countPricingForVenue(int numberOfDaysPerWeek) {
        return numberOfDaysPerWeek * 200;
    }
}
