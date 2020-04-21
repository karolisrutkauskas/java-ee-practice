package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Club;
import lt.vu.persistence.ClubDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Clubs {
    @Inject
    private ClubDAO clubDAO;

    @Getter
    @Setter
    private Club clubToCreate = new Club();

    @Getter
    private List<Club> allClubs;

    @PostConstruct
    public void init(){
        loadAllClubs();
    }

    private void loadAllClubs(){
        this.allClubs = clubDAO.loadAll();
    }

    @Transactional
    public String createClub(){
        this.clubDAO.persist(clubToCreate);
        return "clubs?faces-redirect=true";
    }
}
