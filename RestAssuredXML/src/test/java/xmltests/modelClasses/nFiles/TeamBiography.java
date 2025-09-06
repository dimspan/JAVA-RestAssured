package xmltests.modelClasses.nFiles;

import IOC.NFiles.N15A;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TeamBiography {

    @XmlElement(name = "Language")
    private Language language;

    @XmlElement(name = "Discipline")
    private Discipline discipline;

    @XmlAttribute(name = "Gender")
    private String gender;

    @XmlAttribute(name = "Organisation")
    private String organisation;

    @XmlAttribute(name = "Name")
    private String name;

    @XmlAttribute(name = "Current")
    private String current;

    @XmlAttribute(name = "ExternalCode")
    private String externalCode;

    // Getters and setters
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {this.gender = gender;}

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {this.organisation = organisation;}

    public String getName() {return name; }

    public void setName(String name) {this.name = name;}

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {this.current = current;}

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {this.externalCode = externalCode;}
    
    
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Discipline getDiscipline() {return discipline;}

    public void setDiscipline(Discipline discipline) {this.discipline = discipline;}

    @Override
    public String toString() {
        return "TeamBiography{\n" +
                "    language='" + language + "',\n" +
                "    discipline='" + discipline + "',\n" +
                "    gender='" + gender + "',\n" +
                "    organisation='" + organisation + "',\n" +
                "    name='" + name + "',\n" +
                "    current='" + current + "',\n" +
                "    externalCode='" + externalCode + "',\n" +
                "}";
    }

}

