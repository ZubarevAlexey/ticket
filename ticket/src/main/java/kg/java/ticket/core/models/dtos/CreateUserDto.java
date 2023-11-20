package kg.java.ticket.core.models.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateUserDto {
    private String firstName;
    private String lastName;

}
