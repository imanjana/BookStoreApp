package Utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static data.DataConstants.*;
import static data.DataConstants.BODY_ADD_BOOK_TO_COLLECTION;
import static io.restassured.RestAssured.given;

public class APIRequestUtils {
    public static Response postAddBookToListRequest(String token, String userId, String isbn) {
        Response response = given()
                .headers(getRequestHeaders(token)).contentType(ContentType.JSON)
                .when().body(BODY_ADD_BOOK_TO_COLLECTION.replace("@USERID", userId).replace("@ISBN", isbn)).log().all().
                post(BASE_URL.concat(URI_ADD_BOOK))
                .then().extract().response();
        response.prettyPrint();
        return response;
    }

    public static Response postDeleteBookToListRequest(String token, String userId, String isbn) {
        Response response = given()
                .headers(getRequestHeaders(token)).contentType(ContentType.JSON)
                .when().body(getDeleteRequestHeaders(isbn, userId)).log().all().
                delete(BASE_URL.concat(URI_DELETE_BOOK))
                .then().extract().response();
        response.prettyPrint();
        return response;
    }

    public static Map<String, String> getRequestHeaders(String token) {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);
        header.put("Content-Type", "application/json");
        return header;
    }

    public static Response getAccessToken(String username, String password) {
        HashMap<String, String> data = new HashMap<>();
        data.put("userName", username);
        data.put("password", password);
        Response response = given().contentType("application/json").body(data).when().post("https://demoqa.com/Account/v1/Login")
                .then().extract().response();
        response.prettyPrint();
        return response;
    }

    public static Map<String, String> getDeleteRequestHeaders(String isbn, String userId) {
        HashMap<String, String> body = new HashMap<>();
        body.put("isbn", isbn);
        body.put("userId", userId);
        return body;
    }

    public static Response getUserBookList(String token, String userId) {
        Response response = given()
                .headers(getRequestHeaders(token)).contentType(ContentType.JSON)
                .when().
                get(BASE_URL.concat(URI_UER_DETAILS.replace("@userId", userId)))
                .then().extract().response();
        response.prettyPrint();
        return response;
    }

    public static String getIsbnNumberFromResponse(Response response) {
        ArrayList userBookDetails = response.then().extract().path("books");
        LinkedHashMap bookDetails = (LinkedHashMap) userBookDetails.get(0);
        return (String) bookDetails.get("isbn");
    }
}
