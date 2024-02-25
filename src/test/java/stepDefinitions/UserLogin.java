package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pojo.request.Login;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;

public class UserLogin extends BaseStep{

    public ObjectMapper objectMapper = new ObjectMapper();
    @Given("The user has valid {string} and {string}")
    public void theUserHasValidAnd(String username, String password) throws JsonProcessingException {
        Login credentials = new Login(username,password);
        String jsonCredentials = objectMapper.writeValueAsString(credentials);
        request = given().contentType("application/json").body(jsonCredentials);
    }

    @When("The user send POST request to the login endpoint")
    public void theUserSendRequestToTheLoginEndpoint() {
        response = request.when().post(authEndpoint);
    }

    @Then("The user should see status code as {int}")
    public void theUserShouldSeeStatusCodeAs(int number) {
        then(response.getStatusCode()).isEqualTo(number);
    }

    @And("The user receives a token as a response")
    public void theUserReceivesATokenAsAResponse() {
        String token = response.jsonPath().getString("token");
        then(token).isNotEmpty();
        Assertions.assertThat(token).isNotNull();
    }

    @Given("The user has invalid {string} and valid {string}")
    public void theUserHasInvalidAndValid(String username, String password) throws JsonProcessingException {
        Login credentials = new Login(username,password);
        String jsonCredentials = objectMapper.writeValueAsString(credentials);
        request = given().contentType("application/json").body(jsonCredentials);
    }

    @And("The response should contain an {string}")
    public void theResponseShouldContainAn(String errorMessage) {
        String responseError = response.jsonPath().getString("reason");
        Assertions.assertThat(responseError).isEqualTo(errorMessage);
    }
}
