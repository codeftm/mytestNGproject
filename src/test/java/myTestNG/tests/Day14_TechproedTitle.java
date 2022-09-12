package myTestNG.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import myTestNG.utilities.ConfigReader;
import myTestNG.utilities.Driver;

public class Day14_TechproedTitle {

    @Test
    public void titleTest(){
        Driver.getDriver().get(ConfigReader.getProperty("url_test_techproed"));
        String actualTitle = Driver.getDriver().getTitle();
        boolean isTrue = actualTitle.contains(ConfigReader.getProperty("page_title"));
        Assert.assertTrue(isTrue);
        Driver.closeDriver();
    }
}
