package IOC.HistoricalData.Biathlon;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.testClasses.HistoricalData.HardcodedValues;
import xmltests.testClasses.HistoricalData.SpecialPropertiesCodesRegex;
import xmltests.testClasses.HistoricalData.ValidateDataValueTypes;
import xmltests.testClasses.HistoricalData.XmlValidatorURL;

import javax.xml.bind.JAXBException;

public class unitStandings {

    private ValidateDataValueTypes dataValueTypes;
    private HardcodedValues hardcodedValues;
    private SpecialPropertiesCodesRegex specialPropertiesCodesRegex;
    private XmlValidatorURL xmlValidator;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "xxxxxxxxxxxxxxxxxxxxxx";

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
        dataValueTypes.validateDataValueTypesUnitStandings();
//        dataValueTypes.validateDataValueTypesEventStandingsForAthletes();
//        dataValueTypes.validateDataValueTypesEventStandingsForTeams();
        dataValueTypes.validateDataValueTypesUnitStandingsForDiscipline();
    }

    @Test(priority = 3)
    public void hardcodedValues() throws JAXBException {
        hardcodedValues.loadXmlFile();
        //check individual event
        hardcodedValues.checkUnitStandingsAttributes(0,"ENETPULSE_UNT_128","Individual Male","RCST$OFFICIAL");
        hardcodedValues.checkUnitStandingsEventAttributes(0,"128","INDIVIDUAL","Individual Male","1",
                "EVNT$BTH10kmIndiv","SGEN$M");
        hardcodedValues.checkUnitStandingsEventDisciplineAttributes(0,"SDIS$BTH","Biathlon");
        hardcodedValues.checkUnitStandingsEventDisciplineCompetitionAttributes(0,"42","2024/2025 World Cup",
                "CNTR$NOR","Oslo");

    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.checkUnitStandingsSpecialCodes();
//        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForTeams();
        specialPropertiesCodesRegex.checkUnitStandingsSpecialCodesForDiscipline();
    }
}
