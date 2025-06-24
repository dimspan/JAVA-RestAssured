package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class RecordData {

    @XmlAttribute(name = "ResultType")
    private String resultType;

    @XmlAttribute(name = "Order")
    private String order;

    @XmlAttribute(name = "Result")
    private String result;

    @XmlAttribute(name = "Country")
    private String country;

    @XmlAttribute(name = "Place")
    private String place;

    @XmlAttribute(name = "Date")
    private String date;

    @XmlAttribute(name = "Competition")
    private String competition;

    @XmlAttribute(name = "Historical")
    private String historical;

    @XmlAttribute(name = "Current")
    private String current;

    @XmlElement(name = "Competitor")
    private Competitor competitor;

    @XmlElement(name = "Extension")
    private List<Extension> extension;

    // Getters and setters
    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getHistorical() {
        return historical;
    }

    public void setHistorical(String historical) {
        this.historical = historical;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {this.competitor = competitor;}

    public List<Extension> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension> extension) {this.extension = extension;}

    @Override
    public String toString() {
        return "RecordData{\n" +
                "    ResultType='" + resultType + "',\n" +
                "    Order='" + order + "',\n" +
                "    Result='" + result + "',\n" +
                "    Country='" + country + "',\n" +
                "    Place='" + place + "',\n" +
                "    Date='" + date + "',\n" +
                "    Competition='" + competition + "',\n" +
                "    Historical='" + historical + "',\n" +
                "    Current='" + current + "',\n" +
                "    Extension='" + extension + "',\n" +
                "    competitor='" + competitor + "',\n" +
                "}";
    }

}

