package function;

import org.openqa.selenium.WebDriver;
import pages.ProfilePage;

public class Profile {
    private static ProfilePage profilePage= new ProfilePage();
    public static void clickDeleteBookButton(WebDriver driver) {
        profilePage.clickDeleteBookButton(driver);

    }
    public static void clickLogoutButton(WebDriver driver) {
        profilePage.clickLogoutButton(driver);

    }
    public static void clickOkForDeleteConfirmation(WebDriver driver) {
        profilePage.clickOkForDeleteConfirmation(driver);

    }
    public static void deleteABook(WebDriver driver) throws InterruptedException {
        Common.confirmAlertMessage(driver);
        Home.clickProfileMenu(driver);
        clickDeleteBookButton(driver);
        clickOkForDeleteConfirmation(driver);

    }
    public static boolean isBookAvailable(WebDriver driver,String bookName) {
        return  profilePage.isBookAvailable(driver,bookName);

    }
}
