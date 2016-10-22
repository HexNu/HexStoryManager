package nu.hex.story.manager.api.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.atlas.Atlas;
import nu.hex.story.manager.core.domain.atlas.AtlasMap;
import nu.hex.story.manager.core.domain.image.Image;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.PersonalEvent;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.domain.person.impl.DefaultPerson;
import nu.hex.story.manager.dto.out.GetAtlasDTO;
import nu.hex.story.manager.dto.out.GetEventDTO;
import nu.hex.story.manager.dto.out.GetFamilyTreeDTO;
import nu.hex.story.manager.dto.out.GetFamilyTreeMemberDTO;
import nu.hex.story.manager.dto.out.GetImageDTO;
import nu.hex.story.manager.dto.out.GetListedPersonDTO;
import nu.hex.story.manager.dto.out.GetMapDTO;
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
        result.setPortraits(createGetPortraitsDTO(p.getPortraits()));
        return result;
    }

    public List<GetListedPersonDTO> createGetPersonDTOList(XmlDocument doc) {
        List<GetListedPersonDTO> result = new ArrayList<>();
        for (XmlNode p : doc.getRoot().getChildren()) {
            GetListedPersonDTO person = new GetListedPersonDTO();
            person.setId(Long.valueOf(p.getAttribute("id")));
            person.setFamilyName(p.getAttribute("family-name"));
            person.setGivenName(p.getAttribute("given-name"));
            person.setDateOfBirth(p.hasAttribute("date-of-birth") ? p.getAttribute("date-of-birth") : null);
            person.setPlaceOfBirth(p.hasAttribute("place-of-birth") ? p.getAttribute("place-of-birth") : null);
            person.setDateOfDeath(p.hasAttribute("date-of-death") ? p.getAttribute("date-of-death") : null);
            person.setPlaceOfDeath(p.hasAttribute("place-of-death") ? p.getAttribute("place-of-death") : null);
            person.setSex(p.getName());
            person.setMother(p.hasAttribute("mother") ? p.getAttribute("mother") : null);
            person.setFather(p.hasAttribute("father") ? p.getAttribute("father") : null);
            person.setResidence(p.getAttribute("residence"));
            result.add(person);
        }
        return result;

    }

    public List<GetPortraitDTO> createGetPortraitsDTO(List<Portrait> portaits) {
        List<GetPortraitDTO> result = new ArrayList<>();
        portaits.stream().forEach((portrait) -> {
            result.add(createGetPortraitDTO(portrait));
        });
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
        result.setLabel(e.getLabel());
        result.setDate(e.getDate() != null ? e.getDate().format(DateTimeFormatter.ISO_DATE) : null);
        result.setDescription(e.getDescription());
        return result;
    }

    public GetPortraitDTO createGetPortraitDTO(Portrait p) {
        GetPortraitDTO result = new GetPortraitDTO();
        result.setId(p.getId());
        result.setImage(createImageDTO(p.getImage()));
        result.setDate(p.getDate() != null ? p.getDate().format(DateTimeFormatter.ISO_DATE) : null);
        result.setLabel(p.getLabel());
        result.setShortDescription(p.getShortDescription());
        result.setDescription(p.getDescription());
        return result;
    }

    public GetImageDTO createImageDTO(Image i) {
        GetImageDTO result = new GetImageDTO();
        result.setId(i.getId());
        result.setName(i.getName());
        result.setHeight(i.getHeight());
        result.setWidth(i.getWidth());
        result.setMediaType(i.getMediaType());
        result.setData(i.getImageAsByteArray());
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
            result.setId(attributeAsLong(node, "id"));
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
                    eventDTO.setId(attributeAsLong(e, "id"));
                    eventDTO.setLabel(attribute(e, "label"));
                    eventDTO.setDate(attribute(e, "date"));
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

    public GetAtlasDTO createGetAtlasDTO(Atlas atlas) {
        GetAtlasDTO result = new GetAtlasDTO();
        result.setId(atlas.getId());
        result.setTitle(atlas.getTitle());
        result.setDescription(atlas.getDescription());
        result.setMaps(createMapDTOList(atlas.getMaps()));
        return result;
    }

    public GetMapDTO createGetMapDTO(AtlasMap map) {
        GetMapDTO result = new GetMapDTO();
        result.setId(map.getId());
        result.setTitle(map.getTitle());
        result.setDescription(map.getDescription());
        result.setImage(createImageDTO(map.getImage()));
        return result;
    }

    public List<GetMapDTO> createMapDTOList(List<AtlasMap> maps) {
        List<GetMapDTO> result = new ArrayList<>();
        maps.stream().forEach((map) -> {
            result.add(createGetMapDTO(map));
        });
        return result;
    }

    private String attribute(XmlNode node, String attributeName) {
        return node.getAttribute(attributeName);
    }

    private Long attributeAsLong(XmlNode node, String attributeName) {
        return Long.valueOf(attribute(node, attributeName));
    }

    private Integer attributeAsInteger(XmlNode node, String attributeName) {
        return Integer.valueOf(attribute(node, attributeName));
    }

    private LocalDate attributeAsDate(XmlNode node, String attributeName) {
        return LocalDate.parse(attribute(node, attributeName), DateTimeFormatter.ISO_DATE);
    }

}
