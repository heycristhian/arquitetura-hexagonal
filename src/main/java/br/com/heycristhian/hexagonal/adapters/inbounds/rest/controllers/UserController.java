package br.com.heycristhian.hexagonal.adapters.inbounds.rest.controllers;

import br.com.heycristhian.hexagonal.adapters.inbounds.messaging.NotificationRabbitConsumer;
import br.com.heycristhian.hexagonal.adapters.inbounds.rest.dtos.request.UserRequest;
import br.com.heycristhian.hexagonal.adapters.inbounds.rest.dtos.response.UserResponse;
import br.com.heycristhian.hexagonal.adapters.mappers.UserMapper;
import br.com.heycristhian.hexagonal.application.usecases.FindUser;
import br.com.heycristhian.hexagonal.application.usecases.SaveUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final SaveUser saveUser;
    private final FindUser findUser;
    private final NotificationRabbitConsumer notificationRabbitConsumer;

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        var user = UserMapper.INSTANCE.toUser(userRequest);
        var userResponse = UserMapper.INSTANCE.toUserResponse(saveUser.execute(user));

        URI uri = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(userResponse.getId()).toUri();

        return ResponseEntity.created(uri).body(userResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        var userResponse = UserMapper.INSTANCE.toUserResponse(
                findUser.execute(id)
        );

        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/messageConsumerSimulation")
    public ResponseEntity<Void> consumeMessage(@RequestBody String message) {
        notificationRabbitConsumer.listener(message);
        return ResponseEntity.ok().build();
    }

}
