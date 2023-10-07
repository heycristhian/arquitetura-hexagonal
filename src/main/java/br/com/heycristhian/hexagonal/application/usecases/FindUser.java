package br.com.heycristhian.hexagonal.application.usecases;

import br.com.heycristhian.hexagonal.application.exceptions.ObjectNotFoundException;
import br.com.heycristhian.hexagonal.application.models.User;
import br.com.heycristhian.hexagonal.application.ports.persistence.UserRepository;

public class FindUser {

    private final UserRepository userRepository;

    public FindUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found with id: " + id));
    }
}
