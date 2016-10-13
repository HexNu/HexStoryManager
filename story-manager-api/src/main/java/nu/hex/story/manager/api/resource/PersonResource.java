package nu.hex.story.manager.api.resource;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.service.command.person.GetFamilyTreeXmlCommand;
import nu.hex.story.manager.core.service.command.person.GetPersonCommand;
import nu.hex.story.manager.dto.out.GetFamilyTreeDTO;
import nu.hex.story.manager.dto.out.GetPersonDTO;
import nu.hex.story.manager.dto.out.GetPortraitDTO;
import se.digitman.lightxml.XmlDocument;

/**
 * Created 2016-jun-28
 *
 * @author hl
 */
@Path("person")
public class PersonResource extends AbstractResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") Long id) {
        Person person = commandExecutor().execute(new GetPersonCommand(id));
        GetPersonDTO result = DTOFactory().createGetPersonDTO(person);
        return Response.ok(result).build();
    }

    @GET
    @Path("{id}/portraits")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonalPortraits(@PathParam("id") Long id) {
        Person person = commandExecutor().execute(new GetPersonCommand(id));
        List<GetPortraitDTO> result = DTOFactory().createGetPortraitsDTO(person.getPortraits());
        return Response.ok(result).build();
    }

    @GET
    @Path("family/{mother}/{father}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFamilyTree(@PathParam("mother") Long motherId, @PathParam("father") Long fatherId) {
        Person mother = commandExecutor().execute(new GetPersonCommand(motherId));
        Person father = commandExecutor().execute(new GetPersonCommand(fatherId));
        XmlDocument doc = commandExecutor().execute(new GetFamilyTreeXmlCommand(mother, father));
        GetFamilyTreeDTO result = DTOFactory().createFamilyTreeDTO(doc);
        return Response.ok(result).build();
    }
}
