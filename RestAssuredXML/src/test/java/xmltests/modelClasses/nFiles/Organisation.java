package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organisation {

    @XmlElement(name = "Language")
    private Language language;

    @XmlAttribute(name = "Current")
    private String current;

    @XmlAttribute(name = "ExternalCode")
    private String externalCode;

    @XmlAttribute(name = "Code")
    private String code;

    // Getters and setters
    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {this.current = current;}

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {this.externalCode = externalCode;}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {this.code = code;}

    
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Organisation{\n" +
                "    language='" + language + "',\n" +
                "    current='" + current + "',\n" +
                "    externalCode='" + externalCode + "',\n" +
                "    code='" + code + "',\n" +
                "}";
    }

}

