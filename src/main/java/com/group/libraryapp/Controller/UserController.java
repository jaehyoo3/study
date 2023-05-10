package com.group.libraryapp.Controller;

import com.group.libraryapp.Service.dto.UserCreateDTO;
import com.group.libraryapp.Service.dto.UserDTO;
import com.group.libraryapp.Service.dto.UserUpdateDTO;
import com.group.libraryapp.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController

public class UserController {

    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateDTO requset) {
        String sql = "INSERT INTO user(name, age) VALUES(?, ?)";
        jdbcTemplate.update(sql, requset.getName(), requset.getAge());
    }

    @GetMapping("/user")
    public List<UserDTO> getUsers() {
        String sql = "SELECT * FROM user";
       return jdbcTemplate.query(sql, (rs, rowNum) -> {
           long id = rs.getLong("id");
           String name = rs.getString("name");
           int age = rs.getInt("age");
           return new UserDTO(id, name, age);
       });
    }
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateDTO updateDTO) {
        String readSql = "SELECT * FROM user WHERE id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, updateDTO.getId()).isEmpty();

        if(isUserNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "UPDATE user SET name =? WHERE id = ?";
        jdbcTemplate.update(sql, updateDTO.getName(), updateDTO.getId());
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        String readSql = "SELECT * FROM user WHERE name = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name.isEmpty();

        if(isUserNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
}
