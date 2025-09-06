package IOC.HistoricalData.Curling;

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
        String xmlUrl = "https://iocweb.enetpulse.com/competitions/5053/generate_export_2_0/event_standings?event_id=20270";

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
        hardcodedValues.checkEventStandingsAttributes(0,"20270","TEAM","SGEN$M","World Men's Curling Championship",
                "EVNT$CURTeam", "RCST$OFFICIAL");
        hardcodedValues.checkEventStandingsFirstTeamAttributes(0,"1713672-20270","1","Scotland",
                null,"CNTR$MIX","1","1",null,null,"2025-04-14","AWSB$ME_GOLD",
                "1331187", "1","Bruce Mouat","1331188","2","Grant Hardie");
        hardcodedValues.checkEventStandingDisciplineAndChildAttributes("SDIS$CUR","Curling","CNTR$CAN","Moose Jaw",
                "5053","2025 World Championships");
    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodes();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForAthletes();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForDiscipline();
    }
}
