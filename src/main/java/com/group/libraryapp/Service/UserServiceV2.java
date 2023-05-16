package com.group.libraryapp.Service;

import com.group.libraryapp.Repository.UserRepository;
import com.group.libraryapp.Service.dto.UserCreateDTO;
import com.group.libraryapp.Service.dto.UserDTO;
import com.group.libraryapp.Service.dto.UserUpdateDTO;
import com.group.libraryapp.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateDTO userCreateDTO) {
        User u = userRepository.save(new User(userCreateDTO.getName(), userCreateDTO.getAge()));
    }

    @Transactional(readOnly = true)
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void updateUser(UserUpdateDTO updateDTO) {
        User user = userRepository.findById(updateDTO.getId()).orElseThrow(IllegalArgumentException::new);

        user.setName(updateDTO.getName());
    }
    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);

    }
}
