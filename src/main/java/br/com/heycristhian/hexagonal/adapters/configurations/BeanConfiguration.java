package br.com.heycristhian.hexagonal.adapters.configurations;

import br.com.heycristhian.hexagonal.adapters.outbounds.persistence.UserMysqlRepository;
import br.com.heycristhian.hexagonal.application.ports.messaging.NotificationProducer;
import br.com.heycristhian.hexagonal.application.ports.persistence.UserRepository;
import br.com.heycristhian.hexagonal.application.usecases.FindUser;
import br.com.heycristhian.hexagonal.application.usecases.SaveUser;
import br.com.heycristhian.hexagonal.application.usecases.ShowNotification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new UserMysqlRepository();
    }

    @Bean
    public FindUser findUser(UserRepository userRepository) {
        return new FindUser(userRepository);
    }

    @Bean
    public SaveUser saveUser(UserRepository userRepository, NotificationProducer notificationProducer) {
        return new SaveUser(userRepository, notificationProducer);
    }

    @Bean
    public ShowNotification showNotification() {
        return new ShowNotification();
    }
}
