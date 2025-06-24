package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Noc {

    @XmlAttribute(name = "Code")
    private String Code;

    // Getter and setter
    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    @Override
    public String toString() {
        return "Noc{\n" +
                "    Code='" + Code + "'\n" +
                "}";
    }

}

