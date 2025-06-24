package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Team {

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Order")
    private String order;

    @XmlAttribute(name = "EventType")
    private String eventType;

    @XmlAttribute(name = "Gender")
    private String gender;

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "ParticipationName")
    private String participationName;

    @XmlElement(name = "NF")
    private NF nf;

    @XmlElement(name = "Result")
    private Result result;

    @XmlElement(name = "Medal")
    private Medal medal;

    @XmlElement(name = "Athlete")
    private List<Athlete> athletes;

    // Getters and setters
    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = this.id;}

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getParticipationName() {
        return participationName;
    }

    public void setParticipationName(String participationName) {
        this.participationName = participationName;
    }

    public NF getNF() {
        return nf;
    }

    public void setNF(NF nf) {
        this.nf = nf;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Medal getMedal() {
        return medal;
    }

    public void setMedal(Medal medal) {
        this.medal = medal;
    }

    @Override
    public String toString() {
        return "Team{\n" +
                "    Id='" + id + "',\n" +
                "    Order='" + order + "',\n" +
                "    ParticipationName='" + participationName + "',\n" +
                "    Gender='" + gender + "',\n" +
                "    Type='" + type + "',\n" +
                "    EventType='" + eventType + "',\n" +
                "    NF='" + nf + "',\n" +
                "    Result='" + result + "',\n" +
                "    Medal='" + medal + "'\n" +
                "}";
    }

}

