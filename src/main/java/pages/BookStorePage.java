package pages;

import function.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStorePage {
    private By lblBookStore = By.xpath("//div[text()='Book Store' and @class='main-header']");
    private By btnLogin = By.id("login");
    private String lblFirstBookId = "//span/a[text()='@text']";
    private By btnAddNewRecordButton = By.xpath("//button[text()='Add To Your Collection']");
    private By lblLoading = By.id("loading-label");

    public boolean isBookStorePageLoaded(WebDriver driver) {
        return driver.findElement(lblBookStore).isDisplayed();

    }

    public void clickLoginButton(WebDriver driver) {
        Common.waitTillElementLoad(driver, btnLogin);
        driver.findElement(btnLogin).click();

    }

    public void clickFirstBook(WebDriver driver, String bookName) {
        Common.waitTillElementDisappeared(driver, lblLoading);
        Common.waitTillElementLoad(driver, By.xpath(lblFirstBookId.replace("@text", bookName)));
        driver.findElement(By.xpath(lblFirstBookId.replace("@text", bookName))).click();

    }

    public void clickAddToYourCollectionButton(WebDriver driver) {
        Common.waitTillElementLoad(driver, btnAddNewRecordButton);
        driver.findElement(btnAddNewRecordButton).click();

    }


}
