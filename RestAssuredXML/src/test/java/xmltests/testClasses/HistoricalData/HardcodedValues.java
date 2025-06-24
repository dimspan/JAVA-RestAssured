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
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertFalse;

public class HardcodedValues {

    //    private static final String XML_FILE_PATH = "./eventStanding.xml"; // Replace with actual API URL later
//    private static final String XML_URL = "xxxxxxxxxx"; // Update with actual API URL
    private String xmlUrl;

    private static final String USERNAME = "xxxxxxxxxx";
    private static final String PASSWORD = "xxxxxxxxxx";

    private String xmlContent; // Shared response for all tests

    // 🔹 Constructor to set XML URL dynamically
    public HardcodedValues(String xmlUrl) {
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

    //tests with hardcoded values
    //eventStandings
    @Test
    public void checkEventStandingsAttributes(Integer eventStandingsNumber,String id, String competitorType, String gender,String title, String type,String status) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for eventStandings
        List<EventStanding> eventStandings = usdf20.getEventStandings();
        EventStanding firstEventStanding = eventStandings.get(eventStandingsNumber);

        assertEquals(firstEventStanding.getId(), id, "check 1st eventStanding id");
        assertEquals(firstEventStanding.getCompetitorType(), competitorType, "check 1st eventStanding competitorType");
        assertEquals(firstEventStanding.getGender(), gender, "check 1st eventStanding gender");
        assertEquals(firstEventStanding.getTitle(), title, "check 1st eventStanding title");
        assertEquals(firstEventStanding.getType(), type, "check 1st eventStanding type");
        assertEquals(firstEventStanding.getStatus(), status, "check 1st eventStanding status");

    }
        //Individual event
    @Test
    public void checkEventStandingsFirstAthleteAttributes(Integer eventStandingsNumber,String athleteId,String athleteOrder,String participationName,
                                                          String resultRank,String resultOrder, String resultValue, String resultValueType, String medalDate,
                                                          String medalKind) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //get first eventStanding
        List<EventStanding> eventStandings = usdf20.getEventStandings();
        EventStanding eventStanding = eventStandings.get(eventStandingsNumber);

        //get the 1st athlete and check its attributes
        List<Athlete> athletes = eventStanding.getAthletes();
        Athlete firstAthlete = athletes.get(0);

        assertEquals(firstAthlete.getId(), athleteId, "check 1st athlete id");
        assertEquals(firstAthlete.getOrder(), athleteOrder, "check 1st athlete order");
        assertEquals(firstAthlete.getParticipationName(), participationName, "check 1st athlete participationName");

        //check the attributes for 1st athlete result
        Result result = firstAthlete.getResult();

        assertEquals(result.getRank(), resultRank, "check 1st athlete result rank");
        assertEquals(result.getOrder(), resultOrder, "check 1st athlete result order");
        assertEquals(result.getValue(), resultValue, "check 1st athlete result value");
        assertEquals(result.getValueType(), resultValueType, "check 1st athlete result valueType");

