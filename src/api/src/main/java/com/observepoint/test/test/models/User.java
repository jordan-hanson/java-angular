package com.observepoint.test.test.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// The entity allowing interaction with the User table
@Entity
@Table(name="users")
public class User {

    /**
     * The primary key (long) of the users table.
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    /**
     * The firstname (String).
     */
    @Column
    private String firstname;

    /**
     * The lastname (String).
     */
    @Column
    private String lastname;

    /**
     * The code (Number).
     */
    @Column
    private Integer code;

    /**
     * Part of the join relationship between user and role
     * connects users to the user role combination
     */
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "user",
            allowSetters = true)
    private Set<UserRoles> roles = new HashSet<>();

    /**
     * Default constructor used primarily by the JPA.
     */
    public User() {
    }

    public User(String firstname, String lastname, Integer code) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.code = code;
    }

    /**
     * Getter for userid
     *
     * @return the userid (long) of the user
     */
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    /**
     * Getter for firstname
     *
     * @return the firstname (String) lowercase
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * setter for firstname
     *
     * @param firstname the new firstname (String) converted to lowercase
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname.toLowerCase();
    }

    /**
     * Getter for lastname
     *
     * @return the lastname (String) lowercase
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * setter for lastname
     *
     * @param lastname the new lastname (String) converted to lowercase
     */
    public void setLastname(String lastname) {
        this.lastname = lastname.toLowerCase();
    }

    /**
     * Getter for code
     *
     * @return the code (Number) lowercase
     */
    public Integer getCode() {
        return code;
    }

    /**
     * setter for code
     *
     * @param code the new code (Number)
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Getter for user role combinations
     *
     * @return A list of user role combinations associated with this user
     */
    public Set<UserRoles> getRoles() {
        return roles;
    }

    /**
     * Setter for user role combinations
     *
     * @param roles Change the list of user role combinations associated with this user to this one
     */
    public void setRoles(Set<UserRoles> roles) {
        this.roles = roles;
    }

//    @JsonIgnore
//    public List<SimpleGrantedAuthority> getAuthority()
//    {
//        List<SimpleGrantedAuthority> rtnList = new ArrayList<>();
//
//        for (UserRoles r : this.roles)
//        {
//            String myRole = "ROLE" + r.getRole()
//                    .getName()
//                    .toUpperCase();
//            rtnList.add(new SimpleGrantedAuthority(myRole));
//        }
//        return rtnList;
//    }
}
