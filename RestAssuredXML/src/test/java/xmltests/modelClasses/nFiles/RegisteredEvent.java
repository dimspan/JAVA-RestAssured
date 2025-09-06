package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class RegisteredEvent {

    @XmlAttribute(name = "Event")
    private String  event;

    // Getters and setters
    public String getEvent() {return event;}

    public void setEvent(String event) {
        this.event = event;
    }


    @Override
    public String toString() {
        return "Discipline{\n" +
                "    event ='" + event + "',\n" +
                "}";
    }

}

