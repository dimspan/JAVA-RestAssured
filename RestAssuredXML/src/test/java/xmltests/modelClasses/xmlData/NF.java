package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class NF {
    @XmlAttribute(name = "Code")
    private String code;

    @XmlAttribute(name = "Country")
    private String country;

    // Getter and setter
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "NF{\n" +
                "    country='" + country + "'\n" +
                "    code='" + code + "'\n" +
                "}";
    }

}

