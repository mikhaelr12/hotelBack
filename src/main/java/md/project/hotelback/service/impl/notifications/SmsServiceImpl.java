package md.project.hotelback.service.impl.notifications;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.entity.User;
import md.project.hotelback.service.NotificationService;
import md.project.hotelback.util.BookingMessage;
import md.project.hotelback.util.UserExtractServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sms")
public class SmsServiceImpl implements NotificationService {

    @Value("${account_sid}")
    private String accountSid;

    @Value("${auth_token}")
    private String token;

    @Value("${phone_number}")
    private String phone;

    private final UserExtractServiceImpl userExtractService;

    public SmsServiceImpl(@Value("${account_sid}") String accountSid,
                          @Value("${auth_token}") String token,
                          @Value("${phone_number}") String phone,
                          UserExtractServiceImpl userExtractService) {
        this.accountSid = accountSid;
        this.token = token;
        this.phone = phone;
        this.userExtractService = userExtractService;
        Twilio.init(accountSid, token);
    }


    @Override
    public void sendNotification(String jwt, HotelBooking hotelBooking) {
        User user = userExtractService.getUser(jwt);
        BookingMessage bookingMessage = new BookingMessage();
        Message message = Message.creator(
            new PhoneNumber("373" + user.getPhoneNumber()),
                new PhoneNumber(phone),
                bookingMessage.generateMessage(hotelBooking)
        ).create();
    }
}
