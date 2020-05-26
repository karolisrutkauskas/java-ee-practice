package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Club;
import lt.vu.entities.Person;
import lt.vu.entities.Venue;
import lt.vu.persistence.VenueDAO;
import lt.vu.services.IVenuePricingService;
import lt.vu.services.LongCalculationsService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Model
public class Venues {
    @Inject
    VenueDAO venueDAO;

    @Inject
    IVenuePricingService pricingService;

    @Getter
    private List<Venue> allVenues;

    @PostConstruct
    public void init(){
        loadAllVenues();
    }

    private void loadAllVenues(){
        this.allVenues = venueDAO.loadAll();
    }

    @Transactional
    public String calculateVenuePrice(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int venueId = Integer.parseInt(requestParameters.get("id"));
        int daysPerWeek = Integer.parseInt(requestParameters.get("days"));

        CompletableFuture<Double> calculating = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return pricingService.countPricingForVenue(daysPerWeek);
        });

        return "venues?faces-redirect=true&id=" + venueId;
    }
}
