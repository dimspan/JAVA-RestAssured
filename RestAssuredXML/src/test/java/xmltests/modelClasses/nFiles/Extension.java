package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Extension {

    @XmlAttribute(name = "Type")
    private String type;

    @XmlAttribute(name = "Pos")
    private String pos;

    @XmlAttribute(name = "Code")
    private String code;

    @XmlAttribute(name = "Value")
    private String value;

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {this.type = type;}

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Extension{\n" +
                "    type='" + type + "',\n" +
                "    pos='" + pos + "',\n" +
                "    code='" + code + "',\n" +
                "    value='" + value + "',\n" +
                "}";
    }

}

