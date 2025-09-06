package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class EventBreakdown {
    //  Explicitly map attribute case
    @XmlAttribute(name = "Title")
    private String title;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "CompetitorType")
    private String competitorType;

    @XmlAttribute(name = "Order")
    private String order;

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "Gender")
    private String gender;

    @XmlElement(name = "PoolsStage")
    private List<PoolsStage> poolsStages;

    @XmlElement(name = "Discipline")
    private Discipline discipline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompetitorType() {
        return competitorType;
    }

    public void setCompetitorType(String competitorType) {
        this.competitorType = competitorType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() { return type;}

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder() { return order;}

    public void setOrder(String order) {
        this.order = order;
    }

    public List<PoolsStage> getPoolsStages() { return poolsStages;}

    public void setPoolsStages(List<PoolsStage> poolsStages) {
        this.poolsStages = poolsStages;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "EventBreakdown{\n" +
                "    title='" + title + "',\n" +
                "    id='" + id + "',\n" +
                "    CompetitorType='" + competitorType + "',\n" +
                "    type='" + type + "'\n" +
                "    gender='" + gender + "'\n" +
                "    order='" + order + "'\n" +
                "    poolsStages='" + poolsStages + "'\n" +
                "    discipline='" + discipline + "'\n" +
                "}";
    }

}
