package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Competition {

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "Place")
    private String place;

    @XmlAttribute(name = "Country")
    private String country;

    @XmlAttribute(name = "Region")
    private String region;

    @XmlAttribute(name = "Title")
    private String title;

    @XmlElement(name = "Schedule")
    private Schedule schedule;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Competition{\n" +
                "    Id='" + id + "',\n" +
                "    country='" + country + "',\n" +
                "    title='" + title + "',\n" +
                "    place='" + place + "',\n" +
                "    Schedule='" + schedule + "',\n" +
                "}";
    }

}

