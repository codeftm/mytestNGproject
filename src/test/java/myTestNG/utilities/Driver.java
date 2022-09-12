package myTestNG.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class Driver {
    private static WebDriver driver;
    private Driver(){
    }

    //    create a method to instantiate the driver object
    public static WebDriver getDriver(){
        if (driver==null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    //    create a method to close the driver
//    if driver is pointing anywhere or is in use(driver!=null)
//    then close the driver and set driver=null
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
