package md.project.hotelback.config;

import md.project.hotelback.proxy.BookingServiceProxy;
import md.project.hotelback.service.BookingService;
import md.project.hotelback.service.impl.BookingServiceImpl;
import md.project.hotelback.util.UserExtractServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BookingProxyConfig {

    @Bean
    @Primary
    public BookingService bookingServiceProxy(BookingServiceImpl bookingServiceImpl, UserExtractServiceImpl userExtractService) {
        return new BookingServiceProxy(bookingServiceImpl, userExtractService);
    }
}
