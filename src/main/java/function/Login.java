package function;

import org.openqa.selenium.WebDriver;
import pages.BookStorePage;
import pages.LoginPage;

public class Login {
    private static BookStorePage bookStorePage = new BookStorePage();
    private static LoginPage loginPage = new LoginPage();

    public static void Login(WebDriver driver, String userName, String password) {
        bookStorePage.clickLoginButton(driver);
        loginPage.enterUserNameAndPassword(driver, userName, password);
        loginPage.clickLoginButton(driver);
    }

}
