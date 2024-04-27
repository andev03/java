package studymore.springbootmapper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studymore.springbootmapper.dto.UserDTO;
import studymore.springbootmapper.service.UserService;

@RestController
@Slf4j
@RequestMapping("api/v1")
public class MainRestController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public UserDTO getUser() {
        return userService.getUser();
    }
}
