package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "OdfBody")
@XmlAccessorType(XmlAccessType.FIELD)
public class OdfBody {

    @XmlElement(name = "Record")
    private List<Record> record;

    @XmlElement(name = "Competition")
    private Competition competition;

    @XmlAttribute(name = "Version")
    private String version;

    @XmlAttribute(name = "CompetitionCode")
    private String competitionCode;

    @XmlAttribute(name = "DocumentCode")
    private String documentCode;

    @XmlAttribute(name = "DocumentSubcode")
    private String documentSubcode;

    @XmlAttribute(name = "DocumentType")
    private String documentType;

    @XmlAttribute(name = "Language")
    private String language;

    @XmlAttribute(name = "FeedFlag")
    private String feedFlag;

    @XmlAttribute(name = "Date")
    private String date;

    @XmlAttribute(name = "Time")
    private String time;

    @XmlAttribute(name = "LogicalDate")
    private String logicalDate;

    @XmlAttribute(name = "Source")
    private String source;

    // Getters and setters
    public List<Record> getRecord() {
        return record;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCompetitionCode() {
        return competitionCode;
    }

    public void setCompetitionCode(String competitionCode) {
        this.competitionCode = competitionCode;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public String getDocumentSubcode() {
        return documentSubcode;
    }

    public void setDocumentSubcode(String documentSubcode) {
        this.documentSubcode = documentSubcode;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFeedFlag() {
        return feedFlag;
    }

    public void setFeedFlag(String feedFlag) {
        this.feedFlag = feedFlag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLogicalDate() {
        return logicalDate;
    }

    public void setLogicalDate(String logicalDate) {
        this.logicalDate = logicalDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "OdfBody{\n" +
                "    Record='" + record + "',\n" +
                "    version='" + version + "',\n" +
                "    competitionCode='" + competitionCode + "',\n" +
                "    documentCode='" + documentCode + "',\n" +
                "    documentSubcode='" + documentSubcode + "',\n" +
                "    documentType='" + documentType + "',\n" +
                "    language='" + language + "',\n" +
                "    feedFlag='" + feedFlag + "',\n" +
                "    date='" + date + "',\n" +
                "    time='" + time + "',\n" +
                "    logicalDate='" + logicalDate + "',\n" +
                "    source='" + source + "',\n" +
                "}";
    }

}

