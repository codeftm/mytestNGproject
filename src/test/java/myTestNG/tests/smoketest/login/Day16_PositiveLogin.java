package myTestNG.tests.smoketest.login;


import org.testng.annotations.Test;
import myTestNG.pages.HomePage;
import myTestNG.pages.LoginPage;
import myTestNG.utilities.ConfigReader;
import myTestNG.utilities.Driver;
import myTestNG.utilities.ReusableMethods;

public class Day16_PositiveLogin {
    /*
    * •Name:
	•US100208_Customer_Login
	•Description:
	•User should be able login as customer
	•Acceptance Criteria:
	•As customer, I should be able to log in the application
	•https://www.bluerentalcars.com/login
	•Customer email: customer@bluerentalcars.com
	•Customer password: 12345
    * */
    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void customerLogin(){
//      going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//      click on login button
        homePage = new HomePage();
        loginPage=new LoginPage();
//      clicking home login button
        homePage.homeLoginButton.click();
//      type email password and click login button
        loginPage.username.sendKeys(ConfigReader.getProperty("app_customer_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("app_customer_password"));
        loginPage.loginButton.click();

//      Verify if login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);

    }
}



