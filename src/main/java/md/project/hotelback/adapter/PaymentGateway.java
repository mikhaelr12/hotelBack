package md.project.hotelback.adapter;

import md.project.hotelback.dto.request.PaymentRequest;
import md.project.hotelback.dto.response.PaymentResponse;

public interface PaymentGateway {
    PaymentResponse createPayment(PaymentRequest paymentRequest) throws Exception;
}
