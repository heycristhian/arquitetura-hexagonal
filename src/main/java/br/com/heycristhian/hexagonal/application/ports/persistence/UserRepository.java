package br.com.heycristhian.hexagonal.application.ports.persistence;

import br.com.heycristhian.hexagonal.application.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(final Long id);
    User save(User user);
}
