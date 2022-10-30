package Utils;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestBase {
    protected SoftAssert softAssert;
    public WebDriver driver;
   @BeforeMethod(alwaysRun = true)
    public  void setup(){
    FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
    driver=new FirefoxDriver();
    softAssert = new SoftAssert();
    driver.manage().window().maximize();
    driver.get("https://demoqa.com/");
}
    @AfterMethod(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
    }
}
