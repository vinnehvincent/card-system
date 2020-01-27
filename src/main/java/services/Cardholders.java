package services;

import model.CardHolder;
import persistence.CardHolderDao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/cardholders")
public class Cardholders {
    @POST
    @Path("/create")
    public Response createCardholder(CardHolder cardHolder){
        try{
            CardHolderDao cardHolderDao = new CardHolderDao();
            cardHolderDao.save(cardHolder);
        }
        catch (Exception e){
            return Response.notModified().entity(e.getMessage()).build();
        }
        return Response.ok().entity(String.format("Cardholder %s, has been created.",cardHolder.getId())).build();
    }
}
