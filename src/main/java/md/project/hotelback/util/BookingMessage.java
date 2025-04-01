package md.project.hotelback.util;

import md.project.hotelback.entity.HotelBooking;

public class BookingMessage {

    public String generateMessage(HotelBooking hotelBooking) {
        return "Your booking: \n" +
                "Check-in: " + hotelBooking.getCheckIn() + "\n" +
                "Check-out : " + hotelBooking.getCheckOut() + "\n" +
                "Hotel name: " + hotelBooking.getLocation().getHotel().getName() + "\n" +
                "Country: " + hotelBooking.getLocation().getHotel().getCountry().getCountryName() + "\n" +
                "Hotel address: " + hotelBooking.getLocation().getAddress() + "\n" +
                "Price: " + hotelBooking.getFinalPrice();
    }
}
