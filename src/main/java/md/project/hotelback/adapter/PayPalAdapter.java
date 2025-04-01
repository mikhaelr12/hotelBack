package md.project.hotelback.adapter;

import com.paypal.orders.LinkDescription;
import com.paypal.orders.Order;
import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import md.project.hotelback.dto.request.PaymentRequest;
import md.project.hotelback.dto.response.PaymentResponse;
import md.project.hotelback.service.impl.payments.PayPalServiceImpl;
import org.springframework.stereotype.Service;

@Service("paypal")
@AllArgsConstructor
public class PayPalAdapter implements PaymentGateway {

    private PayPalServiceImpl payPalService;

    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) throws Exception {
        Order order = payPalService.createOrder(paymentRequest);
        PaymentResponse response = new PaymentResponse();
        response.setId(order.id());
        response.setStatus(order.status());
        // Extract approval link from the order if available.
        for (LinkDescription link : order.links()) {
            if ("approve".equalsIgnoreCase(link.rel())) {
                response.setApprovalUrl(link.href());
                break;
            }
        }
        // For PayPal, you might not have an "amount" field in the same way.
        response.setAmount(null);
        response.setCurrency("usd");
        return response;
    }
}
