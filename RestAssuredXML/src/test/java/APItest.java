import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.xml.XmlPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.nio.charset.StandardCharsets;
public class APItest {

    private static final String XML_FILE_PATH = "xxx/xxx/xxx";
    private static final String XSD_SCHEMA_PATH = "xxxxxxxxxxxx/xxxxxxxxxxx/xxxx";
    private static String xmlContent;

    @BeforeClass
    public void loadXmlFile() throws Exception {
        xmlContent = new String(Files.readAllBytes(Paths.get(XML_FILE_PATH))); // Read XML file
    }

    @Test(priority = 1)
    public void validateXsdSchema() throws Exception {
        File xmlFile = new File(XML_FILE_PATH);
        File xsdFile = new File(XSD_SCHEMA_PATH);

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(xsdFile);
        Validator validator = schema.newValidator();

        try {
            validator.validate(new StreamSource(xmlFile));
            System.out.println("XML is valid against XSD!");
        } catch (Exception e) {
            throw new AssertionError("XML validation failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void checkCompetitorType() {
        XmlPath xmlPath = new XmlPath(xmlContent);
        System.out.println();
        String tournamentStageGender = xmlPath.getString("spocosy.query-response.sport.tournament_template.tournament.tournament_stage.@gender");

        assertThat("Check tournamentStage Gender", tournamentStageGender, equalTo("male"));
    }

}
