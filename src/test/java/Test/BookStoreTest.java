package Test;

import Utils.APIRequestUtils;
import function.*;
import Utils.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static data.DataConstants.*;

public class BookStoreTest extends TestBase {
    @Test(alwaysRun = true)
    public void TestCase1() throws InterruptedException {
        login();
        BookStore.clickAddBookToCollection(driver, BOOK_GIT_POCKET_GUIDE);
        softAssert.assertEquals(Common.getAlertMessage(driver), "Book added to your collection.", "invalid message returns");
        Common.confirmAlertMessage(driver);
        Home.clickProfileMenu(driver);
        //verify book is listed
        softAssert.assertTrue(Profile.isBookAvailable(driver, BOOK_GIT_POCKET_GUIDE), "Book is not listed");
        Profile.clickLogoutButton(driver);
        //as a post step delete the added book from collection,otherwise it shows error as Book already present in the collection!
        Response accessRequestResponse = APIRequestUtils.getAccessToken(USERNAME, PASSWORD);
        //delete book from a collection
        APIRequestUtils.postDeleteBookToListRequest(accessRequestResponse.path("token"), accessRequestResponse.path("userId"),
                ISBN_GIT_POCKET_GUIDE);
        softAssert.assertAll();
    }

    @Test(alwaysRun = true)
    public void TestCase2() throws InterruptedException {
        login();
        BookStore.clickAddBookToCollection(driver, BOOK_GIT_POCKET_GUIDE);
        softAssert.assertEquals(Common.getAlertMessage(driver), "Book added to your collection.", "invalid message returns");
        Profile.deleteABook(driver);
        softAssert.assertEquals(Common.getAlertMessage(driver), "Book deleted.", "invalid message returns");
        Common.confirmAlertMessage(driver);
        //verify book is deleted
        softAssert.assertFalse(Profile.isBookAvailable(driver, BOOK_GIT_POCKET_GUIDE), "Book is listed");
        Profile.clickLogoutButton(driver);
        softAssert.assertAll();
    }

    @Test(alwaysRun = true)
    public void TestCase3() {
        //get the access token-access the application
        Response accessRequestResponse = APIRequestUtils.getAccessToken(USERNAME, PASSWORD);
        String token = accessRequestResponse.path("token");
        String userId = accessRequestResponse.path("userId");
        softAssert.assertTrue(token != null);
        softAssert.assertEquals(accessRequestResponse.getStatusCode(), 200);

        //add a book to a collection
        Response addBookToListRequestResponse = APIRequestUtils.postAddBookToListRequest(token, userId, ISBN_DESIGNING_EVOLABLE_WEB_APIS_WITH_ASP_NET);
        softAssert.assertEquals(addBookToListRequestResponse.getStatusCode(), 201, "Invalid Status Return");

        //Verify book is available in the user book list
        Response getUserBookListRequestResponse = APIRequestUtils.getUserBookList(token, userId);
        softAssert.assertEquals(getUserBookListRequestResponse.getStatusCode(), 200, "Invalid Status Return");
        softAssert.assertEquals(APIRequestUtils.getIsbnNumberFromResponse(getUserBookListRequestResponse), ISBN_DESIGNING_EVOLABLE_WEB_APIS_WITH_ASP_NET, "Book Is Listed");

        //delete book from a collection
        Response deleteBookToListRequestResponse = APIRequestUtils.postDeleteBookToListRequest(token, userId, ISBN_DESIGNING_EVOLABLE_WEB_APIS_WITH_ASP_NET);
        softAssert.assertEquals(deleteBookToListRequestResponse.getStatusCode(), 204, "Invalid Status Return");
        softAssert.assertTrue(getUserBookListRequestResponse.then().extract().path("Books") == null, "Book Is Listed");
        softAssert.assertAll();
    }

    public void login() {
        Home.clickBookStoreApplication(driver);
        softAssert.assertTrue(function.BookStore.isBookStorePageLoaded(driver));
        Login.Login(driver, USERNAME, PASSWORD);
        softAssert.assertAll();
    }

}