        //check the attributes for 1st athlete medal
        Medal medal = firstAthlete.getMedal();
        if(medal != null){
            assertEquals(medal.getDate(), medalDate, "check 1st athlete medal date");
            assertEquals(medal.getKind(), medalKind, "check 1st athlete medal kind");
        }


    }
        //Team event
    @Test
    public void checkEventStandingsFirstTeamAttributes(Integer eventStandingsNumber,String teamId,String teamOrder,String participationName, String teamNFCode,String teamNfCountry,
                                                       String resultRank,String resultOrder, String resultValue, String resultValueType, String medalDate,
                                                       String medalKind, String firstTeamFirstAthleteId, String firstTeamFirstAthleteOrder, String firstTeamFirstAthleteParticipationName,
                                                       String firstTeamSecondAthleteId, String firstTeamSecondAthleteOrder, String firstTeamSecondAthleteParticipationName) throws JAXBException {
            JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

            //get first eventStanding
            List<EventStanding> eventStandings = usdf20.getEventStandings();
            EventStanding eventStanding = eventStandings.get(eventStandingsNumber);

            //get the 1st team and check its attributes
            List<Team> teams = eventStanding.getTeams();
            Team firstTeam = teams.get(0);
            assertEquals(firstTeam.getId(), teamId, "check 1st team id");
            assertEquals(firstTeam.getOrder(), teamOrder, "check 1st team order");
            assertEquals(firstTeam.getParticipationName(), participationName, "check 1st team participationName");

            //check the attributes for 1st team NF
            NF nf = firstTeam.getNF();
            assertEquals(nf.getCode(), teamNFCode, "check 1st team nf code");
            assertEquals(nf.getCountry(), teamNfCountry, "check 1st team nf country");

            //check the attributes for 1st team result
            Result result = firstTeam.getResult();
            assertEquals(result.getRank(), resultRank, "check 1st team result rank");
            assertEquals(result.getOrder(), resultOrder, "check 1st team result order");
            assertEquals(result.getValue(), resultValue, "check 1st team result value");
            assertEquals(result.getValueType(), resultValueType, "check 1st team result valueType");

            //check the attributes for 1st team medal
            Medal medal = firstTeam.getMedal();
            assertEquals(medal.getDate(), medalDate, "check 1st team medal date");
            assertEquals(medal.getKind(), medalKind, "check 1st team medal kind");

        //check the attributes for 1st team athletes
        List<Athlete> teamAthlete = firstTeam.getAthletes();
        //check first athlete from pair
        Athlete firstAthlete = teamAthlete.get(0);
        assertEquals(firstAthlete.getId(), firstTeamFirstAthleteId, "check 1st team 1st athlete id");
        assertEquals(firstAthlete.getOrder(), firstTeamFirstAthleteOrder, "check 1st team 1st athlete order");
        assertEquals(firstAthlete.getParticipationName(), firstTeamFirstAthleteParticipationName, "check 1st team 1st athlete participation name");
        //check second athlete from pair
        Athlete secondAthlete = teamAthlete.get(1);
        assertEquals(secondAthlete.getId(), firstTeamSecondAthleteId, "check 1st team 2nd athlete id");
        assertEquals(secondAthlete.getOrder(), firstTeamSecondAthleteOrder, "check 1st team 2nd athlete order");
        assertEquals(secondAthlete.getParticipationName(), firstTeamSecondAthleteParticipationName, "check 1st team 2nd athlete participation name");

    }

    @Test
    public void checkEventStandingDisciplineAndChildAttributes(String disciplineId, String disciplineTitle, String compCountry,String compCity,
                                                               String compId, String compTitle) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //get first eventStanding
        List<EventStanding> eventStandings = usdf20.getEventStandings();
        EventStanding firstEventStanding = eventStandings.get(0);
        //get discipline object
        Discipline discipline = firstEventStanding.getDiscipline();

        assertEquals(discipline.getId(), disciplineId, "check discipline id");
        assertEquals(discipline.getTitle(), disciplineTitle, "check discipline title");

        //check the attributes for competition
        Competition competition = discipline.getCompetition();

        assertEquals(competition.getCountry(), compCountry, "check competition country");
        assertEquals(competition.getPlace(), compCity, "check competition place");
        assertEquals(competition.getId(), compId, "check competition id");
        assertEquals(competition.getTitle(), compTitle, "check competition title");

    }
    //participants
    @Test
    public void checkIndividualProfileParticipantAttributes(String id,String title) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for individual profile participants object
        Participant participant = usdf20.getParticipant();

        assertEquals(participant.getId(), id, "check participants object id");
        assertEquals(participant.getTitle(), title, "check participants object title");

    }

    @Test
    public void checkIndividualProfileAthleteAttributes(String athleteId,String dateOfBirth,String participationName, String gender,String familyName,String givenName,
                                                          String height, String weight, String nfCountry)throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for individual profile participants object
        Participant participant = usdf20.getParticipant();

        //get the 1st athlete and check its attributes
        List<Athlete> athletes = participant.getAthletes();
        Athlete firstAthlete = athletes.get(0);

        assertEquals(firstAthlete.getId(), athleteId, "check 1st athlete id");
        assertEquals(firstAthlete.getDateOfBirth(), dateOfBirth, "check 1st athlete dateOfBirth");
        assertEquals(firstAthlete.getParticipationName(), participationName, "check 1st athlete participationName");
        assertEquals(firstAthlete.getGender(), gender, "check 1st athlete gender");
        assertEquals(firstAthlete.getFamilyName(), familyName, "check 1st athlete familyName");
        assertEquals(firstAthlete.getGivenName(), givenName, "check 1st athlete givenName");
        assertEquals(firstAthlete.getHeight(), height, "check 1st athlete height");
        assertEquals(firstAthlete.getWeight(), weight, "check 1st athlete weight");

        //check the attributes for 1st athlete NOC
        NF nfObject = firstAthlete.getNF();

        assertEquals(nfObject.getCountry(), nfCountry, "check 1st athlete nf country");

    }

    @Test
    public void checkIndividualProfileTeamAttributes(Integer teamNumber, String athleteId,String eventType,String participationName, String gender,String type)throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for individual profile participants object
        Participant participant = usdf20.getParticipant();

        //get the 1st athlete and check its attributes
        List<Team> teams = participant.getTeams();
        Team firstTeam = teams.get(teamNumber);

        assertEquals(firstTeam.getId(), athleteId, "check 1st team id");
        assertEquals(firstTeam.getEventType(), eventType, "check 1st team eventType");
        assertEquals(firstTeam.getParticipationName(), participationName, "check 1st team participationName");
        assertEquals(firstTeam.getGender(), gender, "check 1st team gender");
        assertEquals(firstTeam.getType(), type, "check 1st team type");

    }
    //person profile
    @Test
    public void checkPersonProfileAttributes(String id,String gender ,String nationality, String preferredFamilyName, String preferredGivenName, String dateOfBirth,
                                             String height, String weight) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for the first person profile object

        PersonProfile personProfile = usdf20.getPersonProfile();
        assertEquals(personProfile.getId(), id, "check personProfile object id");
        assertEquals(personProfile.getGender(), gender, "check personProfile object gender");
        assertEquals(personProfile.getNationality(), nationality, "check personProfile object nationality");
        assertEquals(personProfile.getPreferredFamilyName(), preferredFamilyName, "check personProfile object preferredFamilyName");
        assertEquals(personProfile.getPreferredGivenName(), preferredGivenName, "check personProfile object preferredGivenName");
        assertEquals(personProfile.getDateOfBirth(), dateOfBirth, "check personProfile object dateOfBirth");
        assertEquals(personProfile.getHeight(), height, "check personProfile object height");
        assertEquals(personProfile.getWeight(), weight, "check personProfile object weight");

    }

    //unitStandings
    @Test
    public void checkUnitStandingsAttributes(Integer unitStandingsNumber,String id,String title,String status) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for eventStandings
        List<UnitStanding> unitStandings = usdf20.getUnitStandings();
        UnitStanding firstUnittanding = unitStandings.get(unitStandingsNumber);

        assertEquals(firstUnittanding.getId(), id, "check 1st eventStanding id");
        assertEquals(firstUnittanding.getTitle(), title, "check 1st eventStanding title");
        assertEquals(firstUnittanding.getStatus(), status, "check 1st eventStanding status");

    }

    @Test
    public void checkUnitStandingsEventAttributes(Integer unitStandingsNumber,String id,String competitorType,String title,String order,String type,String gender) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for eventStandings
        List<UnitStanding> unitStandings = usdf20.getUnitStandings();
        UnitStanding firstUnittanding = unitStandings.get(unitStandingsNumber);
        Event event = firstUnittanding.getEvent();

        assertEquals(event.getId(), id, "check 1st unitStanding id");
        assertEquals(event.getTitle(), title, "check 1st unitStanding title");
        assertEquals(event.getCompetitorType(), competitorType, "check 1st unitStanding competitorType");
        assertEquals(event.getGender(), gender, "check 1st unitStanding gender");
        assertEquals(event.getType(), type, "check 1st unitStanding type");
        assertEquals(event.getOrder(), order, "check 1st unitStanding order");

    }

    @Test
    public void checkUnitStandingsEventDisciplineAttributes(Integer unitStandingsNumber,String id,String title) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for eventStandings
        List<UnitStanding> unitStandings = usdf20.getUnitStandings();
        UnitStanding firstUnittanding = unitStandings.get(unitStandingsNumber);
        Event event = firstUnittanding.getEvent();
        Discipline discipline = event.getDiscipline();

        assertEquals(discipline.getId(), id, "check 1st unitStanding id");
        assertEquals(discipline.getTitle(), title, "check 1st unitStanding title");
    }

    @Test
    public void checkUnitStandingsEventDisciplineCompetitionAttributes(Integer unitStandingsNumber,String id,String title, String country, String place) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the attributes for eventStandings
        List<UnitStanding> unitStandings = usdf20.getUnitStandings();
        UnitStanding firstUnittanding = unitStandings.get(unitStandingsNumber);
        Competition competition = firstUnittanding.getEvent().getDiscipline().getCompetition();

        assertEquals(competition.getId(), id, "check 1st unitStanding event discipline competition id");
        assertEquals(competition.getTitle(), title, "check 1st unitStanding event discipline competition title");
        assertEquals(competition.getCountry(), country, "check 1st unitStanding event discipline competition country");
        assertEquals(competition.getPlace(), place, "check 1st unitStanding event discipline competition place");
    }
}
