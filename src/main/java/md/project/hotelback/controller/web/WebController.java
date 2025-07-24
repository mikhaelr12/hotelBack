package md.project.hotelback.controller.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Value("${publishable_key}")
    private String publicKey;

    @Value("${paypal_clientId}")
    private String paypalClientId;

    @GetMapping("/signup")
    public String showRegisterPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/hotels")
    public String showHotelPage() {
        return "hotels";
    }

    @GetMapping("/hotel-rooms")
    public String showRoomsPage() {
        return "hotel-rooms";
    }

    @GetMapping("/booking")
    public String showBooking(){
        return "booking";
    }

    @GetMapping("/my-bookings")
    public String showUserBookings(){
        return "my-bookings";
    }

    @GetMapping("/choose-payment")
    public String showPaymentChoose() { return "choose-payment"; }

    @GetMapping("/stripe")
    public String showPaymentStripe(Model model) {
        model.addAttribute("stripePublishableKey", publicKey);
        return "stripe";
    }

    @GetMapping("/paypal")
    public String showPaymentPaypal(Model model){
        model.addAttribute("paypalClientId", paypalClientId);
        return "paypal";
    }
}
