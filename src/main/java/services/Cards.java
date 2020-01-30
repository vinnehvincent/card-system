package services;

import model.Card;
import persistence.CardDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cards")
public class Cards {
    public Cards(){}
    @Path("/ping")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping(){
        return Response.ok().entity("Service is up!").build();
    }
    @Path("/create")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response  createCard(){
        Card card = new Card();
        try{
            CardDao cardDao = new CardDao();
            cardDao.save(card);
        }
        catch (Exception e){
            return Response.notModified().entity(e.getMessage()).build();
        }
        return Response.ok().entity(card).build();
    }
}
