package nu.hex.story.manager.api.dto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.Person;
import nu.hex.story.manager.core.domain.PersonalEvent;
import nu.hex.story.manager.core.domain.Portrait;
import nu.hex.story.manager.core.domain.impl.DefaultPerson;
import nu.hex.story.manager.dto.out.GetEventDTO;
import nu.hex.story.manager.dto.out.GetFamilyTreeDTO;
import nu.hex.story.manager.dto.out.GetFamilyTreeMemberDTO;
import nu.hex.story.manager.dto.out.GetParentDTO;
import nu.hex.story.manager.dto.out.GetPersonDTO;
import nu.hex.story.manager.dto.out.GetPortraitDTO;
import se.digitman.lightxml.XmlDocument;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-jun-28
 *
 * @author hl
 */
public class DTOFactory {

    public Person createPerson(GetPersonDTO dto) {
        Person result = new DefaultPerson();
        result.setId(dto.getId());
        result.setFamilyName(dto.getFamilyName());
        result.setGivenName(dto.getGivenName());
        result.setDateOfBirth(dto.getDateOfBirth());
        result.setPlaceOfBirth(dto.getPlaceOfBirth());
        result.setDateOfDeath(dto.getDateOfDeath());
        result.setPlaceOfDeath(dto.getPlaceOfDeath());
        result.setCauseOfDeath(dto.getCauseOfDeath());
        result.setResidence(dto.getResidence());
        result.setSex(Person.Sex.getByString(dto.getSex()));
        return result;
    }

    public GetPersonDTO createGetPersonDTO(Person p) {
        GetPersonDTO result = new GetPersonDTO();
        result.setId(p.getId());
        result.setFamilyName(p.getFamilyName());
        result.setGivenName(p.getGivenName());
        result.setDateOfBirth(p.getDateOfBirth() != null ? p.getDateOfBirth().format(DateTimeFormatter.ISO_DATE) : null);
        result.setPlaceOfBirth(p.getPlaceOfBirth());
        result.setDateOfDeath(p.getDateOfDeath() != null ? p.getDateOfDeath().format(DateTimeFormatter.ISO_DATE) : null);
        result.setPlaceOfDeath(p.getPlaceOfDeath());
        result.setCauseOfDeath(p.getCauseOfDeath());
        result.setSex(p.getSex().getLabel());
        result.setMother(p.getMother() != null ? createGetParentDTO(p.getMother()) : null);
        result.setFather(p.getFather() != null ? createGetParentDTO(p.getFather()) : null);
        List<GetEventDTO> events = new ArrayList<>();
        p.getEvents().stream().forEach((pe) -> {
            events.add(createGetEventDTO(pe));
        });
        result.setEvents(events);
        List<GetPortraitDTO> portraits = new ArrayList<>();
        p.getPortraits().stream().forEach((portrait) -> {
            portraits.add(createGetPortraitDTO(portrait));
        });
        result.setPortraits(portraits);
        return result;
    }

    public GetParentDTO createGetParentDTO(Person p) {
        GetParentDTO result = new GetParentDTO();
        result.setId(p.getId());
        result.setFamilyName(p.getFamilyName());
        result.setGivenName(p.getGivenName());
        result.setSex(p.getSex().getLabel());
        return result;
    }

    public GetEventDTO createGetEventDTO(PersonalEvent e) {
        GetEventDTO result = new GetEventDTO();
        result.setId(e.getId());
        result.setDate(e.getDate() != null ? e.getDate().format(DateTimeFormatter.ISO_DATE) : null);
        result.setDescription(e.getDescription());
        return result;
    }

    public GetPortraitDTO createGetPortraitDTO(Portrait p) {
        GetPortraitDTO result = new GetPortraitDTO();
        result.setId(p.getId());
        result.setImage(p.getImageAsByteArray());
        result.setMediaType(p.getMediaType());
        result.setDate(p.getDate() != null ? p.getDate().format(DateTimeFormatter.ISO_DATE) : null);
        result.setLabel(p.getLabel());
        result.setDescription(p.getDescription());
        return result;
    }

    public GetFamilyTreeDTO createFamilyTreeDTO(XmlDocument familyTreeDoc) {
        XmlNode root = familyTreeDoc.getRoot();
        GetFamilyTreeDTO result = new GetFamilyTreeDTO();
        result.setFamilyName(root.getAttribute("family"));
        result.setResidence(root.getAttribute("residence"));
        result.setFather(createFamilyTreeNode(root.getChild("male")));
        result.setMother(createFamilyTreeNode(root.getChild("female")));
        return result;
    }

    private GetFamilyTreeMemberDTO createFamilyTreeNode(XmlNode node) {
        GetFamilyTreeMemberDTO result = new GetFamilyTreeMemberDTO();
        if (node != null) {
            result.setGivenName(attribute(node, "given-name"));
            result.setDateOfBirth(attribute(node, "date-of-birth"));
            result.setPlaceOfBirth(attribute(node, "place-of-birth"));
            if (node.hasAttribute("date-of-death")) {
                result.setDateOfDeath(attribute(node, "place-of-death"));
                result.setPlaceOfDeath(attribute(node, "place-of-death"));
                result.setCauseOfDeath(attribute(node, "cause-of-death"));
            }
            if (node.hasAttribute("father")) {
                result.setFather(attribute(node, "father"));
            }
            if (node.hasChildNamed("personal-events")) {
                node.getChild("personal-events").getChildren("event").stream().forEach((e) -> {
                    GetEventDTO eventDTO = new GetEventDTO();
                    eventDTO.setId(Long.valueOf(e.getAttribute("id")));
                    eventDTO.setDate(e.getAttribute("date"));
                    eventDTO.setDescription(e.getText());
                    result.getEvents().add(eventDTO);
                });
            }
            if (!node.getChildren().isEmpty()) {
                node.getChildren().stream().filter((child) -> (!child.isCdata() && (child.getName().equals("female") || child.getName().equals("male")))).forEach((child) -> {
                    result.getChildren().add(createFamilyTreeNode(child));
                });
            }
        }
        return result;
    }

    private String attribute(XmlNode node, String attributeName) {
        return node.getAttribute(attributeName);
    }
}
