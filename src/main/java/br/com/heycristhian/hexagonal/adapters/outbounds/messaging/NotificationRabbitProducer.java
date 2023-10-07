package br.com.heycristhian.hexagonal.adapters.outbounds.messaging;

import br.com.heycristhian.hexagonal.application.ports.messaging.NotificationProducer;
import org.springframework.stereotype.Component;

@Component
public class NotificationRabbitProducer implements NotificationProducer {

    @Override
    public void sendMessage(String message) {
        System.out.println("Message sent: " + message);
    }
}
