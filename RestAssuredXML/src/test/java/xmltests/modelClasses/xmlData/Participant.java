package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Participant {

    @XmlAttribute(name = "Title") // 🔹 Explicitly map attribute case
    private String title;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Code")
    private String code;

    @XmlElement(name = "Team")
    private List<Team> teams;

    @XmlElement(name = "Athlete")
    private List<Athlete> athletes;

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Participant{\n" +
                "    title='" + title + "',\n" +
                "    id='" + id + "',\n" +
                "    code='" + code + "',\n" +
                "    athletes='" + athletes + "'\n" +
                "}";
    }

}
