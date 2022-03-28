package nu.hex.story.manager.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.hex.story.manager.core.document.docs.StoryManagerDocument;
import nu.hex.story.manager.core.domain.story.Story;
import nu.hex.story.manager.service.command.story.GetStoryCommand;
import se.digitman.lightxml.XmlDocument;

/**
 * Created 2016-jul-29
 *
 * @author hl
 */
@Path("stories")
public class StoryResource extends AbstractResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoryJSON(@PathParam("id") Long id) {
//        Portrait portrait = commandExecutor().execute(new GetPortraitCommand(id));
//        GetPortraitDTO result = DTOFactory().createGetPortraitDTO(portrait);
//        return Response.ok(result).build();
        return Response.ok().build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getStoryXML(@PathParam("id") Long id) {
        Story story = commandExecutor().execute(new GetStoryCommand(id));
        XmlDocument xmlDoc = new StoryManagerDocument(story).writeHSMF();
                String fileName = story.getTitle() + ".hsmf";
        return Response.ok((Object) xmlDoc.toString())
                .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                .build();
    }

}
