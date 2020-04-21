package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Club;
import lt.vu.entities.Person;
import lt.vu.persistence.ClubDAO;
import lt.vu.persistence.PersonDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class People {
    @Inject
    private PersonDAO personDAO;

    @Inject
    private ClubDAO clubDAO;

    @Getter
    @Setter
    private Club club;

    @Getter
    @Setter
    private Integer personSelected;

    @Getter
    @Setter
    private Person personToCreate = new Person();

    @Getter
    private List<Person> allPeople;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        System.out.println(requestParameters.size());
            Integer clubId = Integer.parseInt(requestParameters.get("clubId"));
            this.club = clubDAO.findOne(clubId);
        loadAllPeople();
    }

    private void loadAllPeople(){
        this.allPeople = personDAO.loadAll();
    }

    @Transactional
    public String createPerson(){
        this.personDAO.persist(personToCreate);
        return "allPeople?faces-redirect=true";
    }

    @Transactional
    public String editPerson(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();;
        Person person = personDAO.findOne(personSelected);
        Integer clubId = Integer.parseInt(requestParameters.get("clubId"));
        this.club = clubDAO.findOne(clubId);
        try {
            List<Club> clubs = person.getClubs();
            clubs.add(club);
            person.setClubs(clubs);
            this.personDAO.update(person);
        } catch (OptimisticLockException e) {
            return "people?faces-redirect=true&clubId=" + person.getId() + "&error=optimistic-lock-exception";
        }
        return "people?faces-redirect=true&clubId=" + this.club.getId();
    }

    @Transactional
    public String deletePersonFromClub(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer clubId = Integer.parseInt(requestParameters.get("clubId"));
        Integer personId = Integer.parseInt(requestParameters.get("personId"));
        this.club = clubDAO.findOne(clubId);
        Person person = personDAO.findOne(personId);
        System.out.println(club.getId());
        System.out.println(person.getId());
        try {
            List<Club> clubs = person.getClubs();
            clubs.remove(this.club);
            person.setClubs(clubs);
            this.personDAO.update(person);
        } catch (OptimisticLockException e) {
            return "people?faces-redirect=true&clubId=" + person.getId() + "&error=optimistic-lock-exception";
        }
        return "people?faces-redirect=true&clubId=" + this.club.getId();
    }
}
