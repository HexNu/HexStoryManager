package nu.hex.story.manager.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.hex.story.manager.core.domain.person.Portrait;
import nu.hex.story.manager.core.service.command.portrait.GetPortraitCommand;
import nu.hex.story.manager.dto.out.GetPortraitDTO;

/**
 * Created 2016-jun-29
 *
 * @author hl
 */
@Path("portrait")
public class PortraitResource extends AbstractResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPortrait(@PathParam("id") Long id) {
        Portrait portrait = commandExecutor().execute(new GetPortraitCommand(id));
        GetPortraitDTO result = DTOFactory().createGetPortraitDTO(portrait);
        return Response.ok(result).build();
    }

    @GET
    @Path("{id}/image")
    public Response getPortraitImage(@PathParam("id") Long id) {
        Portrait portrait = commandExecutor().execute(new GetPortraitCommand(id));
        GetPortraitDTO result = DTOFactory().createGetPortraitDTO(portrait);
        return Response.ok(result.getImage().getData(), result.getImage().getMediaType()).build();
    }

}
