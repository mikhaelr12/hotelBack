package md.project.hotelback.service.impl.notifications;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.entity.User;
import md.project.hotelback.factory.AbstractNotificationProcessor;
import md.project.hotelback.util.BookingMessage;
import md.project.hotelback.util.UserExtractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sms")
public class SmsServiceImpl extends AbstractNotificationProcessor {

    @Value("${account_sid}")
    private String accountSid;

    @Value("${auth_token}")
    private String authToken;

    @Value("${phone_number}")
    private String fromNumber;

    @Autowired
    private final BookingMessage bookingMessage;

    @Autowired
    private final UserExtractServiceImpl userExtractService;

    // Initialize Twilio once the bean is constructed
    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public SmsServiceImpl(UserExtractServiceImpl userExtractService, BookingMessage bookingMessage, UserExtractServiceImpl userExtractService1) {
        super(userExtractService);
        // BookingMessage will be injected via @Autowired on the field
        this.bookingMessage = bookingMessage;
        this.userExtractService = userExtractService1;
    }

    @Override
    protected String prepareMessage(HotelBooking hotelBooking) {
        return bookingMessage.generateMessage(hotelBooking);
    }

    @Override
    protected void doSendNotification(User user, String message) {
        Message.creator(
                new PhoneNumber("373" + user.getPhoneNumber()),
                new PhoneNumber(fromNumber),
                message
        ).create();
    }

    @Override
    protected void logNotification(HotelBooking booking, User user) {
        System.out.println("SMS sent to +" + user.getPhoneNumber() +
                " for booking ID " + booking.getId());
    }
}
