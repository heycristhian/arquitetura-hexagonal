package br.com.heycristhian.hexagonal.adapters.inbounds.messaging;

import br.com.heycristhian.hexagonal.application.usecases.ShowNotification;
import org.springframework.stereotype.Component;

@Component
public class NotificationRabbitConsumer {

    private final ShowNotification showNotification;

    public NotificationRabbitConsumer(ShowNotification showNotification) {
        this.showNotification = showNotification;
    }

    public void listener(String message) {
        showNotification.execute(message);
    }
}
