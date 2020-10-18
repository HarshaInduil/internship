package com.learnspring.studentmanage.studentmanage.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Cannot be Null")
    @NotEmpty(message = "Cannot be empty")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Cannot be Null")
    @NotEmpty(message = "Cannot be empty")
    @NotBlank(message = "cannot be black")
    @Min(20)
    @Column(name = "age")
    private int age;

    @NotNull(message = "Cannot be Null")
    @NotNull(message = "Cannot be empty")
    @NotBlank(message = "cannot be black")
    @Email(message = "this is email")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Cannot be Null")
    @NotEmpty(message = "Cannot be empty")
    @Column(name = "mobile")
    private String mobile;

    @ManyToOne
    @JoinColumn(name = "classId")
    private Class clas;

    public Student() {
    }

    public Class getClas() {
        return clas;
    }

    public void setClas(Class clas) {
        this.clas = clas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
