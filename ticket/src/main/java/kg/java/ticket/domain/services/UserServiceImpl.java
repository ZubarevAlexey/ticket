package kg.java.ticket.domain.services;

import kg.java.ticket.core.contracts.services.UserService;
import kg.java.ticket.core.exceptions.EntityDuplicateExceptions;
import kg.java.ticket.core.exceptions.EntityNotFoundException;
import kg.java.ticket.core.mappers.UserMapper;
import kg.java.ticket.core.models.dtos.*;
import kg.java.ticket.data.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto register(CreateUserDto model) throws EntityDuplicateExceptions {
        var user = userRepository.findUserEntityByFirstName(model.getFirstName());
        if (user.isPresent())throw new EntityDuplicateExceptions();
        var entity = userMapper.fromDomain(model);
        return userMapper.toDomain(entity);
    }

    @Override
    public UserDto update(UpdateUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = user.toBuilder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
        userRepository.save(entity);
        return userMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        userRepository.delete(user);
        return HttpStatus.OK;
    }

    @Override
    public UserDto getById(FindByIdUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return userMapper.toDomain(user);
    }
}
