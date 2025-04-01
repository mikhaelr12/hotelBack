package md.project.hotelback.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentRequest {

    private Double amount;
    private Long bookingId;
    private String source;

}
