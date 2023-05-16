package com.group.libraryapp.Service;

import com.group.libraryapp.Repository.UserJdbcRepository;
import com.group.libraryapp.Repository.UserRepository;
import com.group.libraryapp.Service.dto.UserCreateDTO;
import com.group.libraryapp.Service.dto.UserDTO;
import com.group.libraryapp.Service.dto.UserUpdateDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceV1 {
    private final UserJdbcRepository userRepository;
    public UserServiceV1(UserJdbcRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void updateUser(UserUpdateDTO updateDTO) {

        if(userRepository.isUserNotExist(updateDTO.getId())) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUserName(updateDTO.getName(), updateDTO.getId());
    }
    public void deleteUser(String name) {
        if(userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }

    public void saveUser(UserCreateDTO requset) {
        userRepository.saveUser(requset.getName(), requset.getAge());
    }

    public List<UserDTO> getUser() {
       return userRepository.getUser();
    }
}
