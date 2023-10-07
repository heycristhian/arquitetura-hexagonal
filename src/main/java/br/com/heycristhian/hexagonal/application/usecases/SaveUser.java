package br.com.heycristhian.hexagonal.application.usecases;

import br.com.heycristhian.hexagonal.application.models.User;
import br.com.heycristhian.hexagonal.application.ports.messaging.NotificationProducer;
import br.com.heycristhian.hexagonal.application.ports.persistence.UserRepository;

public class SaveUser {

    private final UserRepository userRepository;
    private final NotificationProducer notificationProducer;

    public SaveUser(UserRepository userRepository, NotificationProducer notificationProducer) {
        this.userRepository = userRepository;
        this.notificationProducer = notificationProducer;
    }

    public User execute(User user) {
        var savedUser = userRepository.save(user);
        notificationProducer.sendMessage(String.valueOf(savedUser));

        return savedUser;
    }
}
