package function;

import org.openqa.selenium.WebDriver;
import pages.BookStorePage;

public class BookStore {
    private static BookStorePage bookStorePage = new BookStorePage();

    public static boolean isBookStorePageLoaded(WebDriver driver) {
        return bookStorePage.isBookStorePageLoaded(driver);

    }

    public static void clickOnBookName(WebDriver driver, String bookName) {
        bookStorePage.clickFirstBook(driver, bookName);

    }

    public static void clickAddToYourCollectionButton(WebDriver driver) {
        Common.scrollDown(driver);
        bookStorePage.clickAddToYourCollectionButton(driver);
    }

    public static void clickAddBookToCollection(WebDriver driver, String bookName) {
        clickOnBookName(driver, bookName);
        clickAddToYourCollectionButton(driver);
    }

}
