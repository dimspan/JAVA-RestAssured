package xmltests.testClasses.NFiles;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.modelClasses.nFiles.*;
import xmltests.modelClasses.nFiles.Competition;
import xmltests.modelClasses.nFiles.Discipline;
import xmltests.modelClasses.nFiles.Record;
import xmltests.modelClasses.xmlData.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertFalse;

public class ValidateDataValueTypes {

    //    private static final String XML_FILE_PATH = "./eventStanding.xml"; // Replace with actual API URL later
//    private static final String XML_URL = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; // Update with actual API URL
    private String xmlUrl;

    // 🔹 Constructor to set XML URL dynamically
    public ValidateDataValueTypes(String xmlUrl) {
        this.xmlUrl = xmlUrl;
    }

    //tests validating data value types
    //dt records
    @Test
    public void validateDataValueTypesDTRecords(String xmlContent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the response is not null
        assertNotNull(odfBody, "OdfBody object is empty");
        assertNotNull(odfBody.getRecord(), "Record object is empty");

        for (Record record : odfBody.getRecord()) {
            // Assert that parsed values match expected types
            assertNotNull(record.getCode(), "record object code value type");

            //check the recordType attributes value types
            RecordType recordType = record.getRecordType();
            assertNotNull(recordType.getOrder(), "recordType object order value type");
            assertNotNull(recordType.getShared(), "recordType object shared value type");
            assertNotNull(recordType.getRecordType(), "recordType object record type value type");

            //check the recordData attributes value types
            RecordData recordData = recordType.getRecordData();
            assertNotNull(recordData.getOrder(), "recordData object order value type");
            assertNotNull(recordData.getResultType(), "recordData object result type value type");
            assertNotNull(recordData.getResult(), "recordData object result value type");
            assertNotNull(recordData.getCountry(), "recordData object country value type");
            assertNotNull(recordData.getDate(), "recordData object date value type");
            assertNotNull(recordData.getCompetition(), "recordData object competition value type");
            assertNotNull(recordData.getHistorical(), "recordData object historical value type");
            assertNotNull(recordData.getCurrent(), "recordData object current value type");

            // Check if Place is present and validate it
            if (recordData.getPlace() != null) {
                try {
                    assertNotNull(recordData.getPlace(), "recordData object place value type");
                } catch (NumberFormatException e) {
                    Assert.fail("Record data object with place attribute should be available: " + e.getMessage());
                }
            }

            //check the extension objects if available
            if (recordData.getExtension() != null) {
                try {
                    for (Extension extension : recordData.getExtension()) {
                        assertNotNull(extension.getType(), "extension object type value type");
                        assertNotNull(extension.getPos(), "extension object pos value type");
                        assertNotNull(extension.getCode(), "extension object code value type");
                        assertNotNull(extension.getValue(), "extension object value value type");
                    }
                } catch (NumberFormatException e) {
                    Assert.fail("Record data object with place attribute should be available: " + e.getMessage());
                }
            }


            //check the competitor object
            Competitor competitor = recordData.getCompetitor();
            assertNotNull(competitor.getCode(), "competitor object code value type");
            assertNotNull(competitor.getType(), "competitor object type value type");
            assertNotNull(competitor.getOrganisation(), "competitor object organisation value type");

            //check the athlete object
            Composition composition = competitor.getComposition();
            Athlete athlete = composition.getAthlete();
            assertNotNull(athlete.getCode(), "athlete object code value type");
            assertNotNull(athlete.getOrder(), "athlete object order value type");

            //check the athlete description object
            Description description = athlete.getDescription();
            assertNotNull(description.getGivenName(), "description object given name value type");
            assertNotNull(description.getFamilyName(), "description object family name value type");
            assertNotNull(description.getGender(), "description object gender value type");
            assertNotNull(description.getOrganisation(), "description object organisation value type");
            assertNotNull(description.getBirthDate(), "description object birth date value type");

        }
    }

    //N11 & N10, etc.
    @Test
    public void validateDataValueTypes(String xmlContent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the odfBody element and attributes response is not null
        assertNotNull(odfBody, "OdfBody object is empty");
        assertNotNull(odfBody.getCompetitionCode(), "odfBody competitionCode object is empty");
        assertNotNull(odfBody.getDocumentCode(), "odfBody DocumentCode object is empty");
        assertNotNull(odfBody.getDocumentSubcode(), "odfBody DocumentSubcode object is empty");
        assertNotNull(odfBody.getDocumentType(), "odfBody DocumentType object is empty");
        assertNotNull(odfBody.getVersion(), "odfBody Version object is empty");
        assertNotNull(odfBody.getLanguage(), "odfBody Language object is empty");
        assertNotNull(odfBody.getFeedFlag(), "odfBody FeedFlag object is empty");
        assertNotNull(odfBody.getDate(), "odfBody Date object is empty");
        assertNotNull(odfBody.getTime(), "odfBody Time object is empty");
        assertNotNull(odfBody.getLogicalDate(), "odfBody LogicalDate object is empty");
        assertNotNull(odfBody.getSource(), "odfBody Source object is empty");

        //check the competition element and attributes response is not null
        Competition competition = odfBody.getCompetition();

        assertNotNull(competition, "Competition object is empty");
        assertNotNull(competition.getGen(), "Competition Gen object is empty");
        assertNotNull(competition.getCodes(), "Competition Codes object is empty");

        //check the Category element and attributes response is not null
        Category category = competition.getCategories().getCategory();

        assertNotNull(category, "Category object is empty");
        assertNotNull(category.getCode(), "Category Code object is empty");
        assertNotNull(category.getCategoryName(), "Category CategoryName object is empty");
        assertNotNull(category.getMain(), "Category Main object is empty");

        //check the Document element and attributes response is not null
        Document document = competition.getDocument();

        assertNotNull(document, "Document object is empty");
        assertNotNull(document.getParent(), "Document Parent object is empty");
        assertNotNull(document.getReportType(), "Document ReportType object is empty");
        assertNotNull(document.getReportTypeName(), "Document ReportTypeName object is empty");
        assertNotNull(document.getSortOrder(), "Document SortOrder object is empty");
        assertNotNull(document.getFileName(), "Document FileName object is empty");
        assertNotNull(document.getReportFormat(), "Document ReportFormat object is empty");

        //check the Title element and attributes response is not null
        Title title = competition.getDocument().getTitle();

        assertNotNull(title, "Title object is empty");

    }

