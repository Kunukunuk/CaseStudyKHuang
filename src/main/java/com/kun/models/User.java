package com.kun.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private int userid;

    @NotEmpty(message = "Can not be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "Can not be empty")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Address> addresses = new HashSet<Address>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reserve_id")
    private Set<Reserve> reserves = new HashSet<Reserve>();

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    //    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
//    }
}
