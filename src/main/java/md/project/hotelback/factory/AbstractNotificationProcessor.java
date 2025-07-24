package md.project.hotelback.factory;

import lombok.RequiredArgsConstructor;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.entity.User;
import md.project.hotelback.service.NotificationService;
import md.project.hotelback.util.UserExtractServiceImpl;

@RequiredArgsConstructor
public abstract class AbstractNotificationProcessor implements NotificationService {

    private final UserExtractServiceImpl userExtractService;

    @Override
    public void sendNotification(String jwt, HotelBooking hotelBooking) {
        User user = userExtractService.getUser(jwt);
        String message = prepareMessage(hotelBooking);
        doSendNotification(user, message);
        logNotification(hotelBooking, user);
    }

    protected abstract String prepareMessage(HotelBooking hotelBooking);

    protected abstract void doSendNotification(User user, String message);

    protected void logNotification(HotelBooking hotelBooking, User user) {
        System.out.println("Notification sent to " + user.getEmail() + " for booking ID " + hotelBooking.getId());
    }

}
