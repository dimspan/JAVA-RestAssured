package xmltests.testClasses.HistoricalData;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.charset.StandardCharsets;


public class APItestXML_XSD_URL {

    private static final String XML_URL = "xxxxxxxxx"; // Update with actual API URL
    private static final String XSD_URL = "xxxxxxxxxxx"; // Update with actual XSD URL

    private static final String USERNAME = "xxxxxxx";
    private static final String PASSWORD = "xxxxxxxxx";

    private static String xmlContent; // Shared XML response
    private static String xsdContent; // Shared XSD schema

    @BeforeClass
    public void fetchXmlAndXsd() {
        // 🔹 Fetch XML data WITH authentication
        Response xmlResponse = RestAssured
                .given()
                .auth().basic(USERNAME, PASSWORD)  // 🔹 Authentication ONLY for XML request
                .when()
                .get(XML_URL);

        xmlContent = new String(xmlResponse.getBody().asByteArray(), StandardCharsets.UTF_8).trim(); // Trim leading/trailing spaces
//        System.out.println("Fetched XML Content:\n" + xmlContent);

        // Fetch XSD Schema from API
        Response xsdResponse = RestAssured.get(XSD_URL);
        xsdContent = new String(xsdResponse.getBody().asByteArray(), StandardCharsets.UTF_8).trim();
//        System.out.println("Fetched XSD Content:\n" + xsdContent);
    }

    @Test(priority = 1)
    public void validateXsdSchema() throws Exception {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        InputStream xsdStream = new ByteArrayInputStream(xsdContent.getBytes());
        Schema schema = factory.newSchema(new StreamSource(xsdStream));
        Validator validator = schema.newValidator();

        try {
            InputStream xmlStream = new ByteArrayInputStream(xmlContent.getBytes());
            validator.validate(new StreamSource(xmlStream));
            System.out.println("XML is valid against XSD!");
        } catch (Exception e) {
            throw new AssertionError("XML validation failed: " + e.getMessage());
        }
    }

//    @Test(priority = 2)
//    public void checkTournamentStageGender() {
//        XmlPath xmlPath = new XmlPath(xmlContent);
//        String tournamentStageGender = xmlPath.getString("spocosy.query-response.sport.tournament_template.tournament.tournament_stage.@gender");
//
//        assertThat("Check tournamentStage Gender", tournamentStageGender, equalTo("male"));
//    }
}
