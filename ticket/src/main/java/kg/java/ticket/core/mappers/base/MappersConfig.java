package kg.java.ticket.core.mappers.base;

import kg.java.ticket.core.mappers.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {

    @Bean
    public UserMapper buildUserMapper(){
        return new UserMapper();
    }
}
