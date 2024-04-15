//package restAssuredTest;
//
//import io.restassured.RestAssured;
//import org.testng.annotations.*;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//import io.restassured.assertion.*;
//
//import java.util.HashMap;
//
//public class POST_Request {
//
//    public static HashMap map = new HashMap();
//    @BeforeClass
//    public void postdata()
//    {
//        map.put("FirstName",RestUtils.getFirstName());
//        map.put("LastName",RestUtils.getLastName());
//        map.put("UserName",RestUtils.getUserName());
//
//        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
//        RestAssured.basePath="/users";
//    }
//    @Test
//    public void testPost()
//    {
//        given()
//                .contentType("application/json")
//                    .body(map)
//                .when()
//                    .post()
//                .then()
//                    .statusCode(201)
//                .log().all();
////                .and()
////                .body("status", equalTo("success"))
//////                .body("status", equalTo("success"))
////                .and()
////                .body("message", equalTo("Successfully! Record has been added."));
//    }
//}
