package xmltests.testClasses.HistoricalData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.modelClasses.xmlData.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpecialPropertiesCodesRegex {

    //    private static final String XML_FILE_PATH = "./eventStanding.xml"; // Replace with actual API URL later
//    private static final String XML_URL = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; // Update with actual API URL
    private String xmlUrl;

    private static final String USERNAME = "xxxxxxxx";
    private static final String PASSWORD = "xxxxxxxxxxxx";

    private String xmlContent; // Shared response for all tests

    // 🔹 Constructor to set XML URL dynamically
    public SpecialPropertiesCodesRegex(String xmlUrl) {
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

    //tests with special codes regex
    //event standings
    @Test
    public void checkEventStandingsSpecialCodes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        for (EventStanding eventStanding : usdf20.getEventStandings()) {
            //get event standing competitorType
            String currCompetitorType = eventStanding.getCompetitorType();
            //Individual event
            if(currCompetitorType.equals("INDIVIDUAL")){
                // Validate gender
                String gender = eventStanding.getGender();
                assertTrue(Pattern.matches("SGEN\\$\\w+", gender), "Invalid individual gender special code: " + gender);
                // Validate type
                String type = eventStanding.getType();
                assertTrue(Pattern.matches("EVNT\\$\\w.+", type), "Invalid individual type special code: " + type);
            }
            else {
                // Validate gender
                String gender = eventStanding.getGender();
                assertTrue(Pattern.matches("SGEN\\$\\w+", gender), "Invalid team gender special code: " + gender);

                // Validate type
                String type = eventStanding.getType();
                assertTrue(Pattern.matches("EVNT\\$\\w.+", type), "Invalid team type special code: " + type);

                // Validate status
                String status = eventStanding.getStatus();
                assertTrue(Pattern.matches("RCST\\$\\w+", status), "Invalid team status special code: " + status);
            }
        }
    }

    @Test
    public void checkEventStandingsSpecialCodesForAthletes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        for (EventStanding eventStanding : usdf20.getEventStandings()) {
            //get event standing competitorType
            String currCompetitorType = eventStanding.getCompetitorType();
            //Individual event
            if(currCompetitorType.equals("INDIVIDUAL")){
                for (Athlete athlete : eventStanding.getAthletes()) {

                    // Validate medal kind
                    Medal medalObject = athlete.getMedal();
                    if (medalObject != null) {
                        String athleteMedalKind = medalObject.getKind();
                        assertTrue(Pattern.matches("AWSB\\$\\w+", athleteMedalKind), "Invalid athlete medal kind special code: " + athleteMedalKind);
                    }

                    // Validate result valueType
                    Result resultObject = athlete.getResult();
                    String athleteResultValueType = resultObject.getValueType();
                    if (athleteResultValueType != null) {
                        assertTrue(Pattern.matches("SC_REST\\$\\w+", athleteResultValueType), "Invalid athlete result valueType special code: " + athleteResultValueType);
                    }
                }
            }
        }
    }

    @Test
    public void checkEventStandingsSpecialCodesForTeams() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        for (EventStanding eventStanding : usdf20.getEventStandings()) {
            //get event standing competitorType
            String currCompetitorType = eventStanding.getCompetitorType();
            //Individual event
            if(currCompetitorType.equals("TEAM")){
                for (Team team : eventStanding.getTeams()) {
                    // Validate NF code
                    NF nfObject = team.getNF();
                    String teamNfCode = nfObject.getCode();
                    assertTrue(Pattern.matches("CNTR\\$\\w+", teamNfCode), "Invalid team NF code special code: " + teamNfCode);

                    // Validate NF country
                    String teamNfCountry = nfObject.getCountry();
                    assertTrue(Pattern.matches("CNTR\\$\\w+", teamNfCountry), "Invalid team NF country special code: " + teamNfCountry);

                    // Validate medal kind
                    Medal medalObject = team.getMedal();
                    if (medalObject != null) {
                        String teamMedalKind = medalObject.getKind();
                        assertTrue(Pattern.matches("AWSB\\$\\w+", teamMedalKind), "Invalid team medal kind special code: " + teamMedalKind);
                    }

                    // Validate result valueType
                    Result resultObject = team.getResult();
                    String teamResultValueType = resultObject.getValueType();
                    if (teamResultValueType != null) {
                        assertTrue(Pattern.matches("SC_REST\\$\\w+", teamResultValueType), "Invalid team result valueType special code: " + teamResultValueType);
                    }
                }
            }
        }
    }

    @Test
    public void checkEventStandingsSpecialCodesForDiscipline() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        for (EventStanding eventStanding : usdf20.getEventStandings()) {
            //get event standing competitorType
            String currCompetitorType = eventStanding.getCompetitorType();
            //Individual event
            if(currCompetitorType.equals("INDIVIDUAL")){
                //Validate discipline code
                Discipline discipline = eventStanding.getDiscipline();
//                String discCode = discipline.getCode();
//                assertTrue(Pattern.matches("SDIS\\$\\w+", discCode), "Invalid individual discipline code special code: " + discCode);

                //Validate competition country
                Competition competition = discipline.getCompetition();
                String compCountry = competition.getCountry();
                assertTrue(Pattern.matches("CNTR\\$\\w+", compCountry), "Invalid individual competition country special code: " + compCountry);

            }
            else {
                //Validate discipline code
                Discipline discipline = eventStanding.getDiscipline();
//                String discCode = discipline.getCode();
//                assertTrue(Pattern.matches("SDIS\\$\\w+", discCode), "Invalid team discipline code special code: " + discCode);

                //Validate competition country
                Competition competition = discipline.getCompetition();
                String compCountry = competition.getCountry();
                assertTrue(Pattern.matches("CNTR\\$\\w+", compCountry), "Invalid team competition country special code: " + compCountry);

            }

        }

    }

    //participants
    @Test
    public void checkParticipantsSpecialCodes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // Validate participants object code
        Participant participant = usdf20.getParticipant();
        String participantId = participant.getId();
        assertTrue(Pattern.matches("SDIS\\$\\w+", participantId), "Invalid code special code: " + participantId);
    }

    @Test
    public void checkParticipantsSpecialCodesAthletes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // get participants object
        Participant participant = usdf20.getParticipant();

        for (Athlete athlete : participant.getAthletes()) {
            // Validate athlete gender code
            String athleteGender = athlete.getGender();
            assertTrue(Pattern.matches("PGEN\\$\\w+", athleteGender), "Invalid athlete gender special code: " + athleteGender);

            // Validate athlete nf country
            NF athleteNF = athlete.getNF();
            String athleteNFCountry = athleteNF.getCountry();
            assertTrue(Pattern.matches("CNTR\\$\\w+", athleteNFCountry), "Invalid athlete nf country special code: " + athleteNFCountry);
        }

    }

    @Test
    public void checkParticipantsSpecialCodesTeams() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // Get participants object
        Participant participant = usdf20.getParticipant();
        //Validate every special code in team attributes
        for (Team team : participant.getTeams()) {
            // Validate team gender code
            String teamGender = team.getGender();
            assertTrue(Pattern.matches("PGEN\\$\\w+", teamGender), "Invalid team gender special code: " + teamGender);

            // Validate team eventType code
            String teamEventType = team.getEventType();
            assertTrue(Pattern.matches("EVNT\\$\\w.+", teamEventType), "Invalid team eventType special code: " + teamEventType);

            // Validate team type code
            String teamType = team.getType();
            assertTrue(Pattern.matches("TTYP\\$\\w+", teamType), "Invalid team type special code: " + teamType);

        }

    }

    //person profile
    @Test
    public void checkPersonProfileSpecialCodes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        PersonProfile personProfile = usdf20.getPersonProfile();
        // Validate personProfile gender code
        String personProfileGender = personProfile.getGender();
        assertTrue(Pattern.matches("PGEN\\$\\w+", personProfileGender), "Invalid personProfile gender special code: " + personProfileGender);

        // Validate personProfile nationality
        String personProfileNationality = personProfile.getNationality();
        assertTrue(Pattern.matches("CNTR\\$\\w+", personProfileNationality), "Invalid personProfile nationality special code: " + personProfileNationality);

    }

    //unit standings
    @Test
    public void checkUnitStandingsSpecialCodes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        for (UnitStanding unitStanding : usdf20.getUnitStandings()) {
            // Validate status
            String status = unitStanding.getStatus();
            assertTrue(Pattern.matches("RCST\\$\\w+", status), "Invalid individual status special code: " + status);

            Event event = unitStanding.getEvent();
            //get event competitorType
            String currCompetitorType = event.getCompetitorType();

            //Individual event
            if(currCompetitorType.equals("INDIVIDUAL")){
                // Validate gender
                String gender = event.getGender();
                assertTrue(Pattern.matches("SGEN\\$\\w+", gender), "Invalid individual gender special code: " + gender);
                // Validate type
                String type = event.getType();
                assertTrue(Pattern.matches("EVNT\\$\\w.+", type), "Invalid individual type special code: " + type);
            }
            else {
                // Validate gender
                String gender = event.getGender();
                assertTrue(Pattern.matches("SGEN\\$\\w+", gender), "Invalid team gender special code: " + gender);

                // Validate type
                String type = event.getType();
                assertTrue(Pattern.matches("EVNT\\$\\w.+", type), "Invalid team type special code: " + type);
            }
        }
    }

    @Test
    public void checkUnitStandingsSpecialCodesForDiscipline() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        for (UnitStanding unitStanding : usdf20.getUnitStandings()) {
            //get unit standing competitorType
            String currCompetitorType = unitStanding.getEvent().getCompetitorType();
            //Individual event
            if(currCompetitorType.equals("INDIVIDUAL")){
                //Validate competition country
                String currUnitStandingsStatus = unitStanding.getStatus();
                assertTrue(Pattern.matches("RCST\\$\\w+", currUnitStandingsStatus), "Invalid unitStandings status special code: " + currUnitStandingsStatus);

                //Validate unitStandings status
                Discipline discipline = unitStanding.getEvent().getDiscipline();
                Competition competition = discipline.getCompetition();
                String compCountry = competition.getCountry();
                assertTrue(Pattern.matches("CNTR\\$\\w+", compCountry), "Invalid individual competition country special code: " + compCountry);

            }
            else {
                //Validate unitStandings status
                String currUnitStandingsStatus = unitStanding.getStatus();
                assertTrue(Pattern.matches("RCST\\$\\w+", currUnitStandingsStatus), "Invalid unitStandings status special code: " + currUnitStandingsStatus);

                //Validate competition country
                Discipline discipline = unitStanding.getEvent().getDiscipline();
                Competition competition = discipline.getCompetition();
                String compCountry = competition.getCountry();
                assertTrue(Pattern.matches("CNTR\\$\\w+", compCountry), "Invalid team competition country special code: " + compCountry);

            }

        }

    }

    //pool standings
    @Test
    public void checkPoolStandingsSpecialCodes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        for (PoolStanding poolStanding : usdf20.getPoolStandings()) {
            // Validate status
            String status = poolStanding.getStatus();
            assertTrue(Pattern.matches("RCST\\$\\w+", status), "Invalid status special code: " + status);

            Event event = poolStanding.getEvent();

            // Validate gender
            String gender = event.getGender();
            assertTrue(Pattern.matches("SGEN\\$\\w+", gender), "Invalid team gender special code: " + gender);

            // Validate type
            String type = event.getType();
            assertTrue(Pattern.matches("EVNT\\$\\w.+", type), "Invalid team type special code: " + type);
        }
    }

    @Test
    public void checkPoolStandingsSpecialCodesForDiscipline() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        for (PoolStanding poolStanding : usdf20.getPoolStandings()) {

            //Validate unitStandings status
            String currPoolStandingsStatus = poolStanding.getStatus();
            assertTrue(Pattern.matches("RCST\\$\\w+", currPoolStandingsStatus), "Invalid unitStandings status special code: " + currPoolStandingsStatus);

            //Validate competition country
            Discipline discipline = poolStanding.getEvent().getDiscipline();
            Competition competition = discipline.getCompetition();
            String compCountry = competition.getCountry();
            assertTrue(Pattern.matches("CNTR\\$\\w+", compCountry), "Invalid team competition country special code: " + compCountry);

        }

    }

    //eventBreakdown
    @Test
    public void eventBreakdownSpecialCodes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        EventBreakdown eventBreakdown = usdf20.getEventBreakdown();

        // Validate gender
        String gender = eventBreakdown.getGender();
        assertTrue(Pattern.matches("SGEN\\$\\w+", gender), "Invalid team gender special code: " + gender);

        // Validate type
        String type = eventBreakdown.getType();
        assertTrue(Pattern.matches("EVNT\\$\\w.+", type), "Invalid team type special code: " + type);

        //Validate poolsStage roundType
        for (PoolsStage poolsStage : eventBreakdown.getPoolsStages()) {
            String roundType = poolsStage.getRoundType();
            assertTrue(Pattern.matches("RTYP\\$\\w.+", roundType), "Invalid team type special code: " + roundType);

            // Validate pool group
            String group = poolsStage.getPool().getGroup();
            assertTrue(Pattern.matches("POOL\\$\\w.+", group), "Invalid team type special code: " + group);

            //Validate poolsStage pool unit
            for (Unit unit : poolsStage.getPool().getUnits()) {
                // Validate pool unit type
                String unitType = unit.getType();
                assertTrue(Pattern.matches("UTYP\\$\\w.+", unitType), "Invalid team type special code: " + unitType);
            }
        }

    }

    @Test
    public void eventBreakdownSpecialCodesForDiscipline() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));


        //Validate discipline id
        EventBreakdown eventBreakdown = usdf20.getEventBreakdown();
        String disciplineId = eventBreakdown.getDiscipline().getId();
        assertTrue(Pattern.matches("SDIS\\$\\w+", disciplineId), "Invalid unitStandings status special code: " + disciplineId);

        //Validate discipline competition country
        String disciplineCountry = eventBreakdown.getDiscipline().getCompetition().getCountry();
        assertTrue(Pattern.matches("CNTR\\$\\w+", disciplineCountry), "Invalid team competition country special code: " + disciplineCountry);



    }

    //competitionProfile
    @Test
    public void checkCompetitionProfileSpecialCodes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //Validate competitionProfile country
        CompetitionProfile competitionProfile = usdf20.getCompetitionProfile();

        String compProfileCountry = competitionProfile.getCountry();
        assertTrue(Pattern.matches("CNTR\\$\\w+", compProfileCountry), "Invalid individual competitionProfile country special code: " + compProfileCountry);

    }
}
