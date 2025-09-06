package IOC.HistoricalData.FreestyleSkiing;

import org.testng.annotations.BeforeClass;
import xmltests.testClasses.HistoricalData.HardcodedValues;
import xmltests.testClasses.HistoricalData.SpecialPropertiesCodesRegex;
import xmltests.testClasses.HistoricalData.ValidateDataValueTypes;
import xmltests.testClasses.HistoricalData.XmlValidatorURL;

public class unitStandings {

    private ValidateDataValueTypes dataValueTypes;
    private HardcodedValues hardcodedValues;
    private SpecialPropertiesCodesRegex specialPropertiesCodesRegex;
    private XmlValidatorURL xmlValidator;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "http://icodev.ldev.enetpulse.com:8003/competitions/27/generate_export_2_0/unit_standings?event_id=33";

        // Initialize instances
        dataValueTypes = new ValidateDataValueTypes(xmlUrl);
        hardcodedValues = new HardcodedValues(xmlUrl);
        specialPropertiesCodesRegex = new SpecialPropertiesCodesRegex(xmlUrl);
        xmlValidator = new XmlValidatorURL(xmlUrl);

    }

//    @Test(priority = 1)
//    public void checkXmlValidation() throws Exception {
//        xmlValidator.loadXmlFileXsdSchema();
//        xmlValidator.validateXsdSchema();
//    }
//
//    @Test(priority = 2)
//    public void validateDataValueTypes() throws JAXBException {
//        dataValueTypes.loadXmlFile();
//        dataValueTypes.validateDataValueTypesUnitStandings();
//
//    }

    //NOT READY!!
//    @Test(priority = 3)
//    public void hardcodedValues() throws JAXBException {
//        hardcodedValues.loadXmlFile();
//        //check individual event
//        hardcodedValues.checkEventStandingsAttributes(0,"20053","INDIVIDUAL","SGEN$M","Individual Male",
//                "EVNT$SMTIndiv","RCST$OFFICIAL");
//        hardcodedValues.checkEventStandingsFirstAthleteAttributes(0,"1709740","1","Rico Elmer","NOC$SUI","1",
//                "1",null,null,"2025-01-25","AWSB$ME_GOLD");
//        //check team event
////        hardcodedValues.checkEventStandingsAttributes(0,"20054","TEAM","SGEN$M","Team Male","EVNT$SMTUnknown",
////                "RCST$OFFICIAL");
////        hardcodedValues.checkEventStandingsFirstTeamAttributes(1,"1709189_1709191","1","Florent Perrier / Patrick Blanc","CNTR$FRA",
////                "CNTR$FRA","1","1",null,null,"2025-01-25","AWSB$ME_GOLD","1709189",
////                "1","Florent Perrier","1709191","2","Patrick Blanc");
//    }
//
//    @Test(priority = 4)
//    public void specialCodesRegex() throws JAXBException {
//        specialPropertiesCodesRegex.loadXmlFile();
//        specialPropertiesCodesRegex.checkUnitStandingsSpecialCodes();
//    }
}
