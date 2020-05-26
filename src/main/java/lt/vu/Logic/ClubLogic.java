package lt.vu.Logic;

import lt.vu.entities.Club;
import lt.vu.entities.ClubModel;
import lt.vu.persistence.ClubDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.persistence.RollbackException;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRES_NEW;

@ApplicationScoped
public class ClubLogic {
    @Inject
    ClubDAO clubDAO;

    @Transactional
    public ClubModel getById(int id){
        return convertToModel(clubDAO.findOne(id));
    }

    @Transactional
    public List<Club> getAll(){
        return clubDAO.loadAll();
    }

    @Transactional(REQUIRES_NEW)
    public ClubModel update(int id, ClubModel updatedClub) throws RollbackException{
        Club clubToUpdate = clubDAO.findOne(id);
        if(clubToUpdate.getVersion() == null) clubToUpdate.setVersion(1);
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        clubToUpdate.setName(updatedClub.getName());

        try {
            clubToUpdate = clubDAO.update(clubToUpdate);
            return convertToModel(clubToUpdate);
        }catch(RollbackException e){
            if (e.getCause() instanceof OptimisticLockException) {
                System.out.println("Optimistic Lock Exception, retrying...");
                update(id, updatedClub);
            }
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public ClubModel insert(ClubModel clubModel){
        Club clubToAdd = new Club();

        clubToAdd.setId(clubModel.getId());
        clubToAdd.setName(clubModel.getName());

        clubDAO.insert(clubToAdd);

        return convertToModel(clubToAdd);
    }

    private ClubModel convertToModel(Club club){
        ClubModel model = new ClubModel();

        model.setId(club.getId());
        model.setName(club.getName());

        return model;
    }
}
