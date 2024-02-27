package pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdateBooking {

    private String firstname;
    private int totalprice;
    private boolean depositpaid;
    private String lastname;
    private Bookingdates bookingdates;
    private String additionalneeds;
}