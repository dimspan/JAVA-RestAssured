package xmltests.modelClasses.nFiles;

import xmltests.modelClasses.nFiles.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Competition {

    @XmlElement(name = "Categories")
    private Categories categories;

    @XmlElement(name = "Document")
    private Document document;

    @XmlAttribute(name = "Gen")
    private String gen;

    @XmlAttribute(name = "Codes")
    private String codes;

    // Getters and setters
    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    @Override
    public String toString() {
        return "Competition{\n" +
                "    categories='" + categories + "',\n" +
                "    document='" + document + "',\n" +
                "    gen='" + gen + "',\n" +
                "    codes='" + codes + "',\n" +
                "}";
    }

}

