package md.project.hotelback.service.impl.payments;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.*;
import md.project.hotelback.dto.request.PaymentRequest;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayPalServiceImpl {

    private final HotelBookingRepository hotelBookingRepository;
    private final PayPalHttpClient client;

    public PayPalServiceImpl(@Value("${paypal_clientId}") String clientId,
                             @Value("${paypal_clientSecret}") String clientSecret,
                             @Value("${paypal_mode}") String mode, HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
        PayPalEnvironment environment;
        if ("live".equalsIgnoreCase(mode)) {
            environment = new PayPalEnvironment.Live(clientId, clientSecret);
        } else {
            environment = new PayPalEnvironment.Sandbox(clientId, clientSecret);
        }
        this.client = new PayPalHttpClient(environment);
    }

    public Order createOrder(PaymentRequest paymentRequest) throws IOException {
        OrdersCreateRequest request = new OrdersCreateRequest();
        request.header("prefer", "return=representation");
        request.requestBody(buildRequestBody(paymentRequest));

        HttpResponse<Order> response = client.execute(request);
        return response.result();
    }

    private OrderRequest buildRequestBody(PaymentRequest paymentRequest) {

        HotelBooking booking = hotelBookingRepository.findById(paymentRequest.getBookingId())
                .orElse(null);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent("CAPTURE");

        ApplicationContext applicationContext = new ApplicationContext()
                .brandName("Your Brand")
                .landingPage("NO_PREFERENCE")
                .cancelUrl("https://localhost:8080/hotels")
                .returnUrl("https://localhost:8080/hotels")
                .userAction("PAY_NOW")
                .shippingPreference("NO_SHIPPING");
        orderRequest.applicationContext(applicationContext);

        List<PurchaseUnitRequest> purchaseUnits = new ArrayList<>();
        PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest();
        String value = String.format("%.2f", booking.getFinalPrice());
        purchaseUnitRequest.amountWithBreakdown(new AmountWithBreakdown()
                .currencyCode("usd")
                .value(value));
        purchaseUnits.add(purchaseUnitRequest);
        orderRequest.purchaseUnits(purchaseUnits);

        return orderRequest;
    }
}
