package kg.java.ticket.controllers.v1;

import kg.java.ticket.core.contracts.facades.UserFacade;
import kg.java.ticket.core.exceptions.EntityDuplicateExceptions;
import kg.java.ticket.core.exceptions.EntityNotFoundException;
import kg.java.ticket.core.models.dtos.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody CreateUserDto model){
        try {
            return ResponseEntity.ok(userFacade.register(model));
        }
        catch (EntityDuplicateExceptions e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<UserDto> update(@RequestBody UpdateUserDto model){
        try {
            return ResponseEntity.ok(userFacade.update(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteUserDto model){
        try {
            return ResponseEntity.ok(userFacade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<UserDto> getById(@RequestBody FindByIdUserDto model){
        try {
            return ResponseEntity.ok(userFacade.getById(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


}
