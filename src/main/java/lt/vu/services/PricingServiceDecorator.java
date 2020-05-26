package lt.vu.services;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class PricingServiceDecorator implements IVenuePricingService {
    @Inject
    @Delegate
    IVenuePricingService pricingService;


    @Override
    public double countPricingForVenue(int numberOfDaysPerWeek) {
        return pricingService.countPricingForVenue(numberOfDaysPerWeek) / 2;
    }
}
