package xmltests.testClasses.HistoricalData;

import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLvalidatorFile {

    private static final String XML_FILE_PATH = "/xxxxxxxx/xxxxx"; // Local XML file
    private static final String XSD_SCHEMA_PATH = "/xxxxxxxx/xxxxxxx"; // Local XSD file
    private static String xmlContent; // XML data
    private static String xsdContent; // XSD data

    @BeforeClass
    public void loadFiles() throws IOException {
        xmlContent = Files.readString(Paths.get(XML_FILE_PATH)); // Load XML
        xsdContent = Files.readString(Paths.get(XSD_SCHEMA_PATH)); // Load XSD
    }

    @Test(priority = 1)
    public void validateXmlAgainstXsd() {
        given()
                .body(xmlContent)
                .when()
                .post("/fakeEndpoint") // Workaround for local file validation
                .then()
                .assertThat()
                .body(RestAssuredMatchers.matchesXsd(xsdContent));

        System.out.println("XML is valid against XSD!");
    }
}

