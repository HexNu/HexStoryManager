package nu.hex.story.manager.dto.out;

/**
 * Created 2016-jun-29
 *
 * @author hl
 */
public class GetFamilyTreeDTO {

    private String familyName;
    private String residence;
    private GetFamilyTreeMemberDTO father;
    private GetFamilyTreeMemberDTO mother;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public GetFamilyTreeMemberDTO getFather() {
        return father;
    }

    public void setFather(GetFamilyTreeMemberDTO father) {
        this.father = father;
    }

    public GetFamilyTreeMemberDTO getMother() {
        return mother;
    }

    public void setMother(GetFamilyTreeMemberDTO mother) {
        this.mother = mother;
    }
}
