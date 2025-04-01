package md.project.hotelback.service.impl.payments;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import md.project.hotelback.dto.request.PaymentRequest;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.exception.BookingException;
import md.project.hotelback.repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StripeServiceImpl {

    private final HotelBookingRepository hotelBookingRepository;

    @Value("${secret_key}")
    private String stripeApiKey;

    @PostConstruct
    public void init(){
        Stripe.apiKey = stripeApiKey;
    }

    public Charge charge(PaymentRequest paymentRequest) throws APIConnectionException,
            APIException, AuthenticationException,
            InvalidRequestException, CardException {
        HotelBooking hotelBooking = hotelBookingRepository.findById(paymentRequest.getBookingId())
                .orElseThrow(() ->  new BookingException("No booking found"));
        long amount = Math.round(hotelBooking.getFinalPrice() * 100);
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", "usd");
        chargeParams.put("source", paymentRequest.getSource());
        return Charge.create(chargeParams);
    }
}
