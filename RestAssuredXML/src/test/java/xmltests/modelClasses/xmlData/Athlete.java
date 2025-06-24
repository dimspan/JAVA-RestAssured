package xmltests.modelClasses.xmlData;

import xmltests.modelClasses.nFiles.Description;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Athlete {

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Code")
    private String code;

    @XmlAttribute(name = "Order")
    private String order;

    @XmlAttribute(name = "ParticipationName")
    private String participationName;

    @XmlAttribute(name = "DateOfBirth")
    private String dateOfBirth;

    @XmlAttribute(name = "Gender")
    private String gender;

    @XmlAttribute(name = "FamilyName")
    private String familyName;

    @XmlAttribute(name = "GivenName")
    private String givenName;

    @XmlAttribute(name = "Height")
    private String height;

    @XmlAttribute(name = "Weight")
    private String weight;

    @XmlElement(name = "NF")
    private NF nf;

    @XmlElement(name = "Result")
    private Result result;

    @XmlElement(name = "Medal")
    private Medal medal;

    @XmlElement(name = "Description")
    private Description description;

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getParticipationName() {
        return participationName;
    }

    public void setParticipationName(String participationName) {
        this.participationName = participationName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
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

    public NF getNF() {
        return nf;
    }

    public void setNF(NF nf) {
        this.nf = nf;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Medal getMedal() {
        return medal;
    }

    public void setMedal(Medal medal) {
        this.medal = medal;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Athlete{\n" +
                "    Id='" + id + "',\n" +
                "    Order='" + order + "',\n" +
                "    code='" + code + "',\n" +
                "    ParticipationName='" + participationName + "',\n" +
                "    DateOfBirth='" + dateOfBirth + "',\n" +
                "    Gender='" + gender + "',\n" +
                "    FamilyName='" + familyName + "',\n" +
                "    GivenName='" + givenName + "',\n" +
                "    Height='" + height + "',\n" +
                "    Weight='" + weight + "',\n" +
                "    Result='" + result + "',\n" +
                "    Medal='" + medal + "'\n" +
                "    description='" + description + "'\n" +
                "}";
    }

}

