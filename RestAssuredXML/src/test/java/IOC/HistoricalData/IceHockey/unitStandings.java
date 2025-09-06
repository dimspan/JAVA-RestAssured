package IOC.HistoricalData.IceHockey;

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
        String xmlUrl = "https://iocweb.enetpulse.com/competitions/5047/generate_export_2_0/unit_standings?unit_id=4640061";

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
        dataValueTypes.validateDataValueTypesUnitStandingsForTeams();
        dataValueTypes.validateDataValueTypesUnitStandingsForDiscipline();
    }

    @Test(priority = 3)
    public void hardcodedValues() throws JAXBException {
        hardcodedValues.loadXmlFile();
        //check individual event
        hardcodedValues.checkUnitStandingsAttributes(0,"4640061","Austria-Finland","RCST$INTERMEDIATE");
        hardcodedValues.checkUnitStandingsEventAttributes(0,"20263","TEAM","Male","1","EVNT$HOCHockey",
                "SGEN$M");
        hardcodedValues.checkUnitStandingsEventDisciplineAttributes(0,"SDIS$IHO","Ice Hockey");
        hardcodedValues.checkUnitStandingsFirstTeamAttributes(0,"304-20263","1","Austria",
                "CNTR$AUT","1","2","SC_REST$SCORE");
    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.checkUnitStandingsSpecialCodes();
        specialPropertiesCodesRegex.checkUnitStandingsSpecialCodesForDiscipline();
    }
}
