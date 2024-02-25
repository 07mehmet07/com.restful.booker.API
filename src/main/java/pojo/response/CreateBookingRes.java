package pojo.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateBookingRes {
    private String firstname;
    private String lastname;
    private String additionalneeds;
    private CreateBookingDates bookingdates;
    private int totalprice;
    private boolean depositpaid;
}
