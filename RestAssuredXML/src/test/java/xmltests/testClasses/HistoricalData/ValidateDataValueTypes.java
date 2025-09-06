package xmltests.testClasses.HistoricalData;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import xmltests.modelClasses.xmlData.*;
//import xmltests.modelClasses.xmlData.Athlete;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertFalse;

public class ValidateDataValueTypes {

    //    private static final String XML_FILE_PATH = "./eventStanding.xml"; // Replace with actual API URL later
//    private static final String XML_URL = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; // Update with actual API URL
    private String xmlUrl;

    private static final String USERNAME = "xxxxxxxxx";
    private static final String PASSWORD = "xxxxxxxxxxxxx";

    private String xmlContent; // Shared response for all tests

    // 🔹 Constructor to set XML URL dynamically
    public ValidateDataValueTypes(String xmlUrl) {
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

    //tests validating data value types
    //event standings
    @Test
    public void validateDataValueTypesEventStandings() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the response is not null
        assertNotNull(usdf20, "Usdf20 object is empty");
        assertNotNull(usdf20.getEventStandings(), "event standing object is empty");
        assertFalse(usdf20.getEventStandings().isEmpty());


        // Loop through all EventStanding elements and validate them
        for (EventStanding eventStanding : usdf20.getEventStandings()) {

            //get event standing competitor type
            String currCompetitorType = eventStanding.getCompetitorType();
            if(currCompetitorType.equals("INDIVIDUAL")){
                // Assert that parsed values match expected types
                assertNotNull(eventStanding.getTitle(), "Event standing title value type");
                assertNotNull(eventStanding.getCompetitorType(), "EVent standing competitorType value type");
                assertNotNull(eventStanding.getGender(), "Event standing gender value type");
                assertNotNull(eventStanding.getId(), "Event standing id value type");
                assertNotNull(eventStanding.getType(), "Event standing type value type");

                // Ensure ID is a valid number
                try {
                    Integer.parseInt(eventStanding.getId());
                } catch (NumberFormatException e) {
                    Assert.fail("Id should be a valid integer, but it was not. Error: " + e.getMessage());
                }
            }
            else{
                // Assert that parsed values match expected types
                assertNotNull(eventStanding.getTitle(), "Event standing title value type");
                assertNotNull(eventStanding.getCompetitorType(), "EVent standing competitorType value type");
                assertNotNull(eventStanding.getGender(), "Event standing gender value type");
                assertNotNull(eventStanding.getId(), "Event standing id value type");
                assertNotNull(eventStanding.getType(), "Event standing type value type");

                // Ensure ID is a valid number
                try {
                    Integer.parseInt(eventStanding.getId());
                } catch (NumberFormatException e) {
                    Assert.fail("Id should be a valid integer, but it was not. Error: " + e.getMessage());
                }
            }
        }
    }

