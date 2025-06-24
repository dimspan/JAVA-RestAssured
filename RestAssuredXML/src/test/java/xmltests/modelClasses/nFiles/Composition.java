package xmltests.modelClasses.nFiles;

import xmltests.modelClasses.xmlData.Athlete;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Composition {

    @XmlElement(name = "Athlete")
    private Athlete athlete;

    // Getters and setters
    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @Override
    public String toString() {
        return "Composition{\n" +
                "    Athlete='" + athlete + "',\n" +
                "}";
    }

}

