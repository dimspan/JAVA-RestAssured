package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Discipline {

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Code")
    private String code;

    @XmlAttribute(name = "Title")
    private String title;

    @XmlElement(name = "Competition")
    private Competition competition;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = this.id;}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public String toString() {
        return "Discipline{\n" +
                "    Id='" + id + "',\n" +
                "    Title='" + title + "',\n" +
                "    Code='" + code + "',\n" +
                "    Competition ='" + competition + "',\n" +
                "}";
    }

}

