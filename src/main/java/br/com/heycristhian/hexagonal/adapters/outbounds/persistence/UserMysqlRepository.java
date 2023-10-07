package br.com.heycristhian.hexagonal.adapters.outbounds.persistence;

import br.com.heycristhian.hexagonal.application.models.User;
import br.com.heycristhian.hexagonal.application.ports.persistence.UserRepository;

import java.util.Optional;

public class UserMysqlRepository implements UserRepository {
    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(new User(1L, "heycristhian", "123"));
    }

    @Override
    public User save(User user) {
        return new User(1L, "heycristhian", "123");
    }
}
