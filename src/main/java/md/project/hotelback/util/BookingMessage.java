package md.project.hotelback.util;

import md.project.hotelback.entity.HotelBooking;
import org.springframework.stereotype.Component;

@Component
public class BookingMessage {

    public String generateMessage(HotelBooking hotelBooking) {
        return "Your booking: \n" +
                "Check-in: " + hotelBooking.getCheckIn() + "\n" +
                "Check-out : " + hotelBooking.getCheckOut() + "\n" +
                "Hotel name: " + hotelBooking.getHotel().getName() + "\n" +
                "Country: " + hotelBooking.getHotel().getCountry().getCountryName() + "\n" +
                "Hotel address: " + hotelBooking.getHotel().getAddress() + "\n" +
                "Price: " + hotelBooking.getFinalPrice();
    }
}
