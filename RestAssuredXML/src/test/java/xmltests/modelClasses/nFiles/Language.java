package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Language {

    @XmlAttribute(name = "Language")
    private String language;

    // Getters and setters
    public String getLanguage() {return language;}

    public void setLanguage(String  language) {
        this.language = language;
    }


    @Override
    public String toString() {
        return "Language{\n" +
                "    language ='" + language + "',\n" +
                "}";
    }

}

