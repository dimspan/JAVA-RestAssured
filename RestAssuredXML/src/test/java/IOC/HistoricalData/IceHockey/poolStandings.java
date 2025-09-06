package IOC.HistoricalData.IceHockey;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xmltests.testClasses.HistoricalData.HardcodedValues;
import xmltests.testClasses.HistoricalData.SpecialPropertiesCodesRegex;
import xmltests.testClasses.HistoricalData.ValidateDataValueTypes;
import xmltests.testClasses.HistoricalData.XmlValidatorURL;

import javax.xml.bind.JAXBException;

public class poolStandings {

    private ValidateDataValueTypes dataValueTypes;
    private HardcodedValues hardcodedValues;
    private SpecialPropertiesCodesRegex specialPropertiesCodesRegex;
    private XmlValidatorURL xmlValidator;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "https://iocweb.enetpulse.com/competitions/5045/generate_export_2_0/pool_standings";

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
        dataValueTypes.validateDataValueTypesPoolStandings();
        dataValueTypes.validateDataValueTypesPoolStandingsForDiscipline();
    }

    @Test(priority = 3)
    public void hardcodedValues() throws JAXBException {
        hardcodedValues.loadXmlFile();
        hardcodedValues.checkPoolStandingsAttributes(0,"20269_pr","Pool","RCST$OFFICIAL");
        hardcodedValues.checkPoolStandingsEventAttributes(0,"20269","TEAM","Male",
                "1","EVNT$IHO6aside","SGEN$M");
        hardcodedValues.checkPoolStandingsEventDisciplineAttributes(0,"SDIS$IHO","Ice Hockey");
        hardcodedValues.checkPoolStandingsEventDisciplineCompetitionAttributes(0,"5045","1991 World Championships",
                "CNTR$FIN","Helsinki");
    }

    @Test(priority = 4)
    public void specialCodesRegex() throws JAXBException {
        specialPropertiesCodesRegex.loadXmlFile();
        specialPropertiesCodesRegex.checkPoolStandingsSpecialCodes();
        specialPropertiesCodesRegex.checkPoolStandingsSpecialCodesForDiscipline();
    }
}
