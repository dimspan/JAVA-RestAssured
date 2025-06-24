package xmltests.modelClasses.xmlData;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Export")
@XmlAccessorType(XmlAccessType.FIELD)
public class Export {
    @XmlElement(name = "Usdf20")
    private List<Usdf20> Usdf20;

    public List<Usdf20> getUsdf20() {return Usdf20;}

    public void setUsdf20(List<Usdf20> Usdf20) {
        this.Usdf20 = Usdf20;
    }
}