package myTestNG.tests;
import myTestNG.utilities.Driver;
import org.testng.annotations.Test;


public class Day14_FirstDriverClass {
    //    driver -> Driver.getDriver()
    @Test
    public void firstDriver(){
//        calling getDriver()
// we dont need to extend class Driver because getDriver is public and static
        Driver.getDriver().get("https://www.techproeducation.com");

//        calling closeDriver()
        Driver.closeDriver();

    }
}
