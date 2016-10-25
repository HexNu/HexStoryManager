package nu.hex.story.manager.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.service.command.atlas.GetAtlasCommand;
import nu.hex.story.manager.service.command.atlas.GetMapCommand;
import nu.hex.story.manager.dto.out.GetAtlasDTO;
import nu.hex.story.manager.dto.out.GetMapDTO;

/**
 * Created 2016-okt-14
 *
 * @author hl
 */
@Path("atlases")
public class AtlasResource extends AbstractResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAtlas(@PathParam("id") Long id) {
        Atlas atlas = commandExecutor().execute(new GetAtlasCommand(id));
        GetAtlasDTO result = DTOFactory().createGetAtlasDTO(atlas);
        return Response.ok(result).build();
    }

    @GET
    @Path("maps/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMap(@PathParam("id") Long id) {
        AtlasMap atlas = commandExecutor().execute(new GetMapCommand(id));
        GetMapDTO result = DTOFactory().createGetMapDTO(atlas);
        return Response.ok(result).build();
    }

    @GET
    @Path("maps/{id}/image")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMapImage(@PathParam("id") Long id) {
        AtlasMap atlas = commandExecutor().execute(new GetMapCommand(id));
        GetMapDTO result = DTOFactory().createGetMapDTO(atlas);
        return Response.ok(result.getImage().getData(), result.getImage().getMediaType()).build();
    }

    
}
