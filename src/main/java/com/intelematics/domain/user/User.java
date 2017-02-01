package com.intelematics.domain.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Ian on 2/26/2016.
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="password", nullable=false)
    @NotNull(message = "Must have a password")
    @Size(min=0, max=20)
    private String password;

    @Column(name="username", nullable=false)
    @NotNull(message = "Must have a username")
    @Size(min=0, max=20)
    private String username;

    @Column(name="first_name", nullable=false)
    @NotNull(message = "Must have a first name")
    @Size(min=0, max=50)
    private String firstName;

    @Column(name="last_name", nullable=false)
    @NotNull(message = "Must have a last name")
    @Size(min=0, max=50)
    private String lastName;

    public User() {}

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
