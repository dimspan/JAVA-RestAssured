package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PoolsStage {
    //  Explicitly map attribute case
    @XmlAttribute(name = "Title")
    private String title;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Order")
    private String order;

    @XmlAttribute(name = "RoundType")
    private String roundType;

    @XmlElement(name = "Pool")
    private Pool pool;

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

    public String getRoundType() { return roundType;}

    public void setRoundType(String roundType) {
        this.roundType = roundType;
    }

    public Pool getPool() { return pool;}

    public void setPool(Pool pool) {this.pool = pool;}

    @Override
    public String toString() {
        return "PoolsStage{\n" +
                "    title='" + title + "',\n" +
                "    id='" + id + "',\n" +
                "    order='" + order + "',\n" +
                "    roundType='" + roundType + "'\n" +
                "    pool='" + pool + "'\n" +
                "}";
    }

}
