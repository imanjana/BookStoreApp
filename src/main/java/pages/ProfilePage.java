package pages;

import function.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private By btnDeleteBook = By.id("delete-record-undefined");
    private By btnLogout = By.xpath("//button[@id='submit' and text()='Log out']");
    private By btnDeleteConfirmationOk = By.id("closeSmallModal-ok");
    private String lblFirstBookId = "//span/a[text()='@text']";
    private By lblLoading = By.id("loading-label");
   public void clickDeleteBookButton(WebDriver driver) {
       Common.scrollDown(driver);
       Common.waitTillElementLoad(driver,btnDeleteBook);
       driver.findElement(btnDeleteBook).click();

   }

    public void clickLogoutButton(WebDriver driver) {
        Common.waitTillElementLoad(driver,btnLogout);
        driver.findElement(btnLogout).click();

    }
    public void clickOkForDeleteConfirmation(WebDriver driver) {
        Common.waitTillElementLoad(driver,btnDeleteConfirmationOk);
        driver.findElement(btnDeleteConfirmationOk).click();

    }
    public boolean isBookAvailable(WebDriver driver,String bookName) {
        Common.waitTillElementDisappeared(driver,lblLoading);
        return Common.isElementPresent(driver,By.xpath(lblFirstBookId.replace("@text",bookName)));

    }
}
