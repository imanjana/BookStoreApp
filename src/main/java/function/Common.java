package function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Common {

    public static void scrollDown(WebDriver driver) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", new Object[0]);
    }

    public static void waitTillElementLoad(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitTillElementDisappeared(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void confirmAlertMessage(WebDriver driver) throws InterruptedException {
        waitTillPopupLoad(driver);
        driver.switchTo().alert().accept();
    }

    public static String getAlertMessage(WebDriver driver) throws InterruptedException {
        waitTillPopupLoad(driver);
        return driver.switchTo().alert().getText();
    }

    public static void waitTillPopupLoad(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 1; i <= 7; i++) {
            System.out.println("Attempt " + i);
            TimeUnit.SECONDS.sleep(5);
            if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
                break;
            }
        }

    }

    public static boolean isElementPresent(WebDriver driver, By by) {
        boolean isPresent = true;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        return isPresent;
    }
}
