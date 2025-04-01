//package md.project.hotelback.factory;
//
//import lombok.AllArgsConstructor;
//import md.project.hotelback.repository.HotelBookingRepository;
//import md.project.hotelback.repository.RoomRepository;
//import md.project.hotelback.repository.UserRepository;
//import md.project.hotelback.service.BookingService;
//import md.project.hotelback.service.HotelServicesService;
//import md.project.hotelback.service.impl.booking.room.StandardBookingServiceImpl;
//import md.project.hotelback.service.impl.booking.services.StandardServicesServiceImpl;
//import md.project.hotelback.util.UserExtractServiceImpl;
//import org.springframework.stereotype.Component;
//
//@Component("standard")
//@AllArgsConstructor
//public class StandardBookingFactory implements AbstractBookingFactory {
//
//    private final UserRepository userRepository;
//    private final UserExtractServiceImpl userExtractService;
//    private final HotelBookingRepository hotelBookingRepository;
//    private final RoomRepository roomRepository;
//
//    @Override
//    public BookingService createBookingService() {
//        return new StandardBookingServiceImpl(hotelBookingRepository,roomRepository, userExtractService);
//    }
//
//    @Override
//    public HotelServicesService createHotelServicesService() {
//        return new StandardServicesServiceImpl(userRepository, userExtractService);
//    }
//}
