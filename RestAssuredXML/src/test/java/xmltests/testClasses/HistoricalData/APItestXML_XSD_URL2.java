package xmltests.testClasses.HistoricalData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class APItestXML_XSD_URL2 {

    //    private static final String XML_FILE_PATH = "./eventStanding.xml"; // Replace with actual API URL later
//    private static final String XML_URL = "xxxxxxxxxxxxxxxxxxxxxx"; // Update with actual API URL
    private String xmlUrl;
    private static final String XSD_URL = "xxxxxxxxxxxxxxx"; // Update with actual XSD path later

    private static final String USERNAME = "xxxxxxxxxxx";
    private static final String PASSWORD = "xxxxxxxxxxxxx";

    private static String xmlContent; // Shared response for all tests
    private static String xsdContent; // Shared XSD schema

    @BeforeClass
    public void loadXmlFileXsdSchema() throws Exception {
//        xmlContent = new String(Files.readAllBytes(Paths.get(XML_FILE_PATH))); // Read XML file

        xmlUrl = System.getProperty("xmlUrl");  // 🔹 Read from Maven command

        if (xmlUrl == null || xmlUrl.isEmpty()) {
            throw new IllegalArgumentException("❌ ERROR: Missing 'xmlUrl' parameter! Pass it using -DxmlUrl=<URL>");
        }

        System.out.println("🔹 Running test with XML URL: " + xmlUrl);

        // 🔹 Fetch XML data WITH authentication
        Response xmlResponse = RestAssured
                .given()
                .auth().basic(USERNAME, PASSWORD)  // 🔹 Authentication ONLY for XML request
                .when()
                .get(xmlUrl);

        xmlContent = new String(xmlResponse.getBody().asByteArray(), StandardCharsets.UTF_8).trim(); // Trim leading/trailing spaces
        // 🔹 Fetch XSD schema from URL
        Response xsdResponse = RestAssured.get(XSD_URL);
        xsdContent = new String(xsdResponse.getBody().asByteArray(), StandardCharsets.UTF_8).trim();
//        System.out.println("XML content: "+ xmlContent);
//        System.out.println("XSD content: "+xsdContent);
    }

    @Test(priority = 1)
    public void validateXsdSchema() throws Exception {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        InputStream xsdStream = new ByteArrayInputStream(xsdContent.getBytes());
        Schema schema = factory.newSchema(new StreamSource(xsdStream));
        Validator validator = schema.newValidator();

        // 🔹 Use a Set to store unique validation errors
        Set<String> errorMessages = new LinkedHashSet<>();

        validator.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) {
                errorMessages.add("Warning: " + exception.getMessage());
            }

            @Override
            public void error(SAXParseException exception) {
                errorMessages.add("Error: " + exception.getMessage());
            }

            @Override
            public void fatalError(SAXParseException exception) {
                errorMessages.add("Fatal Error: " + exception.getMessage());
            }
        });

        try {
            InputStream xmlStream = new ByteArrayInputStream(xmlContent.getBytes());
            validator.validate(new StreamSource(xmlStream));

            if (errorMessages.isEmpty()) {
                System.out.println("✅ XML is valid against XSD!");
            } else {
                throw new AssertionError("XML validation failed with errors:\n" + String.join("\n", errorMessages));
            }
        } catch (Exception e) {
            throw new AssertionError("XML validation failed with unexpected error: " + e.getMessage());
        }
    }

}
