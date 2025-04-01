package md.project.hotelback.dto.response;

import lombok.Data;

@Data
public class PaymentResponse {
    private String id;
    private String status;
    private Long amount;
    private String currency;
    private String approvalUrl;
}