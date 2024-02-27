package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class DeleteBooking extends BaseStep {
    @When("The user sends a DELETE request to the delete booking endpoint with valid id {int}")
    public void theUserSendsADELETERequestToTheDeleteBookingEndpointWithValidAuthorizationAndId(int id) {
        response = request
                .header("Cookie","token=" +token)
                .when()
                .delete(deleteBooking + "/" + id);
    }


}


