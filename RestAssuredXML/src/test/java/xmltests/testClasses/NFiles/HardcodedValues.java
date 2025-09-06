package xmltests.testClasses.NFiles;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.modelClasses.nFiles.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class HardcodedValues {

    //    private static final String XML_FILE_PATH = "./eventStanding.xml"; // Replace with actual API URL later
//    private static final String XML_URL = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; // Update with actual API URL
    private String xmlUrl;

//    private static final String USERNAME = "xxxxxxxxxxxxxx";
//    private static final String PASSWORD = "xxxxxxxxxxxxxxx";
//
//    private String xmlContent; // Shared response for all tests

    // 🔹 Constructor to set XML URL dynamically
    public HardcodedValues(String xmlUrl) {
        this.xmlUrl = xmlUrl;
    }

//    @BeforeClass
//    public void loadXmlFile() throws JAXBException {
////        xmlContent = new String(Files.readAllBytes(Paths.get(XML_FILE_PATH))); // Read XML file
//        // 🔹 Fetch XML data WITH authentication
//        Response xmlResponse = RestAssured
//                .given()
//                .auth().basic(USERNAME, PASSWORD)  // 🔹 Authentication ONLY for XML request
//                .when()
//                .get(xmlUrl);
//
//        xmlContent = xmlResponse.getBody().asString().trim();// Trim leading/trailing spaces
//
//    }

    //tests with hardcoded values
    //odfBody
    @Test
    public void checkOdfBodyAttributes(String xmlContent,String competitorCode,String documentSubCode, String documentType, String language
    , String feedFlag, String source) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for odfBody
        assertEquals(odfBody.getCompetitionCode(), competitorCode, "check odfBody competitorCode");
        //added if operator because "documentSubCode" is not presented in every type of the N files (ex. N22)
        if (documentSubCode != null) {
            assertEquals(odfBody.getDocumentSubcode(), documentSubCode, "check odfBody documentSubCode");
        }
        //assertEquals(odfBody.getDocumentSubcode(), documentSubCode, "check odfBody documentSubCode");
        assertEquals(odfBody.getDocumentType(), documentType, "check odfBody documentType");
        assertEquals(odfBody.getLanguage(), language, "check odfBody language");
        assertEquals(odfBody.getFeedFlag(), feedFlag, "check odfBody feedFlag");
        //added if operator because "source" is not presented in every type of the N files (ex. N24)
        if (source != null) {
            assertEquals(odfBody.getSource(), source, "check odfBody source");
        }
        //assertEquals(odfBody.getSource(), source, "check odfBody source");
    }

    //Competition
    @Test
    public void checkCompetitionAttributes(String xmlContent,String gen) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for Competition
        Competition competition = odfBody.getCompetition();

        assertEquals(competition.getGen(), gen, "check Competition gen");
//        assertEquals(competition.getCodes(), codes, "check Competition codes");
    }

    //Category
    @Test
    public void checkCategoryAttributes(String xmlContent,String code, String categoryName,String main) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for Competition
        Category category = odfBody.getCompetition().getCategories().getCategory();

        assertEquals(category.getCode(), code, "check Category code");
        assertEquals(category.getCategoryName(), categoryName, "check Category categoryName");
        assertEquals(category.getMain(), main, "check Category main");
    }

    //Document
    @Test
    public void checkDocumentAttributes(String xmlContent,String parent, String reportType,String reportTypeName, String sortOrder, String fileName, String reportFormat) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for Document
        Document document = odfBody.getCompetition().getDocument();

        assertEquals(document.getParent(), parent, "check Document parent");
        assertEquals(document.getReportType(), reportType, "check Document reportType");
        assertEquals(document.getReportTypeName(), reportTypeName, "check Document reportTypeName");
        assertEquals(document.getSortOrder(), sortOrder, "check Document sortOrder");
        assertEquals(document.getFileName(), fileName, "check Document fileName");
        assertEquals(document.getReportFormat(), reportFormat, "check Document reportFormat");
    }

    //TeamBiography
    @Test
    public void checkTeamBiographyAttributes(String xmlContent,String gender, String organisation,String name, String current, String externalCode) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for TeamBiography
        TeamBiography teamBiography = odfBody.getCompetition().getTeamBiography();

        assertEquals(teamBiography.getGender(), gender, "check TeamBiography gender");
        assertEquals(teamBiography.getOrganisation(), organisation, "check TeamBiography organisation");
        assertEquals(teamBiography.getName(), name, "check TeamBiography name");
        assertEquals(teamBiography.getCurrent(), current, "check TeamBiography current");
        assertEquals(teamBiography.getExternalCode(), externalCode, "check TeamBiography externalCode");
    }

    //Language to TeamBiography
    @Test
    public void checkTeamBiographyLanguageAttributes(String xmlContent,String language) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for Language to TeamBiography
        Language llanguage = odfBody.getCompetition().getTeamBiography().getLanguage();

        assertEquals(llanguage.getLanguage(), language, "check Language language");
    }

    //Discipline
    @Test
    public void checkDisciplineAttributes(String xmlContent,String code) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for Discipline
        Discipline discipline = odfBody.getCompetition().getTeamBiography().getDiscipline();

        assertEquals(discipline.getCode(), code, "check Discipline code");
    }

    //RegisteredEvent
    @Test
    public void checkRegisteredEventAttributes(String xmlContent,String event) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for RegisteredEvent
        RegisteredEvent registeredEvent = odfBody.getCompetition().getTeamBiography().getDiscipline().getRegisteredEvent();

        assertEquals(registeredEvent.getEvent(), event, "check RegisteredEvent event");
    }

    //Organisation
    @Test
    public void checkOrganisationAttributes(String xmlContent,String current, String externalCode, String code  ) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for Organisation
        Organisation organisation = odfBody.getCompetition().getOrganisation();

        assertEquals(organisation.getCurrent(), current, "check Organisation current");
        assertEquals(organisation.getExternalCode(), externalCode, "check Organisation externalCode");
        assertEquals(organisation.getCode(), code, "check Organisation code");
    }

    //Language to Organisation
    @Test
    public void checkOrganisationLanguageAttributes(String xmlContent,String language) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for Language to Organisation
        Language llanguage = odfBody.getCompetition().getOrganisation().getLanguage();

        assertEquals(llanguage.getLanguage(), language, "check Language language");
    }

}
