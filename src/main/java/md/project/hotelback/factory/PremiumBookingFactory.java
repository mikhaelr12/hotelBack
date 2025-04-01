//package md.project.hotelback.factory;
//
//import md.project.hotelback.service.BookingService;
//import md.project.hotelback.service.HotelServicesService;
//import md.project.hotelback.service.impl.booking.room.PremiumBookingServiceImpl;
//import md.project.hotelback.service.impl.booking.services.PremiumServicesServiceImpl;
//import org.springframework.stereotype.Component;
//
//@Component("premium")
//public class PremiumBookingFactory implements AbstractBookingFactory{
//    @Override
//    public BookingService createBookingService() {
//        return new PremiumBookingServiceImpl();
//    }
//
//    @Override
//    public HotelServicesService createHotelServicesService() {
//        return new PremiumServicesServiceImpl();
//    }
//}
