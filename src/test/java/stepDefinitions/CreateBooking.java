package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import pojo.request.Bookingdates;
import pojo.request.CreateBookingDetails;
import pojo.response.CreateBookingResponse;
import utils.TestDataWriter;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;

public class CreateBooking extends BaseStep {
    Map<String,String> mapRequest;
    Bookingdates bookingdates;
    CreateBookingDetails createBookingDetails = new CreateBookingDetails();

    ObjectMapper objectMapper = new ObjectMapper();

    @When("the user send POST request to the endpoint with following details")
    public void theUserSendPOSTRequestToTheEndpointWithFollowingDetails(DataTable dataTable) throws JsonProcessingException {
        mapRequest = dataTable.asMap(String.class,String.class);
        bookingdates =new Bookingdates(mapRequest.get("checkin"), mapRequest.get("checkout"));
//        bookingdates.setCheckin(mapRequest.get("checkin"));
//        bookingdates.setCheckout(mapRequest.get("checkout"));
        createBookingDetails.setFirstname(mapRequest.get("firstname"));
        createBookingDetails.setLastname(mapRequest.get("lastname"));
        createBookingDetails.setTotalprice(Integer.parseInt(mapRequest.get("totalprice")));
        createBookingDetails.setDepositpaid(Boolean.parseBoolean(mapRequest.get("depositpaid")));
        createBookingDetails.setAdditionalneeds(mapRequest.get("additionalneeds"));
        createBookingDetails.setBookingdates(bookingdates);
        String jsonBookingDetails = objectMapper.writeValueAsString(createBookingDetails);
        response = request.contentType(" application/json").body(jsonBookingDetails).post(createBooking);

    }

    @And("The booking id should not be empty or null")
    public void theBookingIdShouldNotBeEmptyOrNull() {
        int id = response.jsonPath().getInt("bookingid");
        System.out.println(id);
        Assertions.assertThat(id).isNotNull();
        Assertions.assertThat(id).isNotZero();
    }

    @And("The booking object in response should match with given datas")
    public void theBookingObjectInResponseShouldMatchWithGivenDatas() {
        SoftAssertions softAssertions = new SoftAssertions();
        CreateBookingResponse createBookingResponse = response.as(CreateBookingResponse.class);

        softAssertions.assertThat(createBookingResponse.getBooking().getFirstname()).isEqualTo(createBookingDetails.getFirstname());
        softAssertions.assertThat(createBookingResponse.getBooking().getLastname()).isEqualTo(createBookingDetails.getLastname());
        softAssertions.assertThat(createBookingResponse.getBooking().getTotalprice()).isEqualTo(createBookingDetails.getTotalprice());
        softAssertions.assertThat(createBookingResponse.getBooking().isDepositpaid()).isEqualTo(createBookingDetails.isDepositpaid());
        softAssertions.assertThat(createBookingResponse.getBooking().getBookingdates().getCheckin()).isEqualTo(createBookingDetails.getBookingdates().getCheckin());
        softAssertions.assertThat(createBookingResponse.getBooking().getBookingdates().getCheckout()).isEqualTo(createBookingDetails.getBookingdates().getCheckout());
        softAssertions.assertThat(createBookingResponse.getBooking().getAdditionalneeds()).isEqualTo(createBookingDetails.getAdditionalneeds());
        softAssertions.assertAll();

    }
}
