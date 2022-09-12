package myTestNG.tests;



import org.testng.annotations.Test;
import myTestNG.pages.AddressLoginPage;
import myTestNG.utilities.ConfigReader;
import myTestNG.utilities.Driver;
public class Day15_AddressLogin {
    AddressLoginPage addressLoginPage=new AddressLoginPage();
    @Test
    public void loginTest(){
//        going to the page
        Driver.getDriver().get(ConfigReader.getProperty("address_url"));
//        sending username
        addressLoginPage.username.sendKeys(ConfigReader.getProperty("address_username"));
//        sending password
        addressLoginPage.password.sendKeys(ConfigReader.getProperty("address_password"));
//        clicking on login button
        addressLoginPage.logInButton.click();
    }
}