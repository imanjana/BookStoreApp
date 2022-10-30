package pages;

import function.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By txtUserName = By.xpath("//input[@id='userName']");
    private By txtPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.id("login");

    public void enterUserNameAndPassword(WebDriver driver, String username, String password) {
        Common.waitTillElementLoad(driver, txtUserName);
        driver.findElement(txtUserName).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLoginButton(WebDriver driver) {
        Common.waitTillElementLoad(driver, btnLogin);
        driver.findElement(btnLogin).click();
    }


}
