package myTestNG.tests.dataprovider;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import myTestNG.pages.HomePage;
import myTestNG.pages.LoginPage;
import myTestNG.utilities.ConfigReader;
import myTestNG.utilities.Driver;
import myTestNG.utilities.ExcelUtil;
import myTestNG.utilities.ReusableMethods;
import java.io.IOException;
public class Day17_DataProvider3 {
    ExcelUtil excelUtil;
    //    DATA PROVIDER METHOD
//    Copied this methods from teh first class
    @DataProvider
    public Object[][] customerData(){
//        path of customer sheet
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
//        customer sheet name
        String customerSheet ="customer_info";
//        Use Excel Util
        excelUtil = new ExcelUtil(path,customerSheet);
//        getting the data from the excel using excel util method
        Object[][] customerCredentials=excelUtil.getDataArrayWithoutFirstRow();
        return customerCredentials;
    }
    //    Data Provider is similar to getting data form excel
//    We will login similar to excel login using data provider
    HomePage homePage;
    LoginPage loginPage;
    public void login(){
//        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        initializing the pages
        homePage = new HomePage();
        loginPage=new LoginPage();
//        GOING TO THE LOGIN PAGE FIRST TIME
        try{
            // if there is any exception, then keep going.
            // will be used only at the 1st login since homeLoginButton is available
            homePage.homeLoginButton.click();
        }catch (Exception e){
        }
//        GOING TO THE LOGIN PAGE AFTER FIRST TIME
        try{
            // if there is any exception, then keep going.
            // will be used AFTER the 1st login since userID is available AFTER the 1st login
//            Logging Out
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homeLoginButton.click();
        }catch (Exception e){
        }
    }
    //    TEST METHOD
    @Test(dataProvider = "customerData")
    public void dataProviderTest(String userName, String passWord) throws IOException {
        login();
        System.out.println(userName);
        System.out.println(passWord);
        ReusableMethods.waitFor(1);
        loginPage.username.sendKeys(userName);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(passWord.substring(0,5));
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
        //            Asserting making sure login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);
        ReusableMethods.getScreenshot(userName);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}