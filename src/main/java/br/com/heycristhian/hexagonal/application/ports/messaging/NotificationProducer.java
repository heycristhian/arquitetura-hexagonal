package br.com.heycristhian.hexagonal.application.ports.messaging;

public interface NotificationProducer {
    void sendMessage(String message);
}
