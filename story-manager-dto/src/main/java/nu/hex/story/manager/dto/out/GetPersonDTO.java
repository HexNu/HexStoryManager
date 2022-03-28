package nu.hex.story.manager.dto.out;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * Created 2016-jun-28
 *
 * @author hl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPersonDTO {

    @NotNull
    private Long id;
    private String familyName;
    private String givenName;
    private String sex;
    private String dateOfBirth;
    private String placeOfBirth;
    private String dateOfDeath;
    private String placeOfDeath;
    private String causeOfDeath;
    private GetParentDTO mother;
    private GetParentDTO father;
    private String residence;
    private List<GetEventDTO> events = new ArrayList<>();
    private List<GetPortraitDTO> portraits = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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

    public List<GetPortraitDTO> getPortraits() {
        return portraits;
    }

    public void setPortraits(List<GetPortraitDTO> portraits) {
        this.portraits = portraits;
    }

    public GetParentDTO getMother() {
        return mother;
    }

    public void setMother(GetParentDTO mother) {
        this.mother = mother;
    }

    public GetParentDTO getFather() {
        return father;
    }

    public void setFather(GetParentDTO father) {
        this.father = father;
    }
}
