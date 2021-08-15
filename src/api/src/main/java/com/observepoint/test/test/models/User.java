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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
     * The username (String).
     */
    @Column(unique = true)
    private String username;

    /**
     * The primaryemail (String).
     */
    @Column(unique = true)
    private String primaryemail;

    /**
     * The password (String).
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

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

    public User(String firstname, String lastname, String username, String primaryemail, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.primaryemail = primaryemail;
        this.password = password;
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
     * Getter for username
     *
     * @return the username (String) lowercase
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter for username
     *
     * @param username the new username (String)
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for primaryemail
     *
     * @return the primaryemail (String) lowercase
     */
    public String getPrimaryemail() {
        return primaryemail;
    }

    /**
     * setter for primaryemail
     *
     * @param primaryemail the new primaryemail (String)
     */
    public void setPrimaryemail(String primaryemail) {
        this.primaryemail = primaryemail;
    }

    /**
     * Getter for password
     *
     * @return the password (String)
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for password
     *
     * @param password the new password (String)
     */
    public void setPassword(String password) {
        this.password = password;
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
