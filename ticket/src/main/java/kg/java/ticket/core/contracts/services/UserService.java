package kg.java.ticket.core.contracts.services;

import kg.java.ticket.core.exceptions.EntityDuplicateExceptions;
import kg.java.ticket.core.exceptions.EntityNotFoundException;
import kg.java.ticket.core.models.dtos.*;
import org.springframework.http.HttpStatus;

public interface UserService {

    UserDto register(CreateUserDto model)throws EntityDuplicateExceptions;
    UserDto update(UpdateUserDto model)throws EntityNotFoundException;

    HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException;
    UserDto getById(FindByIdUserDto model) throws EntityNotFoundException;
}
