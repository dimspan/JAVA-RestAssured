package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class UnitStanding {
    //  Explicitly map attribute case
    @XmlAttribute(name = "Title")
    private String title;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Status")
    private String status;

    @XmlElement(name = "Event")
    private Event event;

    @XmlElement(name = "Team")
    private List<Team>  teams;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Event getEvent() { return event;}

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Team> getTeams() { return teams;}

    public void setTeams(List<Team>  teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "UnitStanding{\n" +
                "    title='" + title + "',\n" +
                "    id='" + id + "',\n" +
                "    status='" + status + "',\n" +
                "    event='" + event + "'\n" +
                "    teams='" + teams + "'\n" +
                "}";
    }

}
