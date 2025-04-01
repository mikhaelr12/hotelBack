package md.project.hotelback.controller;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.dto.response.BookingResponse;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.factory.NotificationFactory;
import md.project.hotelback.service.BookingService;
import md.project.hotelback.util.TokenExtractServiceImpl;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookingFacade {

    private final NotificationFactory notificationFactory;
    private final BookingService bookingService;

    public BookingResponse book(BookingDTO bookingDTO,
                                String token) {
        TokenExtractServiceImpl tokenExtractService = TokenExtractServiceImpl.getInstance();
        String jwt = tokenExtractService.getToken(token);
        HotelBooking hotelBooking = bookingService.book(bookingDTO, jwt);
        notificationFactory.getNotificationService(bookingDTO.getNotificationType().toLowerCase())
                .sendNotification(jwt, hotelBooking);

        return new BookingResponse(hotelBooking.getId(), hotelBooking);
    }
}
