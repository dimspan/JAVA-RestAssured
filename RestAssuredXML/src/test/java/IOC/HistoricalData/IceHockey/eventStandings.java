package IOC.HistoricalData.IceHockey;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.testClasses.HistoricalData.HardcodedValues;
import xmltests.testClasses.HistoricalData.SpecialPropertiesCodesRegex;
import xmltests.testClasses.HistoricalData.ValidateDataValueTypes;
import xmltests.testClasses.HistoricalData.XmlValidatorURL;

import javax.xml.bind.JAXBException;


public class eventStandings {

    private ValidateDataValueTypes dataValueTypes;
    private HardcodedValues hardcodedValues;
    private SpecialPropertiesCodesRegex specialPropertiesCodesRegex;
    private XmlValidatorURL xmlValidator;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "https://iocweb.enetpulse.com/competitions/5047/generate_export_2_0/event_standings?event_id=20263";

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

    @Test(priority = 2)
    public void validateDataValueTypes() throws JAXBException {
        dataValueTypes.loadXmlFile();
        dataValueTypes.validateDataValueTypesEventStandings();
        dataValueTypes.validateDataValueTypesEventStandingsForAthletes();
        dataValueTypes.validateDataValueTypesEventStandingsForDiscipline();
    }

    @Test(priority = 3)
    public void hardcodedValues() throws JAXBException {
        hardcodedValues.loadXmlFile();
        hardcodedValues.checkEventStandingsAttributes(0,"20263","TEAM","SGEN$M","Male",
                "EVNT$HOCHockey", "RCST$INTERMEDIATE");
        hardcodedValues.checkEventStandingsFirstTeamAttributes(0,"296-20263","1","USA",
                null,"CNTR$USA","1","1",null,null,"2025-05-29","AWSB$ME_GOLD",
                "913863", "1","Jeremy Swayman","1504332","2","Hampton Slukynsky");
        hardcodedValues.checkEventStandingDisciplineAndChildAttributes("SDIS$IHO","Ice Hockey","CNTR$SWE","Stockholm",
                "5047","2025 World Championships");
    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodes();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForAthletes();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForDiscipline();
    }
}
