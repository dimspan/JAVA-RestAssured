package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Competitor {
    @XmlAttribute(name = "Code")
    private String code;

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "Organisation")
    private String organisation;

    @XmlElement(name = "Composition")
    private Composition composition;

    // Getters and setters
    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public String getCode() {return code;}

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    @Override
    public String toString() {
        return "Competitor{\n" +
                "    Composition='" + composition + "',\n" +
                "    organisation='" + organisation + "',\n" +
                "    type='" + type + "',\n" +
                "    code='" + code + "',\n" +
                "}";
    }

}