    @Test
    public void validateDataValueTypesEventStandingsForAthletes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // Loop through all EventStanding elements and validate them
        for (EventStanding eventStanding : usdf20.getEventStandings()) {
            //get event standing competitor type
            String currCompetitorType = eventStanding.getCompetitorType();
            if(currCompetitorType.equals("INDIVIDUAL")){
                // Loop through all Athlete elements and validate them
                for (Athlete athlete : eventStanding.getAthletes()) {
                    // Assert that parsed values match expected types
                    assertNotNull(athlete.getOrder(),"Athlete order value type");
                    assertNotNull(athlete.getParticipationName(),"Athlete participation name value type");
                    assertNotNull(athlete.getId(),"Athlete id value type");

                    // Ensure ID is a valid number
                    try {
                        Integer.parseInt(athlete.getId());
                    } catch (NumberFormatException e) {
                        Assert.fail("Id should be a valid integer, but it was not. Error: " + e.getMessage());
                    }

                    // Check athlete Result element and validate value types
                    Result result = athlete.getResult();
                    assertNotNull(result.getOrder(), "athlete result order value type");
                    assertNotNull(result.getRank(), "athlete result rank value type");
                    if (result.getValue() != null) {
                        assertNotNull(result.getValue(), "athlete result value value type");
                    }
                    if (result.getValueType() != null) {
                        assertNotNull(result.getValueType(), "athlete result valueType value type");
                    }

                    // Check if  athlete Medal exists before validating its attributes
                    Medal medal = athlete.getMedal();
                    if (medal != null) {
                        assertNotNull(medal.getDate(), "athlete medal date value type");
                        assertNotNull(medal.getKind(), "athlete medal kind value type");
                    }

                }
            }
        }
    }

    @Test
    public void validateDataValueTypesEventStandingsForTeams() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // Loop through all EventStanding elements and validate them
        for (EventStanding eventStanding : usdf20.getEventStandings()) {
            //get event standing competitor type
            String currCompetitorType = eventStanding.getCompetitorType();
            if(currCompetitorType.equals("TEAM")){
                // Loop through all Team elements and validate them
                for (Team team : eventStanding.getTeams()) {
                    // Assert that parsed values match expected types
                    assertNotNull(team.getOrder(),"Team order value type");
                    assertNotNull(team.getParticipationName(),"Team participation name value type");
                    assertNotNull(team.getId(),"Team id value type");

                    // Ensure ID is a valid number
//                    try {
//                        Integer.parseInt(team.getId());
//                    } catch (NumberFormatException e) {
//                        Assert.fail("Id should be a valid integer, but it was not. Error: " + e.getMessage());
//                    }

                    // Check team NF element and validate value types
                    NF teamNF = team.getNF();
                    assertNotNull(teamNF.getCode(), "team nf code value type");
                    assertNotNull(teamNF.getCountry(), "team nf country value type");

                    // Check team result element and validate value types
                    Result result = team.getResult();
                    assertNotNull(result.getOrder(), "team result order value type");
                    assertNotNull(result.getRank(), "team result rank value type");
                    if (result.getValue() != null) {
                        assertNotNull(result.getValue(), "team result value value type");
                    }
                    if (result.getValueType() != null) {
                        assertNotNull(result.getValueType(), "team result valueType value type");
                    }

                    // Check if team medal exists before validating its attributes
                    Medal medal = team.getMedal();
                    if (medal != null) {
                        assertNotNull(medal.getDate(), "team medal date value type");
                        assertNotNull(medal.getKind(), "team medal kind value type");
                    }

                    for (Athlete athlete : team.getAthletes()) {
                        // Assert that parsed values match expected types
                        assertNotNull(athlete.getOrder(),"Team athlete order value type");
                        assertNotNull(athlete.getParticipationName(),"Team athlete participation name value type");
                        assertNotNull(athlete.getId(),"Team athlete id value type");
                    }
                }
            }
        }
    }

    @Test
    public void validateDataValueTypesEventStandingsForDiscipline() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // Loop through all EventStanding elements and validate them
        for (EventStanding eventStanding : usdf20.getEventStandings()) {
            //get event standing competitor type
            String currCompetitorType = eventStanding.getCompetitorType();
            if(currCompetitorType.equals("INDIVIDUAL")){
                //check value types for discipline and child objects
                Discipline currentDiscipline = eventStanding.getDiscipline();

                assertNotNull(currentDiscipline.getTitle(), "Discipline title value type");
                assertNotNull(currentDiscipline.getId(), "Discipline id value type");

                //competition
                Competition currentCompetition = currentDiscipline.getCompetition();

                assertNotNull(currentCompetition.getTitle(), "Competition title value type");
                assertNotNull(currentCompetition.getPlace(), "Competition place value type");
                assertNotNull(currentCompetition.getCountry(), "Competition country value type");
                assertNotNull(currentCompetition.getId(), "Competition id value type");

            }
            else{
                //check value types for discipline and child objects
                Discipline currentDiscipline = eventStanding.getDiscipline();

                assertNotNull(currentDiscipline.getTitle(), "Discipline title value type");
                assertNotNull(currentDiscipline.getId(), "Discipline id value type");

                //competition
                Competition currentCompetition = currentDiscipline.getCompetition();

                assertNotNull(currentCompetition.getTitle(), "Competition title value type");
                assertNotNull(currentCompetition.getPlace(), "Competition place value type");
                assertNotNull(currentCompetition.getCountry(), "Competition country value type");
                assertNotNull(currentCompetition.getId(), "Competition id value type");

            }
        }
    }

    //participants
    @Test
    public void validateDataValueTypesParticipants() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the response is not null
        assertNotNull(usdf20, "Usdf20 object is empty");
        assertNotNull(usdf20.getParticipant(), "Participant object is empty");

        // Check Participant element and validate value types
        Participant participant = usdf20.getParticipant();
        assertNotNull(participant.getTitle(), "Participant title value type");
        assertNotNull(participant.getId(), "Participant id value type");

    }

    @Test
    public void validateDataValueTypesParticipantsAthletes() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // get participant object
        Participant participant = usdf20.getParticipant();

        // Loop through all Athlete elements and validate them
        for (Athlete athlete : participant.getAthletes()) {
            // Assert that parsed values match expected types
//            assertNotNull(athlete.getDateOfBirth(), "Athlete date of birth value type");
            assertNotNull(athlete.getParticipationName(), "Athlete participationName value type");
            assertNotNull(athlete.getGivenName(), "Athlete given name value type");
            assertNotNull(athlete.getFamilyName(), "Athlete family name value type");
            assertNotNull(athlete.getGender(), "Athlete gender value type");
            assertNotNull(athlete.getId(), "Athlete id value type");

            // Ensure ID is a valid number
            try {
                Integer.parseInt(athlete.getId());
            } catch (NumberFormatException e) {
                Assert.fail("Id should be a valid integer, but it was not. Error: " + e.getMessage());
            }

            // Check if Height is present and validate it
            if (athlete.getHeight() != null) {
                try {
                    Double.parseDouble(athlete.getHeight()); // Assuming height is a decimal value
                } catch (NumberFormatException e) {
                    Assert.fail("Height should be a valid decimal number, but it was not. Error: " + e.getMessage());
                }
            }

            // Check if Weight is present and validate it
            if (athlete.getWeight() != null) {
                try {
                    Double.parseDouble(athlete.getWeight()); // Assuming weight is a decimal value
                } catch (NumberFormatException e) {
                    Assert.fail("Weight should be a valid decimal number, but it was not. Error: " + e.getMessage());
                }
            }
        }
    }

    @Test
    public void validateDataValueTypesParticipantsTeams() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //get participant object
        Participant participant = usdf20.getParticipant();

        // Loop through all team elements and validate them
        for (Team team : participant.getTeams()) {
            // Assert that parsed values match expected types
            assertNotNull(team.getEventType(), "Team event type value type");
            assertNotNull(team.getParticipationName(), "Team participationName value type");
            assertNotNull(team.getType(), "Team type value type");
            assertNotNull(team.getGender(), "Team gender value type");
            assertNotNull(team.getId(), "Team id value type");

        }

    }

    //person profile
    @Test
    public void validateDataValueTypesPersonProfile() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

            //check the response is not null
            assertNotNull(usdf20, "Usdf20 object is empty");
            assertNotNull(usdf20.getPersonProfile(), "personProfile object is empty");

            PersonProfile personProfile = usdf20.getPersonProfile();

            // Assert that parsed values match expected types
            assertNotNull(personProfile.getDateOfBirth(), "personProfile date of birth value type");
            assertNotNull(personProfile.getGender(), "personProfile gender value type");
            assertNotNull(personProfile.getNationality(), "personProfile nationality value type");
            assertNotNull(personProfile.getPreferredGivenName(), "personProfile given name value type");
            assertNotNull(personProfile.getPreferredFamilyName(), "personProfile family name value type");
            assertNotNull(personProfile.getId(), "personProfile id value type");

            // Check if Height is present and validate it
            if (personProfile.getHeight() != null) {
                try {
                    Double.parseDouble(personProfile.getHeight()); // Assuming height is a decimal value
                } catch (NumberFormatException e) {
                    Assert.fail("Height should be a valid decimal number, but it was not. Error: " + e.getMessage());
                }
            }

            // Check if Weight is present and validate it
            if (personProfile.getWeight() != null) {
                try {
                    Double.parseDouble(personProfile.getWeight()); // Assuming weight is a decimal value
                } catch (NumberFormatException e) {
                    Assert.fail("Weight should be a valid decimal number, but it was not. Error: " + e.getMessage());
                }
            }
    }

    //unit standings
    @Test
    public void validateDataValueTypesUnitStandings() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the response is not null
        assertNotNull(usdf20, "Usdf20 object is empty");
        assertNotNull(usdf20.getUnitStandings(), "unit standing object is empty");
        assertFalse(usdf20.getUnitStandings().isEmpty());

        // Loop through all UnitStandings elements and validate them
        for (UnitStanding unitStanding : usdf20.getUnitStandings()) {
            //get unit standing competitor type
            Event currEvent = unitStanding.getEvent();
            String currCompetitorType = currEvent.getCompetitorType();

            if(currCompetitorType.equals("INDIVIDUAL")){
                // Assert that parsed values match expected types
                assertNotNull(unitStanding.getTitle(), "Unit standing title value type");
                assertNotNull(unitStanding.getStatus(), "Unit standing status value type");
                assertNotNull(unitStanding.getId(), "Unit standing id value type");

                //Assert that parsed values of event object match expected types
                assertNotNull(currEvent.getTitle(), "Current event title value type");
                assertNotNull(currEvent.getCompetitorType(), "Current event competitorType value type");
                assertNotNull(currEvent.getId(), "Current event id value type");
                assertNotNull(currEvent.getType(), "Current event type value type");
                assertNotNull(currEvent.getGender(), "Current event gender value type");
                assertNotNull(currEvent.getOrder(), "Current event order value type");

            }
            else{
                // Assert that parsed values match expected types
                assertNotNull(unitStanding.getTitle(), "Unit standing title value type");
                assertNotNull(unitStanding.getStatus(), "Unit standing status value type");
                assertNotNull(unitStanding.getId(), "Unit standing id value type");

                //Assert that parsed values of event object match expected types
                assertNotNull(currEvent.getTitle(), "Current event title value type");
                assertNotNull(currEvent.getCompetitorType(), "Current event competitorType value type");
                assertNotNull(currEvent.getId(), "Current event id value type");
                assertNotNull(currEvent.getType(), "Current event type value type");
                assertNotNull(currEvent.getGender(), "Current event gender value type");
                assertNotNull(currEvent.getOrder(), "Current event order value type");
            }
        }
    }

    @Test
    public void validateDataValueTypesUnitStandingsForDiscipline() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // Loop through all EventStanding elements and validate them
        for (UnitStanding unitStanding : usdf20.getUnitStandings()) {
            //get event standing competitor type
            String currCompetitorType = unitStanding.getEvent().getCompetitorType();
            if(currCompetitorType.equals("INDIVIDUAL")){
                //check value types for discipline and child objects
                Discipline currentDiscipline = unitStanding.getEvent().getDiscipline();

                assertNotNull(currentDiscipline.getTitle(), "Discipline title value type");
                assertNotNull(currentDiscipline.getId(), "Discipline id value type");

                //competition
                Competition currentCompetition = currentDiscipline.getCompetition();

                assertNotNull(currentCompetition.getTitle(), "Competition title value type");
                assertNotNull(currentCompetition.getPlace(), "Competition place value type");
                assertNotNull(currentCompetition.getCountry(), "Competition country value type");
                assertNotNull(currentCompetition.getId(), "Competition id value type");

            }
            else{
                //check value types for discipline and child objects
                Discipline currentDiscipline = unitStanding.getEvent().getDiscipline();

                assertNotNull(currentDiscipline.getTitle(), "Discipline title value type");
                assertNotNull(currentDiscipline.getId(), "Discipline id value type");

                //competition
                Competition currentCompetition = currentDiscipline.getCompetition();

                assertNotNull(currentCompetition.getTitle(), "Competition title value type");
                assertNotNull(currentCompetition.getPlace(), "Competition place value type");
                assertNotNull(currentCompetition.getCountry(), "Competition country value type");
                assertNotNull(currentCompetition.getId(), "Competition id value type");

            }
        }
    }

    @Test
    public void validateDataValueTypesUnitStandingsForTeams() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // Loop through all unitStanding elements and validate them
        for (UnitStanding unitStanding : usdf20.getUnitStandings()) {

            // Loop through all Team elements and validate them
            for (Team team : unitStanding.getTeams()) {
                // Assert that parsed values match expected types
                assertNotNull(team.getOrder(),"Team order value type");
                assertNotNull(team.getParticipationName(),"Team participation name value type");
                assertNotNull(team.getId(),"Team id value type");

                // Check team NF element and validate value types
                NF teamNF = team.getNF();
//                assertNotNull(teamNF.getCode(), "team nf code value type");
                assertNotNull(teamNF.getCountry(), "team nf country value type");

                // Check team result element and validate value types
                Result result = team.getResult();
                assertNotNull(result.getOrder(), "team result order value type");
                if (result.getRank() != null) {
                    assertNotNull(result.getRank(), "team result rank value type");
                }
                if (result.getValue() != null) {
                    assertNotNull(result.getValue(), "team result value value type");
                }
                if (result.getValueType() != null) {
                    assertNotNull(result.getValueType(), "team result valueType value type");
                }

                // Check if team medal exists before validating its attributes
                Medal medal = team.getMedal();
                if (medal != null) {
                    assertNotNull(medal.getDate(), "team medal date value type");
                    assertNotNull(medal.getKind(), "team medal kind value type");
                }
            }
        }
    }

    //event breakdown
    @Test
    public void validateDataValueTypesEventBreakdown() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the response is not null
        assertNotNull(usdf20, "Usdf20 object is empty");
        assertNotNull(usdf20.getEventBreakdown(), "event breakdown object is empty");

        EventBreakdown eventBreakdown = usdf20.getEventBreakdown();

        // Assert that parsed values match expected types
        assertNotNull(eventBreakdown.getTitle(), "Event breakdown title value type");
        assertNotNull(eventBreakdown.getType(), "Event breakdown type value type");
        assertNotNull(eventBreakdown.getId(), "Event breakdown id value type");
        assertNotNull(eventBreakdown.getCompetitorType(), "Event breakdown competitorType value type");
        assertNotNull(eventBreakdown.getGender(), "Event breakdown gender value type");
        assertNotNull(eventBreakdown.getOrder(), "Event breakdown order value type");

        for (PoolsStage poolsStage : eventBreakdown.getPoolsStages()) {
            //Assert that parsed values of poolsStage object match expected types
            assertNotNull(poolsStage.getTitle(), "Current poolsStage title value type");
            assertNotNull(poolsStage.getRoundType(), "Current poolsStage roundType value type");
            assertNotNull(poolsStage.getId(), "Current poolsStage id value type");
            assertNotNull(poolsStage.getOrder(), "Current poolsStage order value type");

            Pool pool = poolsStage.getPool();
            //Assert that parsed values of pool object match expected types
            assertNotNull(pool.getTitle(), "Current pool title value type");
            assertNotNull(pool.getGroup(), "Current pool group value type");
            assertNotNull(pool.getId(), "Current pool id value type");
            assertNotNull(pool.getOrder(), "Current pool order value type");

            //Assert that parsed values of unit object match expected types
            for (Unit unit : pool.getUnits()) {
                assertNotNull(unit.getTitle(), "Current unit title value type");
                assertNotNull(unit.getType(), "Current unit type value type");
                assertNotNull(unit.getId(), "Current unit id value type");
                assertNotNull(unit.getOrder(), "Current unit order value type");
            }
        }

    }

    @Test
    public void validateDataValueTypesEventBreakdownForDiscipline() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        EventBreakdown eventBreakdown = usdf20.getEventBreakdown();
        //check value types for discipline and child objects
        Discipline currentDiscipline = eventBreakdown.getDiscipline();
        assertNotNull(currentDiscipline.getTitle(), "Discipline title value type");
        assertNotNull(currentDiscipline.getId(), "Discipline id value type");

        //competition
        Competition currentCompetition = currentDiscipline.getCompetition();

        assertNotNull(currentCompetition.getTitle(), "Competition title value type");
        assertNotNull(currentCompetition.getPlace(), "Competition place value type");
        assertNotNull(currentCompetition.getCountry(), "Competition country value type");
        assertNotNull(currentCompetition.getId(), "Competition id value type");

    }


    //pool standings
    @Test
    public void validateDataValueTypesPoolStandings() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        //check the response is not null
        assertNotNull(usdf20, "Usdf20 object is empty");
        assertNotNull(usdf20.getPoolStandings(), "pool standing object is empty");
        assertFalse(usdf20.getPoolStandings().isEmpty());

        // Loop through all PoolStandings elements and validate them
        for (PoolStanding poolStanding : usdf20.getPoolStandings()) {

            // Assert that parsed values match expected types
            assertNotNull(poolStanding.getTitle(), "Pool standing title value type");
            assertNotNull(poolStanding.getStatus(), "Pool standing status value type");
            assertNotNull(poolStanding.getId(), "Pool standing id value type");

            //get the current event
            Event currEvent = poolStanding.getEvent();

            //Assert that parsed values of event object match expected types
            assertNotNull(currEvent.getTitle(), "Current event title value type");
            assertNotNull(currEvent.getCompetitorType(), "Current event competitorType value type");
            assertNotNull(currEvent.getId(), "Current event id value type");
            assertNotNull(currEvent.getType(), "Current event type value type");
            assertNotNull(currEvent.getGender(), "Current event gender value type");
            assertNotNull(currEvent.getOrder(), "Current event order value type");

        }
    }

    @Test
    public void validateDataValueTypesPoolStandingsForDiscipline() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        // Loop through all PoolStandings elements and validate them
        for (PoolStanding pooolStanding : usdf20.getPoolStandings()) {

            //check value types for discipline and child objects
            Discipline currentDiscipline = pooolStanding.getEvent().getDiscipline();
            assertNotNull(currentDiscipline.getTitle(), "Discipline title value type");
            assertNotNull(currentDiscipline.getId(), "Discipline id value type");

            //competition
            Competition currentCompetition = currentDiscipline.getCompetition();

            assertNotNull(currentCompetition.getTitle(), "Competition title value type");
            assertNotNull(currentCompetition.getPlace(), "Competition place value type");
            assertNotNull(currentCompetition.getCountry(), "Competition country value type");
            assertNotNull(currentCompetition.getId(), "Competition id value type");

            }
        }

    //competition profile
    @Test
    public void validateDataValueTypesCompetitionProfile() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usdf20.class, EventStanding.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usdf20 usdf20 = (Usdf20) unmarshaller.unmarshal(new StringReader(xmlContent));

        CompetitionProfile competitionProfile = usdf20.getCompetitionProfile();
        //check value types for competitionProfile and child objects
        assertNotNull(competitionProfile.getTitle(), "competitionProfile title value type");
        assertNotNull(competitionProfile.getPlace(), "competitionProfile place value type");
        assertNotNull(competitionProfile.getCountry(), "competitionProfile country value type");
        assertNotNull(competitionProfile.getId(), "competitionProfile id value type");
//        assertNotNull(competitionProfile.getRegion(), "competitionProfile region value type");

        //check value types for schedule object
        Schedule schedule = competitionProfile.getSchedule();
        assertNotNull(schedule.getStartDate(), "schedule startDate value type");
        assertNotNull(schedule.getFinishDate(), "schedule finishDate value type");

    }
}

