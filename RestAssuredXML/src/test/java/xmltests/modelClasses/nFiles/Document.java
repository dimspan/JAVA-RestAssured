package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Document {

    @XmlAttribute(name = "Parent")
    private String parent;

    @XmlAttribute(name = "ReportType")
    private String reportType;

    @XmlAttribute(name = "ReportTypeName")
    private String reportTypeName;

    @XmlAttribute(name = "SortOrder")
    private String sortOrder;

    @XmlAttribute(name = "FileName")
    private String fileName;

    @XmlAttribute(name = "ReportFormat")
    private String reportFormat;

    @XmlElement(name = "Title")
    private Title title;

    // Getters and setters
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getReportTypeName() {
        return reportTypeName;
    }

    public void setReportTypeName(String reportTypeName) {
        this.reportTypeName = reportTypeName;
    }

    public String getReportType() { return reportType; }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getSortOrder() { return sortOrder; }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getReportFormat() { return reportFormat; }

    public void setReportFormat(String reportFormat) {
        this.reportFormat = reportFormat;
    }

    public Title getTitle() { return title; }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document{\n" +
                "    parent ='" + parent + "',\n" +
                "    reportTypeName ='" + reportTypeName + "',\n" +
                "    reportType ='" + reportType + "',\n" +
                "    sortOrder ='" + sortOrder + "',\n" +
                "    fileName ='" + fileName + "',\n" +
                "    reportFormat ='" + reportFormat + "',\n" +
                "}";
    }

}

