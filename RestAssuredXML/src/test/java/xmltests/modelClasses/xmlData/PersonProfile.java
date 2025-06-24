package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class PersonProfile {

    @XmlAttribute(name = "Gender") // 🔹 Explicitly map attribute case
    private String gender;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Nationality")
    private String nationality;

    @XmlAttribute(name = "PreferredFamilyName")
    private String preferredFamilyName;

    @XmlAttribute(name = "PreferredGivenName")
    private String preferredGivenName;

    @XmlAttribute(name = "DateOfBirth")
    private String dateOfBirth;

    @XmlAttribute(name = "Height")
    private String height;

    @XmlAttribute(name = "Weight")
    private String weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPreferredFamilyName() {
        return preferredFamilyName;
    }

    public void setPreferredFamilyName(String preferredFamilyName) {
        this.preferredFamilyName = preferredFamilyName;
    }

    public String getPreferredGivenName() {
        return preferredGivenName;
    }

    public void setPreferredGivenName(String preferredGivenName) {
        this.preferredGivenName = preferredGivenName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PersonProfile{\n" +
                "    gender='" + gender + "',\n" +
                "    id='" + id + "',\n" +
                "    nationality='" + nationality + "',\n" +
                "    preferredFamilyName='" + preferredFamilyName + "',\n" +
                "    preferredGivenName='" + preferredGivenName + "',\n" +
                "    dateOfBirth='" + dateOfBirth + "',\n" +
                "    height='" + height + "',\n" +
                "    weight='" + weight + "'\n" +
                "}";
    }
}
