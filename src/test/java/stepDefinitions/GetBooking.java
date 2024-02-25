package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pojo.response.GetBookingDetails;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;

public class GetBooking extends BaseStep{
    @Given("The user has valid {string}")
    public void theUserHasValid(String id) {
        request = given().contentType(" application/json").param("id");
    }

    @When("The user send GET request to get booking endpoint with specific ID as {int}")
    public void theUserSendGETRequestToGetBookingEndpointWithSpecificIDAs(int id) {
        response = request.when().get(getBooking + "/" + id);
    }
}
