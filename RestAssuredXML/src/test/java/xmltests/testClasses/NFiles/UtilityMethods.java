package xmltests.testClasses.NFiles;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UtilityMethods {

    private String xmlUrl;

    private static final String USERNAME = "xxxxxxxxxxxx";
    private static final String PASSWORD = "xxxxxxxxxxxx";

    private String xmlContent; // Shared response for all tests

    // 🔹 Constructor to set XML URL dynamically
    public UtilityMethods(String xmlUrl) {
        this.xmlUrl = xmlUrl;
    }

    @BeforeClass
    public void loadXmlFile() throws JAXBException {
//        xmlContent = new String(Files.readAllBytes(Paths.get(XML_FILE_PATH))); // Read XML file
        // 🔹 Fetch XML data WITH authentication
        Response xmlResponse = RestAssured
                .given()
                .auth().basic(USERNAME, PASSWORD)  // 🔹 Authentication ONLY for XML request
                .when()
                .get(xmlUrl);

        xmlContent = xmlResponse.getBody().asString().trim();// Trim leading/trailing spaces

    }

    // valid date format
    public static boolean isValidDateFormat(String dateStr, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    //is a certain value an integer
    public static boolean isAnInteger(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // valid value format
    public static boolean isValidValueFormat(String valueStr, String regex) {
            return Pattern.matches(regex, valueStr);
    }

}
