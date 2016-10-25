package nu.hex.story.manager.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.service.command.portrait.GetPortraitCommand;
import nu.hex.story.manager.dto.out.GetPortraitDTO;

/**
 * Created 2016-jun-29
 *
 * @author hl
 */
@Path("portraits")
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

    @GET
    @Path("{id}/file")
    public Response getPortraitFile(@PathParam("id") Long id) {
        Portrait portrait = commandExecutor().execute(new GetPortraitCommand(id));
        GetPortraitDTO result = DTOFactory().createGetPortraitDTO(portrait);
        return Response.ok(result.getImage().getData(), result.getImage().getMediaType())
                .header("Content-Disposition", "attachment; filename=\"" + result.getImage().getName() + "\"")
                .build();
    }

}
