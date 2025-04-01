package md.project.hotelback.controller;

import com.stripe.exception.*;
import com.stripe.model.Charge;
import lombok.RequiredArgsConstructor;
import md.project.hotelback.adapter.PaymentGateway;
import md.project.hotelback.dto.request.PaymentRequest;
import md.project.hotelback.dto.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.Map;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final Map<String, PaymentGateway> gateways;

    @Value("${publishable_key}")
    private String publicKey;

    @PostMapping("/{paymentMethod}")
    public ResponseEntity<?> charge(@RequestBody PaymentRequest paymentRequest,
                                    @PathVariable String paymentMethod)  {
        try {
            PaymentGateway gateway = gateways.get(paymentMethod);
            PaymentResponse paymentResponse = gateway.createPayment(paymentRequest);
            return ResponseEntity.ok(paymentResponse);
        } catch (CardException | APIException | AuthenticationException | InvalidRequestException | APIConnectionException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
