package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Event {

    @XmlAttribute(name = "CompetitorType")
    private String competitorType;

    @XmlAttribute(name = "Gender")
    private String gender;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Title")
    private String title;

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "Order")
    private String order;

    @XmlElement(name = "Discipline")
    private Discipline discipline;

    // Getter and setter
    public String getCompetitorType() {
        return competitorType;
    }

    public void setCompetitorType(String competitorType) {
        this.competitorType = competitorType;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {return type;}

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Event{\n" +
                "    CompetitorType='" + competitorType + "'\n" +
                "    gender='" + gender + "'\n" +
                "    order='" + order + "'\n" +
                "    type='" + type + "'\n" +
                "    title='" + title + "'\n" +
                "    id='" + id + "'\n" +
                "    discipline='" + discipline + "'\n" +
                "}";
    }

}

