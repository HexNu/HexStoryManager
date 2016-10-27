package nu.hex.story.manager.api.rpg.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.hex.story.manager.api.resource.AbstractResource;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
@Path("rpg/coc")
public class CoCResource extends AbstractResource {

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCharacterJson(@PathParam("id") Long id) {
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Response getCharacterXml(@PathParam("id") Long id) {

        return Response.ok().build();
    }
}
