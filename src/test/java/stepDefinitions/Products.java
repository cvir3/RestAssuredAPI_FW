package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static org.testng.Assert.assertEquals;

public class Products {
    public int StatusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public JSONObject requestParams;

    @Given("I hit the url of get products api endpoint")
    public void i_hit_the_url_of_get_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("/products");
    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer int1) {
        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode, 200);
    }

    @Then("I verify that the rate of the first product is {}")
    public void i_verify_that_the_rate_of_the_first_product_is(String rate) {
        body = response.getBody();
        String responseBody = body.asString();
        JsonPath jsnpath = response.jsonPath();
        String s = jsnpath.getJsonObject("rating[0].rate").toString();
        assertEquals(rate, s);
    }

    //POST Method

    @Given("I hit the url of post product api endpoint")
    public void iHitTheUrlOfPostProductApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();
        requestParams = new JSONObject();


    }

    @And("I pass the request body of product title {}")
    public void i_pass_the_request_body_of_product_title(String arg0)
    {
        requestParams.put( "title","Shoes");
        requestParams.put( "price","1999");
        requestParams.put( "description","Demo shoes");
        requestParams.put( "category","Shoes");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.post("products");
        ResponseBody body = response.getBody();
        JsonPath jsnpath = response.jsonPath();
        String s = jsnpath.getString("id").toString();
        assertEquals("21", s);

        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }
    @Then("I receive the response body with id as {}")
    public void iReceiveTheResponseBodyWithIdAs(String id) {

    }
}

