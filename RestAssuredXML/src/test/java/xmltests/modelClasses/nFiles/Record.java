package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Record {

    @XmlAttribute(name = "Code")
    private String code;

    @XmlElement(name = "Description")
    private Description description;

    @XmlElement(name = "RecordType")
    private RecordType recordType;

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
    }

    @Override
    public String toString() {
        return "Record{\n" +
                "    Code='" + code + "',\n" +
                "    Description='" + description + "',\n" +
                "}";
    }

}

