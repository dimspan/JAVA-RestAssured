package xmltests.modelClasses.nFiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlAttribute(name = "Code")
    private String code;

    @XmlAttribute(name = "CategoryName")
    private String categoryName;

    @XmlAttribute(name = "Main")
    private String main;

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Category{\n" +
                "    code ='" + code + "',\n" +
                "    categoryName ='" + categoryName + "',\n" +
                "    main ='" + main + "',\n" +
                "}";
    }

}

