package myTestNG.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import myTestNG.utilities.Driver;


public class AddressLoginPage {

    public AddressLoginPage(){
//        PageFactory is used to initialize the page objects
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //    Locating username
    @FindBy(id = "session_email")
    public WebElement username;
    //    Locating the password
    @FindBy(id="session_password")
    public WebElement password;
    //    Locating the login button
    @FindBy(name = "commit")
    public WebElement logInButton;


}
