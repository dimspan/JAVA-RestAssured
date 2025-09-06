package IOC.HistoricalData.FreestyleSkiing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.testClasses.HistoricalData.HardcodedValues;
import xmltests.testClasses.HistoricalData.SpecialPropertiesCodesRegex;
import xmltests.testClasses.HistoricalData.ValidateDataValueTypes;
import xmltests.testClasses.HistoricalData.XmlValidatorURL;

import javax.xml.bind.JAXBException;

public class participants {

    private ValidateDataValueTypes dataValueTypes;
    private HardcodedValues hardcodedValues;
    private SpecialPropertiesCodesRegex specialPropertiesCodesRegex;
    private XmlValidatorURL xmlValidator;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "http://icodev.ldev.enetpulse.com:8003/competitions/33/generate_export_2_0/participants";

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
        dataValueTypes.validateDataValueTypesParticipants();
        dataValueTypes.validateDataValueTypesParticipantsAthletes();
        dataValueTypes.validateDataValueTypesParticipantsTeams();
    }

    @Test(priority = 3)
    public void hardcodedValues() throws JAXBException {
        hardcodedValues.loadXmlFile();
        hardcodedValues.checkIndividualProfileParticipantAttributes("SDIS$FRS","Freestyle Skiing");
        hardcodedValues.checkIndividualProfileAthleteAttributes("194752","1993-09-14","Ashley Caldwell","PGEN$F","Caldwell",
                "Ashley",null,null,"CNTR$USA");
        hardcodedValues.checkIndividualProfileTeamAttributes(0,"613990-43","EVNT$FRSAerials","China",
                "PGEN$X","TTYP$NATM");
    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.checkParticipantsSpecialCodes();
        specialPropertiesCodesRegex.checkParticipantsSpecialCodesAthletes();
        specialPropertiesCodesRegex.checkParticipantsSpecialCodesTeams();
    }
}
