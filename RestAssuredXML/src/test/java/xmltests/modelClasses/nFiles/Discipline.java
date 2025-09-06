package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Discipline {

    @XmlElement(name = "RegisteredEvent")
    private RegisteredEvent registeredEvent;

    @XmlAttribute(name = "Code")
    private String code;

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RegisteredEvent getRegisteredEvent() {
        return registeredEvent;
    }

    public void setRegisteredEvent(RegisteredEvent registeredEvent) {
        this.registeredEvent = registeredEvent;
    }


    @Override
    public String toString() {
        return "Discipline{\n" +
                "    code ='" + code + "',\n" +
                "    registeredEvent ='" + registeredEvent + "',\n" +
                "}";
    }

}

