package myTestNG.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_DependsOnMethods {

    @Test
    public void homePage(){
        System.out.println("Home Page");
    }

    @Test
    public void logInPage(){
        System.out.println("Login Page");
        Assert.assertTrue(false);//FAILS THEN checkOutPage WILL NOT RUN
    }

    /*
    dependsOnMethods connects checkOutPage to logInPage
    if checkoutPage method executes, then logInPage runs first
    if logInPage PASS then checkoutPage will execute
    if logInPage FAILS then checkoutPage will NOT execute
     */
    @Test(dependsOnMethods = "logInPage")
    public void checkOutPage(){
        System.out.println("Check Out Page");
    }

}

