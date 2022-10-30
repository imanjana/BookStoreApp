package data;

public class DataConstants {
    //Book ISBN Codes
    public static final String ISBN_DESIGNING_EVOLABLE_WEB_APIS_WITH_ASP_NET = "9781449337711";
    public static final String ISBN_GIT_POCKET_GUIDE = "9781449325862";
    //Book Name
    public static final String BOOK_GIT_POCKET_GUIDE = "Git Pocket Guide";
    //Base Url
    public static final String BASE_URL = "https://demoqa.com";
    //URI
    public static final String URI_ADD_BOOK = "/BookStore/v1/Books";
    public static final String URI_DELETE_BOOK = "/BookStore/v1/Book";
    public static final String URI_UER_DETAILS = "/Account/v1/User/@userId";
    //Credentials
    public static final String USERNAME = "icha71";
    public static final String PASSWORD = "Evo@1234";
    //Request Bodies
    public static final String BODY_ADD_BOOK_TO_COLLECTION = "\n" +
            "{\"userId\":\"@USERID\",\"collectionOfIsbns\":[{\"isbn\":\"@ISBN\"}]}";


}
