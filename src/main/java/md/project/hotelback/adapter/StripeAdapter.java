package md.project.hotelback.adapter;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.request.PaymentRequest;
import md.project.hotelback.dto.response.PaymentResponse;
import md.project.hotelback.service.impl.payments.StripeServiceImpl;
import org.springframework.stereotype.Service;

@Service("stripe")
@AllArgsConstructor
public class StripeAdapter implements PaymentGateway {

    private StripeServiceImpl stripeService;

    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) throws Exception {
        var charge = stripeService.charge(paymentRequest);
        PaymentResponse response = new PaymentResponse();
        response.setId(charge.getId());
        response.setStatus(charge.getStatus());
        response.setAmount(charge.getAmount());
        response.setCurrency(charge.getCurrency());
        response.setApprovalUrl(null);
        return response;    }
}
