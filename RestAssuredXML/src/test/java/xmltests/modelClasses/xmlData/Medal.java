package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Medal {

    @XmlAttribute(name = "Date") // 🔹 Explicitly map attribute case
    private String date;

    @XmlAttribute(name = "Kind")
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {this.date = date;}

    @Override
    public String toString() {
        return "Medal{\n" +
                "    date='" + date + "',\n" +
                "    kind='" + kind + "'\n" +
                "}";
    }

}
