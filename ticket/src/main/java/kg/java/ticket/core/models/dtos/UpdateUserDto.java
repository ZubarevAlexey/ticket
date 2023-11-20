package kg.java.ticket.core.models.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateUserDto {
    private Long id;
    private String firstName;
    private String lastName;

}
