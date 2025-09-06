package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Pool {
    //  Explicitly map attribute case
    @XmlAttribute(name = "Title")
    private String title;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Order")
    private String order;

    @XmlAttribute(name = "Group")
    private String group;

    @XmlElement(name = "Unit")
    private List<Unit>  units;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup() { return group;}

    public void setGroup(String group) {this.group = group;}

    public List<Unit> getUnits() { return units;}

    public void setUnits(List<Unit> units) {this.units = units;}

    @Override
    public String toString() {
        return "PoolsStage{\n" +
                "    title='" + title + "',\n" +
                "    id='" + id + "',\n" +
                "    order='" + order + "',\n" +
                "    group='" + group + "',\n" +
                "    units='" + units + "'\n" +
                "}";
    }

}
