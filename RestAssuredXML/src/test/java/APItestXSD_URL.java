import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class APItestXSD_URL {

    private static final String XML_FILE_PATH = "/xxxxxxx/xxxxxxxxx/xxxxxxxxx"; // Replace with actual API URL later
    private static final String XSD_URL = "xxxxxxxxxxx/xxxxxxxxxxx"; // Update with actual XSD path later
    private static String xmlContent; // Shared response for all tests
    private static String xsdContent; // Shared XSD schema

    @BeforeClass
    public void loadXmlFile() throws Exception {
        xmlContent = new String(Files.readAllBytes(Paths.get(XML_FILE_PATH))); // Read XML file

        // 🔹 Fetch XSD schema from URL
        Response xsdResponse = RestAssured.get(XSD_URL);
        xsdContent = new String(xsdResponse.getBody().asByteArray(), StandardCharsets.UTF_8).trim();
    }

//    @Test(priority = 1)
//    public void validateXsdSchema() throws Exception {
//
//    }

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
                System.out.println(" XML is valid against XSD!");
            } else {
                throw new AssertionError("XML validation failed with errors:\n" + String.join("\n", errorMessages));
            }
        } catch (Exception e) {
            throw new AssertionError("XML validation failed with unexpected error: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void checkCompetitorType() {
        XmlPath xmlPath = new XmlPath(xmlContent);

        // 🔹 Extract competitorType as a list of strings
        List<String> competitorTypes = xmlPath.getList("Usdf20.EventStandings.@CompetitorType");
            System.out.println(competitorTypes);
        // 🔹 Assert that each element in the list is "INDIVIDUAL"
        assertThat("Check competitorType", competitorTypes.get(0), equalTo("INDIVIDUAL"));

    }

//    @Test(priority = 1)
//    public void validateDataValueTypes() {
//        XmlPath xmlPath = new XmlPath(xmlContent);
//
//        String competitorType = xmlPath.getString("Usdf20.EventStandings.@CompetitorType");
//        if (competitorType.equals("INDIVIDUAL")) {
//            // 🔹 Get list of athletes
//            List<Map<String, Object>> allAthletes = xmlPath.getList("Usdf20.EventStandings.Athlete");
//
//            for (Map<String, Object> athlete : allAthletes) {
//
//                    // Validate athlete ID
//                    assertThat("Athlete ID should be a non-empty string", athlete.get("@id"), instanceOf(String.class));
//                    assertThat("Athlete ID should be a number", Integer.parseInt((String) athlete.get("@id")), instanceOf(Number.class));
//
//                    // Validate organisation ID
//                    Map<String, Object> organisation = (Map<String, Object>) athlete.get("Organisation");
//                    assertThat("Organisation ID should be a non-empty string", organisation.get("@id"), instanceOf(String.class));
//                    assertThat("Organisation ID should be a number", Integer.parseInt((String) organisation.get("@id")), instanceOf(Number.class));
//
//                    // Validate result properties
//                    Map<String, Object> result = (Map<String, Object>) athlete.get("Result");
//                    assertThat("Sort order should be a number", Integer.parseInt((String) result.get("@sortOrder")), instanceOf(Number.class));
//                    assertThat("Rank should be a number", Integer.parseInt((String) result.get("@rank")), instanceOf(Number.class));
//
//                    // Validate athlete order
//                    assertThat("Athlete order should be a number", Integer.parseInt((String) athlete.get("@order")), instanceOf(Number.class));
//                }
//            } else { // TEAM competitorType
//                List<Map<String, Object>> allTeams = xmlPath.getList("Usdf20.EventStandings.Team");
//
//                for (Map<String, Object> team : allTeams) {
////                    List<Map<String, Object>> teamAthletes = team.getClass("Team.Athlete");
//
//                    for (Map<String, Object> athlete : teamAthletes) {
//                        // Validate athlete ID
//                        assertThat("Athlete ID should be a non-empty string", athlete.get("@id"), instanceOf(String.class));
//                        assertThat("Athlete ID should be a number", Integer.parseInt((String) athlete.get("@id")), instanceOf(Number.class));
//
//                        // Validate organisation properties
//                        Map<String, Object> organisation = (Map<String, Object>) athlete.get("Organisation");
//                        assertThat("Organisation ID should be a non-empty string", organisation.get("@id"), instanceOf(String.class));
//                        assertThat("Organisation ID should be a number", Integer.parseInt((String) organisation.get("@id")), instanceOf(Number.class));
//                        assertThat("Organisation name should be a non-empty string", organisation.get("@name"), instanceOf(String.class));
//                        assertThat("Organisation type should be a non-empty string", organisation.get("@type"), instanceOf(String.class));
//                        assertThat("Organisation country should be a non-empty string", organisation.get("@country"), instanceOf(String.class));
//
//                        // Validate athlete name fields
//                        assertThat("Athlete given name should be a non-empty string", athlete.get("@givenName"), instanceOf(String.class));
//                        assertThat("Athlete family name should be a non-empty string", athlete.get("@familyName"), instanceOf(String.class));
//                    }
//
//                    // Validate team properties
//                    Map<String, Object> result = (Map<String, Object>) team.get("Result");
//                    assertThat("Team sort order should be a number", Integer.parseInt((String) result.get("@sortOrder")), instanceOf(Number.class));
//                    assertThat("Team rank should be a number", Integer.parseInt((String) result.get("@rank")), instanceOf(Number.class));
//
//                    assertThat("Team ID should be a string", team.get("@id"), instanceOf(String.class));
//                    assertThat("Team gender should be a string", team.get("@gender"), instanceOf(String.class));
//                    assertThat("Team name should be a string", team.get("@name"), instanceOf(String.class));
//                    assertThat("Team order should be a number", Integer.parseInt((String) team.get("@order")), instanceOf(Number.class));
//                }
//            }
//        }
//
//    }

}
