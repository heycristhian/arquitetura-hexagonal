package br.com.heycristhian.hexagonal.adapters.mappers;

import br.com.heycristhian.hexagonal.adapters.inbounds.rest.dtos.request.UserRequest;
import br.com.heycristhian.hexagonal.adapters.inbounds.rest.dtos.response.UserResponse;
import br.com.heycristhian.hexagonal.application.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);
}
