package StepDef;
import FileWrappers.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class PatternSteps {


    Response response;

    @Given("The user calls Post Pattern PathParameter {string} successfully and User enter {string} and {string}")
    public void theUserCallsPostPatternPathParameterSuccessfullyAndUserEnterAnd(String queryParm,String userName, String password) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", userName);
        requestParams.put("password", password);
        response = RestAssured.given()
                .baseUri(ConfigReader.PatternURL)
                .body(requestParams.toJSONString()).
                contentType( "application/json")
                .accept("application/json")
                .header("Connection", "keep-alive")
                .when().post(queryParm);
    }


    @Then("Check returned {string}")
    public void checkReturned( String statusCode) {
        Assert.assertEquals( (response.getStatusCode()),Integer.parseInt(statusCode));
    }
}
