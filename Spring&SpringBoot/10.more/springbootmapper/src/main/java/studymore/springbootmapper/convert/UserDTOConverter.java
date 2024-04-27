package studymore.springbootmapper.convert;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studymore.springbootmapper.dto.UserDTO;
import studymore.springbootmapper.model.User;


@Component
public class UserDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public User convertUserDTOToUser(User userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }
}
