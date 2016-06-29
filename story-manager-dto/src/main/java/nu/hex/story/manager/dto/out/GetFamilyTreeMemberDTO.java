package nu.hex.story.manager.dto.out;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 2016-jun-29
 *
 * @author hl
 */
public class GetFamilyTreeMemberDTO {

    private Long id;
    private String givenName;
    private String sex;
    private String dateOfBirth;
    private String placeOfBirth;
    private String dateOfDeath;
    private String placeOfDeath;
    private String causeOfDeath;
    private String father;
    private String residence;
    private List<GetEventDTO> portraits = new ArrayList<>();
    private List<GetEventDTO> events = new ArrayList<>();
    private List<GetFamilyTreeMemberDTO> children = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public List<GetEventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<GetEventDTO> events) {
        this.events = events;
    }

    public List<GetFamilyTreeMemberDTO> getChildren() {
        return children;
    }

    public void setChildren(List<GetFamilyTreeMemberDTO> children) {
        this.children = children;
    }

    public List<GetEventDTO> getPortraits() {
        return portraits;
    }

    public void setPortraits(List<GetEventDTO> portraits) {
        this.portraits = portraits;
    }
}
