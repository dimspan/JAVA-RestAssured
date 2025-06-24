package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Description {

    @XmlAttribute(name = "GivenName")
    private String givenName;

    @XmlAttribute(name = "FamilyName")
    private String familyName;

    @XmlAttribute(name = "Gender")
    private String gender;

    @XmlAttribute(name = "Organisation")
    private String organisation;

    @XmlAttribute(name = "BirthDate")
    private String birthDate;

    @XmlAttribute(name = "Name")
    private String name;

    // Getters and setters
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {this.givenName = givenName;}

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Description{\n" +
                "    GivenName='" + givenName + "',\n" +
                "    FamilyName='" + familyName + "',\n" +
                "    Gender='" + gender + "',\n" +
                "    Organisation='" + organisation + "',\n" +
                "    BirthDate='" + birthDate + "',\n" +
                "    Name='" + name + "',\n" +
                "}";
    }

}

