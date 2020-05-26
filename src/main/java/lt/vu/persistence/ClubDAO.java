package lt.vu.persistence;

import lt.vu.entities.Club;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ClubDAO {
    @Inject
    private EntityManager em;

    public void persist(Club club){
        this.em.persist(club);
    }

    public Club findOne(Integer id){
        return em.find(Club.class, id);
    }

    public Club update(Club club){
        return em.merge(club);
    }

    public Club insert(Club club){
        em.persist(club);
        return club;
    }

    public List<Club> loadAll() {
        return em.createNamedQuery("Club.findAll", Club.class).getResultList();
    }
}
