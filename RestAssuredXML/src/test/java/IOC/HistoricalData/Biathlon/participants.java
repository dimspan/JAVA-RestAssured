package IOC.HistoricalData.Biathlon;

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
        String xmlUrl = "http://icodev.ldev.enetpulse.com:8003/competitions/42/generate_export_2_0/participants";

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
        hardcodedValues.checkIndividualProfileParticipantAttributes("SDIS$BTH","Biathlon");
        hardcodedValues.checkIndividualProfileAthleteAttributes("50842","1983-02-23","Simon Eder","PGEN$M","Eder",
                "Simon","185","79","CNTR$AUT");
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
