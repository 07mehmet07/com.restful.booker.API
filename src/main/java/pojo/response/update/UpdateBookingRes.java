package pojo.response.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookingRes{
	private String firstname;
	private String additionalneeds;
	private Bookingdates bookingdates;
	private int totalprice;
	private boolean depositpaid;
	private String lastname;
}
