package kg.java.ticket.domain.facades;

import kg.java.ticket.core.contracts.facades.UserFacade;
import kg.java.ticket.core.contracts.services.UserService;
import kg.java.ticket.core.exceptions.EntityDuplicateExceptions;
import kg.java.ticket.core.exceptions.EntityNotFoundException;
import kg.java.ticket.core.models.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto register(CreateUserDto model) throws EntityDuplicateExceptions {
        return userService.register(model);
    }

    @Override
    public UserDto update(UpdateUserDto model) throws EntityNotFoundException {
        return userService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException {
        return userService.delete(model);
    }

    @Override
    public UserDto getById(FindByIdUserDto model) throws EntityNotFoundException {
        return userService.getById(model);
    }
}
