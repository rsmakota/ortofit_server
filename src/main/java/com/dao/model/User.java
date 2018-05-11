package com.dao.model;

import com.Serialize.GroupSerialie;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2016-05-06
 * Copyright  "Commercegate LTD"
 */
@Entity
@Table(name = "users", schema = "public", catalog = "ortofit")
public class User implements Serializable {

    @Id
    @GenericGenerator(
            name = "idUserGen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "users_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "idUserGen")
    private Integer id;

    @JsonIgnoreProperties({"users"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_groups", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private Set<Group> groups;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "username_canonical")
    private String usernameCanonical;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name = "email_canonical")
    private String emailCanonical;

    @Column(name = "enabled")
    private Boolean enabled = true;

    @JsonIgnore
    @Column(name = "salt")
    private String salt;

    @JsonIgnore
    @Column(name = "password")
    private String password;

//    @JsonIgnore
    @Column(name = "last_login")
    private Timestamp lastLogin;

    @Column(name = "locked")
    private Boolean locked = false;

    @Column(name = "expired")
    private Boolean expired = false;

    @JsonIgnore
    @Column(name = "expires_at")
    private Timestamp expiresAt;

    @Column(name = "password_requested_at")
    @JsonIgnore
    private Timestamp passwordRequestedAt;

    @JsonIgnore
    @Column(name = "confirmation_token")
    private String confirmationToken;

    @JsonIgnore
    @Column(name = "credentials_expired")
    private Boolean credentialsExpired = false;

    @JsonIgnore
    @Column(name = "credentials_expire_at")
    private Timestamp credentialsExpireAt;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Column(name = "roles")
    private String rolesStr = "";

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    public User() {}

    public String getRolesStr() {
        return rolesStr;
    }

    public void setRolesStr(String rolesStr) {
        this.rolesStr = rolesStr;
    }

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.usernameCanonical = username;
        this.password = password;
        this.roles    = roles;
    }

    public Integer getId() {
        return id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public Timestamp getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Timestamp expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Timestamp getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Timestamp passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public Timestamp getCredentialsExpireAt() {
        return credentialsExpireAt;
    }

    public void setCredentialsExpireAt(Timestamp credentialsExpireAt) {
        this.credentialsExpireAt = credentialsExpireAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
