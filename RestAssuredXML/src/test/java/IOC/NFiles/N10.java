package IOC.NFiles;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.testClasses.NFiles.*;

import java.nio.charset.StandardCharsets;

public class N10 {
    // Initialize instances
    private HTML_Format_Validator htmlFormatValidator;
    private XML_Format_Validator xmlFormatValidator;
    private ValidateDataValueTypes validateDataValueTypes;
    private HardcodedValues hardcodedValues;
    private AttributesFormat attributesFormat;

    // Credentials for the XML url
    private static final String USERNAME = "xxxxxxxxx";
    private static final String PASSWORD = "xxxxxxxxxxx";

    private static String xmlContent;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "xxxxxxxxxxxx";

        // Initialize instances
        htmlFormatValidator = new HTML_Format_Validator(xmlUrl);
        xmlFormatValidator = new XML_Format_Validator(xmlUrl);
        validateDataValueTypes = new ValidateDataValueTypes(xmlUrl);
        hardcodedValues = new HardcodedValues(xmlUrl);
        attributesFormat = new AttributesFormat(xmlUrl);

        // Fetch XML data WITH authentication
        Response xmlResponse = RestAssured
                .given()
                .auth().basic(USERNAME, PASSWORD)  // 🔹 Authentication ONLY for XML request
                .when()
                .get(xmlUrl);

        xmlContent = new String(xmlResponse.getBody().asByteArray(), StandardCharsets.UTF_8).trim(); // Trim leading/trailing spaces
    }

    @Test(priority = 1)
    public void checkXmlValidation() throws Exception {
//        xmlFormatValidator.fetchXml();
        xmlFormatValidator.validateXmlFormated(xmlContent);
    }

    @Test(priority = 2)
    public void checkHtmlValidation() throws Exception {
//        htmlFormatValidator.fetchXmlFile();
        htmlFormatValidator.validateHtmlFormat(xmlContent);
    }

    @Test(priority = 3)
    public void validateDataValues() throws Exception {
        validateDataValueTypes.validateDataValueTypes(xmlContent);
    }

    @Test(priority = 4)
    public void checkAllElementsAttributes() throws Exception {
        hardcodedValues.checkOdfBodyAttributes(xmlContent,"OWG2026","ALP102N10","DT_BCK_IMP","ENG","T","HR");
        hardcodedValues.checkCompetitionAttributes(xmlContent,"OWG-2026-GEN-4.4","OWG-2026-6.0.0");
        hardcodedValues.checkCategoryAttributes(xmlContent,"ALP","Alpine Skiing","Y");
        hardcodedValues.checkDocumentAttributes(xmlContent,"0","MDL","Past Medallists","102N10","ALP0210","H");
    }

    @Test(priority = 5)
    public void checkAttributesFormats() throws Exception {
        //load the xml file
        attributesFormat.setUp(xmlContent);

        //check the Time format
        attributesFormat.testTimeFormat();

        //check the Version format
        attributesFormat.testVersionFormat();

        //check the Date format
        attributesFormat.testDateFormat();

        //check the LogicalDate format
        attributesFormat.testLogicalDateFormat();

        //check the DocumentCode format
        attributesFormat.testDocumentCodeFormat();

        //check the competition Gen format
        attributesFormat.testCompetitionGenFormat();

        //check the competition Codes format
        attributesFormat.testCompetitionCodesFormat();

        //check the odfBody DocumentSubCode format
        attributesFormat.testDocumentSubCodeFormat();
    }

}
