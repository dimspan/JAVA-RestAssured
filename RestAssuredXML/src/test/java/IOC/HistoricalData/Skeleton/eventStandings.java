package IOC.HistoricalData.Skeleton;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.testClasses.HistoricalData.XmlValidatorURL;
import xmltests.testClasses.HistoricalData.ValidateDataValueTypes;
import xmltests.testClasses.HistoricalData.SpecialPropertiesCodesRegex;
import xmltests.testClasses.HistoricalData.HardcodedValues;

import javax.xml.bind.JAXBException;

public class eventStandings {

    private ValidateDataValueTypes dataValueTypes;
    private HardcodedValues hardcodedValues;
    private SpecialPropertiesCodesRegex specialPropertiesCodesRegex;
    private XmlValidatorURL xmlValidator;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "https://iocweb.enetpulse.com/competitions/5024/generate_export_2_0/event_standings?event_id=20050";

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
        hardcodedValues.checkEventStandingsAttributes(0,"20050","INDIVIDUAL","SGEN$W","Girls Skeleton","EVNT$SKNSingles",
                "RCST$OFFICIAL");
        hardcodedValues.checkEventStandingsFirstAthleteAttributes(0,"920324","1","Jacqueline Loelling","1",
                "1","57.430","SC_REST$TIME","2025-02-19","AWSB$ME_GOLD");
        hardcodedValues.checkEventStandingDisciplineAndChildAttributes("SDIS$SKN","Skeleton","CNTR$AUT","Innsbruck",
                "5024","Winter Youth Olympics");
    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodes();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForAthletes();
        specialPropertiesCodesRegex.checkEventStandingsSpecialCodesForDiscipline();
    }
}
