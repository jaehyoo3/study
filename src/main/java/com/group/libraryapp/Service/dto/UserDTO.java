package com.group.libraryapp.Service.dto;

import com.group.libraryapp.domain.User;

public class UserDTO {
    private long id;
    private String name;
    private Integer age;

    public UserDTO(long id, User user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.age = user.getAge();
        this.name = user.getName();
    }
    public UserDTO(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
