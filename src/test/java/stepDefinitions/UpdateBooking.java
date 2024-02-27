package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.assertj.core.api.SoftAssertions;
import pojo.request.Bookingdates;
import pojo.request.CreateBookingDetails;
import pojo.response.update.UpdateBookingRes;

import java.util.Map;

public class UpdateBooking extends BaseStep {
    Map<String, String> mapRequest;
    Bookingdates bookingdates;
    CreateBookingDetails createBookingDetails = new CreateBookingDetails();

    protected static final int id = 2045;
    ObjectMapper objectMapper = new ObjectMapper();

    @When("the user send Update request to the endpoint with following details")
    public void theUserSendDeleteRequestToTheEndpointWithFollowingDetails(DataTable dataTable) throws JsonProcessingException {
        mapRequest = dataTable.asMap(String.class, String.class);
        bookingdates = new Bookingdates(mapRequest.get("checkin"), mapRequest.get("checkout"));
        createBookingDetails.setFirstname(mapRequest.get("firstname"));
        createBookingDetails.setLastname(mapRequest.get("lastname"));
        createBookingDetails.setTotalprice(Integer.parseInt(mapRequest.get("totalprice")));
        createBookingDetails.setDepositpaid(Boolean.parseBoolean(mapRequest.get("depositpaid")));
        createBookingDetails.setAdditionalneeds(mapRequest.get("additionalneeds"));
        createBookingDetails.setBookingdates(bookingdates);
        // String jsonBookingDetails = objectMapper.writeValueAsString(createBookingDetails);
        response = request
                .header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.JSON)
                .cookie("token", token)
                .body(createBookingDetails)
                .when()
                .put(updateBooking + "/" + id);

    }

    @And("The booking objects in response should match with given datas")
    public void theBookingObjectsInResponseShouldMatchWithGivenDatas() {
        SoftAssertions softAssertions = new SoftAssertions();
        UpdateBookingRes updateRes = response.as(UpdateBookingRes.class);

        softAssertions.assertThat(updateRes.getFirstname()).isEqualTo(createBookingDetails.getFirstname());
        softAssertions.assertThat(updateRes.getLastname()).isEqualTo(createBookingDetails.getLastname());
//        softAssertions.assertThat(updateRes.getTotalprice()).isEqualTo(createBookingDetails.getTotalprice());
//        softAssertions.assertThat(updateRes.isDepositpaid()).isEqualTo(createBookingDetails.isDepositpaid());
//        softAssertions.assertThat(updateRes.getBookingdates().getCheckin()).isEqualTo(createBookingDetails.getBookingdates().getCheckin());
//        softAssertions.assertThat(updateRes.getBookingdates().getCheckout()).isEqualTo(createBookingDetails.getBookingdates().getCheckout());
//        softAssertions.assertThat(updateRes.getAdditionalneeds()).isEqualTo(createBookingDetails.getAdditionalneeds());
        softAssertions.assertAll();


    }
}