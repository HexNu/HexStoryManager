package nu.hex.story.manager.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created 2016-jul-29
 *
 * @author hl
 */
@Path("story")
public class StoryResource extends AbstractResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStory(@PathParam("id") Long id) {
//        Portrait portrait = commandExecutor().execute(new GetPortraitCommand(id));
//        GetPortraitDTO result = DTOFactory().createGetPortraitDTO(portrait);
//        return Response.ok(result).build();
        return Response.ok().build();
    }

}
