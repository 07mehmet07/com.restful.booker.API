package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.Assertions;
import pojo.response.GetAllBookings;
import utils.TestDataWriter;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllBookingIds extends BaseStep{

    List<GetAllBookings> bookings;
    @Given("The user in the base URI")
    public void theUserInTheBaseURI() {
        request = given();
        System.out.println(token);
    }
    @When("the user send GET request to get all bookings endpoint")
    public void theUserSendGETRequestToGetAllBookingsEndpoint() {
        response = request.contentType("application/json")
                .when().get(getAllBookingIds);
        bookings = response.as(new TypeRef<List<GetAllBookings>>() {
        });
        TestDataWriter.writeData(bookings.get(0),"bookings.json");
    }


    @And("The user should see array of bookings")
    public void theUserShouldSeeArrayOfBookings() {
        Assertions.assertThat(bookings.size()).isGreaterThan(0);
    }
}
