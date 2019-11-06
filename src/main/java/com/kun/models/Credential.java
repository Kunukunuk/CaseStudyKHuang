package com.kun.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "credentials")
public class Credential {

    @Id
    @Email
    @NotEmpty(message = "empty username")
    @Column(name = "username", nullable = false)
    private String username;

    @NotEmpty(message = "empty password")
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "credential")
    @Column(name = "authority")
    private Set<Authority> authorities = new HashSet<Authority>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    private User user;

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

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