    //N22
    @Test
    public void validateDataValueTypesBiography(String xmlContent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the odfBody element and attributes response is not null
        assertNotNull(odfBody, "OdfBody object is empty");
        assertNotNull(odfBody.getCompetitionCode(), "odfBody competitionCode object is empty");
        assertNotNull(odfBody.getDocumentCode(), "odfBody DocumentCode object is empty");
        assertNotNull(odfBody.getDocumentType(), "odfBody DocumentType object is empty");
        assertNotNull(odfBody.getVersion(), "odfBody Version object is empty");
        assertNotNull(odfBody.getLanguage(), "odfBody Language object is empty");
        assertNotNull(odfBody.getFeedFlag(), "odfBody FeedFlag object is empty");
        assertNotNull(odfBody.getDate(), "odfBody Date object is empty");
        assertNotNull(odfBody.getTime(), "odfBody Time object is empty");
        assertNotNull(odfBody.getLogicalDate(), "odfBody LogicalDate object is empty");
        assertNotNull(odfBody.getSource(), "odfBody Source object is empty");

        //check the Competition element and attributes response is not null
        Competition competition = odfBody.getCompetition();

        assertNotNull(competition, "Competition object is empty");
        assertNotNull(competition.getGen(), "Competition Gen object is empty");
        assertNotNull(competition.getCodes(), "Competition Codes object is empty");

        //check the TeamBiography element and attributes response is not null
        TeamBiography teamBiography = competition.getTeamBiography();

        assertNotNull(teamBiography, "TeamBiography object is empty");
        assertNotNull(teamBiography.getGender(), "TeamBiography Gender object is empty");
        assertNotNull(teamBiography.getOrganisation(), "TeamBiography Organisation object is empty");
        assertNotNull(teamBiography.getName(), "TeamBiography Name object is empty");
        assertNotNull(teamBiography.getCurrent(), "TeamBiography Current object is empty");
        assertNotNull(teamBiography.getExternalCode(), "TeamBiography ExternalCode object is empty");

        //check the Language element and attributes response is not null
        Language language = competition.getTeamBiography().getLanguage();

        assertNotNull(language, "Language object is empty");
        assertNotNull(language.getLanguage(), "Language Language object is empty");

        //check the Discipline element and attributes response is not null
        Discipline discipline = competition.getTeamBiography().getDiscipline();

        assertNotNull(discipline, "Discipline object is empty");
        assertNotNull(discipline.getCode(), "Discipline Code object is empty");

        //check the RegisteredEvent element and attributes response is not null
        RegisteredEvent registeredEvent = competition.getTeamBiography().getDiscipline().getRegisteredEvent();

        assertNotNull(registeredEvent, "RegisteredEvent object is empty");
        assertNotNull(registeredEvent.getEvent(), "RegisteredEvent Event object is empty");
    }

    //N24
    @Test
    public void validateDataValueTypesProfile(String xmlContent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OdfBody.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OdfBody odfBody = (OdfBody) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the odfBody element and attributes response is not null
        assertNotNull(odfBody, "OdfBody object is empty");
        assertNotNull(odfBody.getCompetitionCode(), "odfBody competitionCode object is empty");
        assertNotNull(odfBody.getDocumentCode(), "odfBody DocumentCode object is empty");
        assertNotNull(odfBody.getDocumentType(), "odfBody DocumentType object is empty");
        assertNotNull(odfBody.getVersion(), "odfBody Version object is empty");
        assertNotNull(odfBody.getLanguage(), "odfBody Language object is empty");
        assertNotNull(odfBody.getFeedFlag(), "odfBody FeedFlag object is empty");
        assertNotNull(odfBody.getDate(), "odfBody Date object is empty");
        assertNotNull(odfBody.getTime(), "odfBody Time object is empty");
        assertNotNull(odfBody.getLogicalDate(), "odfBody LogicalDate object is empty");

        //check the Competition element and attributes response is not null
        Competition competition = odfBody.getCompetition();

        assertNotNull(competition, "Competition object is empty");
        assertNotNull(competition.getGen(), "Competition Gen object is empty");
        assertNotNull(competition.getCodes(), "Competition Codes object is empty");

        //check the Organisation element and attributes response is not null
        Organisation organisation = competition.getOrganisation();

        assertNotNull(organisation, "Organisation object is empty");
        assertNotNull(organisation.getCurrent(), "Organisation Current object is empty");
        assertNotNull(organisation.getExternalCode(), "Organisation ExternalCode object is empty");
        assertNotNull(organisation.getCode(), "Organisation Code object is empty");

        //check the Language element and attributes response is not null
        Language language = competition.getOrganisation().getLanguage();

        assertNotNull(language, "Language object is empty");
        assertNotNull(language.getLanguage(), "Language Language object is empty");
    }

}
