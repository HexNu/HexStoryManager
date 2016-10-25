package nu.hex.story.manager.api.resource;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.service.command.person.GetAllPersonsCommand;
import nu.hex.story.manager.service.command.person.GetFamilyTreeForPersonCommand;
import nu.hex.story.manager.service.command.person.GetFamilyTreeFromAncestorsXmlCommand;
import nu.hex.story.manager.service.command.person.GetPersonCommand;
import nu.hex.story.manager.dto.out.GetFamilyTreeDTO;
import nu.hex.story.manager.dto.out.GetListedPersonDTO;
import nu.hex.story.manager.dto.out.GetPersonDTO;
import nu.hex.story.manager.dto.out.GetPortraitDTO;
import se.digitman.lightxml.XmlDocument;

/**
 * Created 2016-jun-28
 *
 * @author hl
 */
@Path("persons")
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAsJSON() {
        XmlDocument doc = commandExecutor().execute(new GetAllPersonsCommand());
        List<GetListedPersonDTO> result = DTOFactory().createGetPersonDTOList(doc);
        return Response.ok(result).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getAllAsXML() {
        XmlDocument doc = commandExecutor().execute(new GetAllPersonsCommand());
        return Response.ok(doc.toString()).build();
    }

    @GET
    @Path("{id}/family")
    @Produces(MediaType.APPLICATION_XML)
    public Response getFamilyTreeXML(@PathParam("id") Long personId) {
        XmlDocument doc = getFamilyTreeForPersonXml(personId);
        return Response.ok(doc.toString()).build();
    }

    @GET
    @Path("family/{mother}/{father}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getFamilyTreeXML(@PathParam("mother") Long motherId, @PathParam("father") Long fatherId) {
        XmlDocument doc = getFamilyTreeXml(motherId, fatherId);
        return Response.ok(doc.toString()).build();
    }

    @GET
    @Path("family/{mother}/{father}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFamilyTreeJson(@PathParam("mother") Long motherId, @PathParam("father") Long fatherId) {
        XmlDocument doc = getFamilyTreeXml(motherId, fatherId);
        GetFamilyTreeDTO result = DTOFactory().createFamilyTreeDTO(doc);
        return Response.ok(result).build();
    }

    @GET
    @Path("family/{mother}/{father}/file")
    @Produces(MediaType.APPLICATION_XML)
    public Response getFamilyTreeFile(@PathParam("mother") Long motherId, @PathParam("father") Long fatherId) {
        XmlDocument result = getFamilyTreeXml(motherId, fatherId);
        String fileName = result.getRoot().getAttribute("for") + ".hex";
        return Response.ok((Object) result.toString())
                .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                .build();
    }

    private XmlDocument getFamilyTreeXml(Long motherId, Long fatherId) {
        Person mother = commandExecutor().execute(new GetPersonCommand(motherId));
        Person father = commandExecutor().execute(new GetPersonCommand(fatherId));
        XmlDocument doc = commandExecutor().execute(new GetFamilyTreeFromAncestorsXmlCommand(mother, father));
        return doc;
    }

    private XmlDocument getFamilyTreeForPersonXml(Long personId) {
        Person person = commandExecutor().execute(new GetPersonCommand(personId));
        XmlDocument doc = commandExecutor().execute(new GetFamilyTreeForPersonCommand(person));
        return doc;
    }
}
