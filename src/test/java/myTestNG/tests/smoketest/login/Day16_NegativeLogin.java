package myTestNG.tests.smoketest.login;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import myTestNG.pages.HomePage;
import myTestNG.pages.LoginPage;
import myTestNG.utilities.ConfigReader;
import myTestNG.utilities.Driver;
import myTestNG.utilities.ReusableMethods;

import java.io.IOException;

public class Day16_NegativeLogin {

    /*
* Name:
Login screen error messages
Description:
User should see error message when user tries to login with incorrect credentials
Acceptance Criteria:
As admin or customer, I should be able to see error message, when I do not provide a correct email address or password in a pop up window
Error Message: invalid credentials
* */


    HomePage homePage;
    LoginPage loginPage;
    Faker faker;

    @Test
    public void loginScreenErrorMessages() throws IOException {
        //        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //        click on login button
        homePage = new HomePage();
        loginPage = new LoginPage();
        faker = new Faker();
//        clicking home login button
        homePage.homeLoginButton.click();
//        type email, password, and click login button
        loginPage.username.sendKeys(faker.internet().emailAddress());
        loginPage.password.sendKeys(faker.internet().password());
        loginPage.loginButton.click();
        /*
        loginPage.invalidCredentialsError element pops up and it takes time to be visible(less than a sec)
        and implicit wait can not handle the wait
        so we should use explicit wait. below we are wait for the element to be visible up to 5 second
        Then doing the assertion
         */
        ReusableMethods.waitForVisibility(loginPage.invalidCredentialsError, 5);
        ReusableMethods.verifyElementDisplayed(loginPage.invalidCredentialsError);
        Assert.assertTrue(loginPage.invalidCredentialsError.getText().equals("invalid credentials"));


        ReusableMethods.getScreenshot("Error Message");
        Driver.closeDriver();


    }

}