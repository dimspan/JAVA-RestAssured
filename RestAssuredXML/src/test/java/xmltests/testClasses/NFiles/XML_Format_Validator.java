package xmltests.testClasses.NFiles;

import org.testng.annotations.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

import xmltests.modelClasses.nFiles.*;

public class XML_Format_Validator {

    private String xmlUrl;

//    private static final String XML_URL = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; // Update with actual API URL

    private static final String USERNAME = "xxxxxxxxxxxxxxx";
    private static final String PASSWORD = "xxxxxxxxxxxxxx";

    // 🔹 Constructor to set XML URL dynamically
    public XML_Format_Validator(String xmlUrl) {
        this.xmlUrl = xmlUrl;
    }


    @Test(priority = 1)
    public void validateXmlFormated(String xmlContent) throws JAXBException {
        //get the main odfBody element
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(new StringReader(xmlContent)));
            System.out.println("XML is well-formed!");

            String version = odfBody.getVersion();
            System.out.println("Current version: " + version);

        } catch (SAXException e) {
            //get the CategoryName
            String categoryName = odfBody.getCompetition().getCategories().getCategory().getCategoryName();
            //get the discipline
            String documentSubcode = odfBody.getDocumentSubcode();
            throw new AssertionError("XML is NOT well-formed: " + e.getMessage() + " for the following sport: " + categoryName + " and discipline: " + documentSubcode);
        } catch (Exception e) {
            throw new AssertionError("Unexpected error during XML parsing: " + e.getMessage());
        }
    }
}
