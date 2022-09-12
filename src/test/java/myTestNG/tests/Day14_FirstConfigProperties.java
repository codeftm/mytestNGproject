package myTestNG.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import myTestNG.utilities.ConfigReader;
import myTestNG.utilities.Driver;

public class Day14_FirstConfigProperties {

    @Test
    public void firstConfigTest(){
//        Driver.getDriver().get("https://www.techproeducation.com");
//        ConfigReader.getProperty("url_test_techproed") RETURNS https://www.techproeducation.com
        Driver.getDriver().get(ConfigReader.getProperty("url_test_techproed"));
        Driver.closeDriver();
    }
}

