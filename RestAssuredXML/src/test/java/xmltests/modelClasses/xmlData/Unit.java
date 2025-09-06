package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {

    @XmlAttribute(name = "Order")
    private String Order;

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Title")
    private String title;

    // Getter and setter
    public String getOrder() {
        return Order;
    }

    public void setOrder(String Order) {
        this.Order = Order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Unit{\n" +
                "    Order='" + Order + "'\n" +
                "    type='" + type + "'\n" +
                "    title='" + title + "'\n" +
                "    id='" + id + "'\n" +
                "}";
    }

}

