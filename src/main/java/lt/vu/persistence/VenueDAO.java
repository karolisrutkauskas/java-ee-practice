package lt.vu.persistence;

import lt.vu.entities.Venue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class VenueDAO {
    @Inject
    private EntityManager em;

    public void persist(Venue venue){
        this.em.persist(venue);
    }

    public Venue findOne(Integer id){
        return em.find(Venue.class, id);
    }

    public Venue update(Venue venue){
        return em.merge(venue);
    }
    public List<Venue> loadAll() {
        return em.createNamedQuery("Venue.findAll", Venue.class).getResultList();
    }
}
