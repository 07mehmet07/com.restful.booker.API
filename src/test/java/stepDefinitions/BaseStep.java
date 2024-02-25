package stepDefinitions;

import static io.restassured.RestAssured.baseURI;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigManager;

public abstract class BaseStep {

    static protected RequestSpecification request;
    static protected Response response;
    protected String authEndpoint;

    protected String getBooking;

    protected String getAllBookingIds;

    protected String createBooking;

    protected String updateBooking;

    protected String deleteBooking;

    public BaseStep() {
        this.authEndpoint = ConfigManager.getProperty("Api.Register.Endpoint");
        baseURI = ConfigManager.getProperty("Base.URI");
        this.getBooking = ConfigManager.getProperty("Api.GetBooking.Endpoint");
        this.getAllBookingIds = ConfigManager.getProperty("Api.GetAllBookingsIds.Endpoint");
        this.createBooking = ConfigManager.getProperty("Api.stepDefinitions.CreateBooking.Endpoint");
        this.updateBooking = ConfigManager.getProperty("Api.UpdateBooking.Endpoint");
        this.deleteBooking = ConfigManager.getProperty("Api.DeleteBooking.Endpoint");
    }
}
