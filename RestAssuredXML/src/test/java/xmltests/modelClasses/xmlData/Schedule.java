package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Schedule {

    @XmlAttribute(name = "StartDate")
    private String startDate;

    @XmlAttribute(name = "FinishDate")
    private String finishDate;

    @XmlAttribute(name = "Status")
    private String status;

    // Getters and setters
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Schedule{\n" +
                "    StartDate='" + startDate + "',\n" +
                "    finishDate='" + finishDate + "',\n" +
                "    status='" + status + "',\n" +
                "}";
    }

}

