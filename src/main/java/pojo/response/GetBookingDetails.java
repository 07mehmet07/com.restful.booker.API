package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class GetBookingDetails {
    private String firstname;

    private String lastname;

    private int totalPrice;
    private boolean depositpaid;
}
