package studymore.springbootmapper.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studymore.springbootmapper.convert.UserDTOConverter;
import studymore.springbootmapper.dto.UserDTO;
import studymore.springbootmapper.model.User;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserDTOConverter userDTOConverter;

    public UserDTO getUser() {
        // Mock db column
        User user = new User();

        user.setId("1234");
        user.setEmail("an@gmail.com");
        user.setFirstName("An");
        user.setLastName("Nguyen");
        user.setPassword("password");

        UserDTO userDTO = userDTOConverter.convertUserToUserDTO(user);
        return userDTO;
    }
}
