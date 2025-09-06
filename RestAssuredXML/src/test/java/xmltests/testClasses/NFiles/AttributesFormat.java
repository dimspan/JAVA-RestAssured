package xmltests.testClasses.NFiles;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.modelClasses.nFiles.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class AttributesFormat {

    private String xmlUrl;
    OdfBody odfBody;

    private UtilityMethods utilityMethods;

    // 🔹 Constructor to set XML URL dynamically
    public AttributesFormat(String xmlUrl) {
        this.xmlUrl = xmlUrl;
    }

    @BeforeClass
    public void setUp(String xmlContent) throws JAXBException {
//        xmlContent = new String(Files.readAllBytes(Paths.get(XML_FILE_PATH))); // Read XML file

        // Initialize instances
        utilityMethods = new UtilityMethods(xmlUrl);

        //Get the main element before all the separate tests
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));
    }

    //tests for attributes format
    @Test
    public void testDateFormat() {
        String date = odfBody.getDate();
        Assert.assertTrue(utilityMethods.isValidDateFormat(date, "yyyy-MM-dd"), "Invalid Date format.");
    }

    @Test
    public void testLogicalDateFormat() {
        String logicalDate = odfBody.getLogicalDate();
        Assert.assertTrue(utilityMethods.isValidDateFormat(logicalDate, "yyyy-MM-dd"), "Invalid LogicalDate format.");
    }

    @Test
    public void testTimeFormat() {
        String time = odfBody.getTime();
        Assert.assertTrue(utilityMethods.isAnInteger(time), "Time value should be an integer");
        Assert.assertEquals(time.length(), 9, "Time value must be exactly 9 characters long");
    }

    @Test
    public void testVersionFormat() {
        String version = odfBody.getVersion();
        Assert.assertTrue(utilityMethods.isAnInteger(version), "Version value should be an integer");
    }

    @Test
    public void testCompetitionGenFormat() {
        Competition competition = odfBody.getCompetition();
        String compGen = competition.getGen();
        Assert.assertTrue(utilityMethods.isValidValueFormat(compGen,"^OWG-\\d{4}-GEN-\\d+\\.\\d+$"), "competition Gen value should be correct according to regex");
    }

    @Test
    public void testCompetitionCodesFormat() {
        Competition competition = odfBody.getCompetition();
        String compCodes = competition.getCodes();
        Assert.assertTrue(utilityMethods.isValidValueFormat(compCodes,"^OWG-\\d{4}-\\d+\\.\\d+\\.\\d+$"), "competition Codes value should be correct according to regex");
    }

    @Test
    public void testDocumentSubCodeFormat() {
        String docSubCode = odfBody.getDocumentSubcode();
        System.out.println(docSubCode);
        Assert.assertTrue(utilityMethods.isValidValueFormat(docSubCode,"^[A-Z]{3}\\d{3}[A-Z]\\d{2}$"), "DocumentSubCode value should be correct according to regex");
    }

    @Test
    public void testDocumentCodeFormat() {
        String documentCode = odfBody.getDocumentCode();
        Assert.assertEquals(documentCode.length(), 34, "DocumentCode value must be exactly 34 characters long");
    }
    //for N22 and N24
    @Test
    public void testDocumentCodeFormatBiographyAndProfileFiles() {
        String documentCode = odfBody.getDocumentCode();
        Assert.assertEquals(documentCode.length(), 13, "DocumentCode value must be exactly 13 characters long");
    }

}