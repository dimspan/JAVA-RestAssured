package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class EventStanding {
    //  Explicitly map attribute case
    @XmlAttribute(name = "Title")
    private String title;

    @XmlAttribute(name = "CompetitorType")
    private String competitorType;

    @XmlAttribute(name = "Gender")
    private String gender;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "Status")
    private String status;

    @XmlElement(name = "Athlete")
    private List<Athlete> athletes;

    @XmlElement(name = "Team")
    private List<Team> teams;

    @XmlElement(name = "Discipline")
    private Discipline discipline;

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

    public String getCompetitorType() {
        return competitorType;
    }

    public void setCompetitorType(String competitorType) {
        this.competitorType = competitorType;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "EventStanding{\n" +
                "    title='" + title + "',\n" +
                "    competitorType='" + competitorType + "',\n" +
                "    gender='" + gender + "',\n" +
                "    id='" + id + "',\n" +
                "    type='" + type + "'\n" +
                "    Athletes='" + athletes + "'\n" +
                "    Teams='" + teams + "'\n" +
                "    Discipline='" + discipline + "'\n" +
                "}";
    }

}
