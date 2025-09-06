package IOC.HistoricalData.FreestyleSkiing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import xmltests.testClasses.HistoricalData.HardcodedValues;
import xmltests.testClasses.HistoricalData.SpecialPropertiesCodesRegex;
import xmltests.testClasses.HistoricalData.ValidateDataValueTypes;
import xmltests.testClasses.HistoricalData.XmlValidatorURL;


public class eventStandings {

    private ValidateDataValueTypes dataValueTypes;
    private HardcodedValues hardcodedValues;
    private SpecialPropertiesCodesRegex specialPropertiesCodesRegex;
    private XmlValidatorURL xmlValidator;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "http://icodev.ldev.enetpulse.com:8003/competitions/33/generate_export_2_0/event_standings?event_id=42";

        // Initialize instances
        dataValueTypes = new ValidateDataValueTypes(xmlUrl);
        hardcodedValues = new HardcodedValues(xmlUrl);
        specialPropertiesCodesRegex = new SpecialPropertiesCodesRegex(xmlUrl);
        xmlValidator = new XmlValidatorURL(xmlUrl);

    }


    @Test(priority = 1)
    public void checkXmlValidation() throws Exception {
        xmlValidator.loadXmlFileXsdSchema();
        xmlValidator.validateXsdSchema();
    }

//    @Test(priority = 2)
//    public void validateDataValueTypes() throws JAXBException {
//        dataValueTypes.loadXmlFile();
//        dataValueTypes.validateDataValueTypesEventStandings();
//        dataValueTypes.validateDataValueTypesEventStandingsForAthletes();
//        dataValueTypes.validateDataValueTypesEventStandingsForDiscipline();
//    }
//
//    @Test(priority = 3)
//    public void hardcodedValues() throws JAXBException {
//        hardcodedValues.loadXmlFile();
//        hardcodedValues.checkEventStandingsAttributes(0,"20055","TEAM","SGEN$M","2-man Bobsleigh",
//                "EVNT$BOB2-manBobsleigh", "RCST$OFFICIAL");
//        hardcodedValues.checkEventStandingsFirstTeamAttributes(0,"886132_1705911","1","Thorsten Margis / Friedrich Waller",
//                "CNTR$MIX","CNTR$MIX","1","1",null,null,"2025-01-19","AWSB$ME_GOLD",
//                "886132", "1","Thorsten Margis","1705911","2","Friedrich Waller");
//        hardcodedValues.checkEventStandingDisciplineAndChildAttributes("SDIS$BOB","Bobsleigh","CNTR$CAN","Whistler, BC",
//                "5027","2019 World Championships");
//    }
//
//    @Test(priority = 4)
//    public void specialCodesRegex() throws JAXBException {
//        specialPropertiesCodesRegex.loadXmlFile();
//        specialPropertiesCodesRegex.checkEventStandingsSpecialCodes();
//        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForAthletes();
//        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForDiscipline();
//    }
}
