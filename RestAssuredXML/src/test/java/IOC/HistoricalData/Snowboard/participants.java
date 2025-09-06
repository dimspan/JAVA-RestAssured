package IOC.HistoricalData.Snowboard;

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
        String xmlUrl = "https://iocweb.enetpulse.com/competitions/5029/generate_export_2_0/participants";

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
        hardcodedValues.checkIndividualProfileParticipantAttributes("SDIS$SBD","Snowboard");
        hardcodedValues.checkIndividualProfileAthleteAttributes("45017","1985-08-19","Lindsey Jacobellis","PGEN$F","Jacobellis",
                "Lindsey",null,null,"CNTR$USA");
//        hardcodedValues.checkIndividualProfileTeamAttributes(0,"1709189_1709191","EVNT$SMTUnknown","Florent Perrier / Patrick Blanc",
//                "PGEN$M","TTYP$CPLP","NOC$FRA");
    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.checkParticipantsSpecialCodes();
        specialPropertiesCodesRegex.checkParticipantsSpecialCodesAthletes();
        specialPropertiesCodesRegex.checkParticipantsSpecialCodesTeams();
    }
}
