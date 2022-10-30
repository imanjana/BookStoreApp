package function;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class Home {
    private static HomePage homePage = new HomePage();

    public static void clickBookStoreApplication(WebDriver driver) {
        Common.scrollDown(driver);
        homePage.clickBookStoreApplication(driver);

    }

    public static void clickProfileMenu(WebDriver driver) {
        homePage.clickProfileMenu(driver);

    }

}
