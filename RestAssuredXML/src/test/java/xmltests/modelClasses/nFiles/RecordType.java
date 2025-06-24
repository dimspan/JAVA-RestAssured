package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class RecordType {

    @XmlAttribute(name = "Order")
    private String order;

    @XmlAttribute(name = "RecordType")
    private String recordType;

    @XmlAttribute(name = "Shared")
    private String shared;

    @XmlElement(name = "RecordData")
    private RecordData recordData;

    // Getters and setters
    public String getOrder() {
        return order;
    }

    public void setTOrder(String order) {this.order = order;}

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getShared() {
        return shared;
    }

    public void setShared(String shared) {
        this.shared = shared;
    }

    public RecordData getRecordData() {
        return recordData;
    }

    public void setRecordData(RecordData recordData) {
        this.recordData = recordData;
    }

    @Override
    public String toString() {
        return "RecordType{\n" +
                "    shared='" + shared + "',\n" +
                "    recordType='" + recordType + "',\n" +
                "    order='" + order + "',\n" +
                "    recordData='" + recordData + "',\n" +
                "}";
    }

}

