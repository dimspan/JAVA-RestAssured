package IOC.HistoricalData.Biathlon;

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
        String xmlUrl = "http://icodev.ldev.enetpulse.com:8003/competitions/42/generate_export_2_0/event_standings?event_id=128";

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
        hardcodedValues.checkEventStandingsAttributes(0,"128","INDIVIDUAL","SGEN$M","Individual Male",
                "EVNT$BTH10kmIndiv", "RCST$OFFICIAL");
        hardcodedValues.checkEventStandingsFirstAthleteAttributes(0,"530221","1","Sturla Holm Laegreid",
                "1","1","165","SC_REST$SCORE",null,null);
        hardcodedValues.checkEventStandingDisciplineAndChildAttributes("SDIS$BTH","Biathlon","CNTR$NOR","Oslo",
                "42","2024/2025 World Cup");
    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodes();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForAthletes();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForDiscipline();
    }
}
