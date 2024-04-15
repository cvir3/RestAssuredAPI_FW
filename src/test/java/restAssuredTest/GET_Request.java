//package restAssuredTest;
//
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//
//public class GET_Request {
//    @Test
//    public void getUserDetails() {
//        given()
//                .when()
//                    .get("https://www.boredapi.com/api/activity")
//                .then()
//                .   statusCode(200)
//                .assertThat().body("participants", equalTo(1))
//                    .header("Content-Type","application/json; charset=utf-8")
//                .log().all();
//    }
////    @Test
////    public void testLogging(){
////
////        Response res = given().contentType("ContentType.JSON")
////                        .when().get("https://www.boredapi.com/api/activity");
////        Assert.assertEquals(res.getStatusCode(),200);
////        Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
////        String participants = res.jsonPath().get("participants").toString();
////        Assert.assertEquals(participants,"1");
////    }
//}
//
