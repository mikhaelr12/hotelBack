package md.project.hotelback.factory;

import lombok.AllArgsConstructor;
import md.project.hotelback.service.NotificationService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class NotificationFactory {

    private final Map<String, NotificationService> notificationServiceMap;

    public NotificationService getNotificationService(String type) {
        return notificationServiceMap.get(type);
    }
}
