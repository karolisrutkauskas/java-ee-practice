package lt.vu.rest;

import lt.vu.Logic.ClubLogic;
import lt.vu.entities.Club;
import lt.vu.entities.ClubModel;

import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.persistence.RollbackException;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("clubs")
public class ClubController {
    @Inject
    ClubLogic clubLogic;

    @Path("/{id}")
    @GET
    @Produces({"application/json"})
    public Response Get(@PathParam("id") int clubId){
        ClubModel club = clubLogic.getById(clubId);

        if(club == null)
            return Response.status(404).build();

        return Response.ok(club).build();
    }

    @Path("/")
    @GET
    @Produces({"application/json"})
    public Response Get(){

        return Response.ok(clubLogic.getAll()).build();
    }

    @Path("/{id}")
    @PUT
    public Response Put(@PathParam("id") int clubId, @Valid ClubModel updatedClub){
//        try {
            ClubModel club = clubLogic.update(clubId, updatedClub);
            if(club == null){
                return Response.status(404).build();
            }
            return Response.ok(club).build();
//        }catch(RollbackException e){
//            if (e.getCause() instanceof OptimisticLockException) {
//                return Put(clubId, updatedClub);
//            }
//            else {
//                throw new RuntimeException(e);
//            }
//        }
    }

    @Path("/")
    @POST
    public Response Post(ClubModel club){
        clubLogic.insert(club);
        return Response.ok().build();
    }
}
