package IOC.HistoricalData.Curling;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.testClasses.HistoricalData.HardcodedValues;
import xmltests.testClasses.HistoricalData.SpecialPropertiesCodesRegex;
import xmltests.testClasses.HistoricalData.ValidateDataValueTypes;
import xmltests.testClasses.HistoricalData.XmlValidatorURL;

import javax.xml.bind.JAXBException;

public class eventBreakdown {

    private ValidateDataValueTypes dataValueTypes;
    private HardcodedValues hardcodedValues;
    private SpecialPropertiesCodesRegex specialPropertiesCodesRegex;
    private XmlValidatorURL xmlValidator;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "https://iocweb.enetpulse.com/competitions/5053/generate_export_2_0/event_breakdown";

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
        dataValueTypes.validateDataValueTypesEventBreakdown();
        dataValueTypes.validateDataValueTypesEventBreakdownForDiscipline();
    }

    @Test(priority = 3)
    public void hardcodedValues() throws JAXBException {
        hardcodedValues.loadXmlFile();
        hardcodedValues.checkeventBreakdownAttributes("20270","World Men's Curling Championship","TEAM","SGEN$M",
                "EVNT$CURTeam", "1");
        hardcodedValues.checkeventBreakdownPoolsStageAttributes(0,"20270_pr","Pool","1", "RTYP$R1","897774_20270",
                "1","LGT World Womens Curling Championship","POOL$GPA");
        hardcodedValues.checkeventBreakdownEventDisciplineAttributes("SDIS$CUR","Curling");
        hardcodedValues.checkeventBreakdownEventDisciplineCompetitionAttributes("5053","2025 World Championships","CNTR$CAN","Moose Jaw");
    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.eventBreakdownSpecialCodes();
        specialPropertiesCodesRegex.eventBreakdownSpecialCodesForDiscipline();
    }
}
