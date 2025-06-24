package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Result {

    @XmlAttribute(name = "Rank")
    private String Rank;

    @XmlAttribute(name = "Order")
    private String Order;

    @XmlAttribute(name = "Value")
    private String Value;

    @XmlAttribute(name = "ValueType")
    private String ValueType;

    // Getters and setters
    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String Order) {
        this.Order = Order;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public String getValueType() {
        return ValueType;
    }

    public void setValueType(String ValueType) {
        this.ValueType = ValueType;
    }

    @Override
    public String toString() {
        return "Result{\n" +
                "    Rank='" + Rank + "',\n" +
                "    Order='" + Order + "',\n" +
                "    Value='" + Value + "',\n" +
                "    ValueType='" + ValueType + "'\n" +
                "}";
    }

}
