package com.group.libraryapp.Controller;

import com.group.libraryapp.Service.UserServiceV1;
import com.group.libraryapp.Service.UserServiceV2;
import com.group.libraryapp.Service.dto.UserCreateDTO;
import com.group.libraryapp.Service.dto.UserDTO;
import com.group.libraryapp.Service.dto.UserUpdateDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class  UserController {
    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateDTO requset) {
        userService.saveUser(requset);
    }

    @GetMapping("/user")
    public List<UserDTO> getUsers() {
       return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateDTO updateDTO) {
        userService.updateUser(updateDTO);
    }
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }
}
