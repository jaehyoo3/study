package com.group.libraryapp.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<UserLoanHistory> userLoanHistoryList = new ArrayList<>();

    public User(String name, Integer age) {

        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }

        this.name = name;
        this.age = age;
    }

    protected User() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
