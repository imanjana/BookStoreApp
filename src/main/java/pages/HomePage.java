package pages;

import function.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private By lblBookStoreApplication = By.xpath("//h5[text()='Book Store Application']");
    private By nvBarProfile = By.xpath(" //span[text()='Profile']");

    public void clickBookStoreApplication(WebDriver driver) {
        Common.waitTillElementLoad(driver, lblBookStoreApplication);
        driver.findElement(lblBookStoreApplication).click();

    }

    public void clickProfileMenu(WebDriver driver) {
        Common.scrollDown(driver);
        Common.waitTillElementLoad(driver, nvBarProfile);
        driver.findElement(nvBarProfile).click();

    }


}
