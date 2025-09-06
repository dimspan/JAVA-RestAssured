package IOC.NFiles.DTRecords;

import org.testng.annotations.BeforeClass;
import xmltests.testClasses.HistoricalData.ValidateDataValueTypes;
import xmltests.testClasses.NFiles.XML_Format_Validator;

public class speedSkating {

    private XML_Format_Validator xmlFormatValidator;
    private ValidateDataValueTypes dataValueTypes;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "http://icodev.ldev.enetpulse.com:8003/n_files/discipline/74/types/22/n_files/xmlPreviewTab";

        // Initialize instances
        xmlFormatValidator = new XML_Format_Validator(xmlUrl);
        dataValueTypes = new ValidateDataValueTypes(xmlUrl);
    }

//    @Test(priority = 1)
//    public void checkXmlValidation() throws Exception {
//        xmlFormatValidator.fetchXmlAndXsd();
//        xmlFormatValidator.validateXmlFormated();
//    }
//
//    @Test(priority = 2)
//    public void validateDataValueTypes() throws JAXBException {
//        dataValueTypes.loadXmlFile();
//        dataValueTypes.validateDataValueTypesDTRecords();
//    }

}
