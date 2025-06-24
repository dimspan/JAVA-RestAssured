package IOC.NFiles.DTRecords;

import xmltests.testClasses.NFiles.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;

public class shortTrackSpeedSkating {

    private XML_Format_Validator xmlFormatValidator;
    private ValidateDataValueTypes dataValueTypes;

    @BeforeClass
    public void setUp() throws Exception {
        String xmlUrl = "xxxxxxxxxxxxxxxxxxxx";

        // Initialize instances
        xmlFormatValidator = new XML_Format_Validator(xmlUrl);
        dataValueTypes = new ValidateDataValueTypes(xmlUrl);
    }

//    @Test(priority = 1)
//    public void checkXmlValidation() throws Exception {
//        xmlFormatValidator.fetchXml();
//        xmlFormatValidator.validateXmlFormated();
//    }
//
//    @Test(priority = 2)
//    public void validateDataValueTypes() throws JAXBException {
//        dataValueTypes.loadXmlFile();
//        dataValueTypes.validateDataValueTypesDTRecords();
//    }

}
