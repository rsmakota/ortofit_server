package com.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="user_id")
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

    @JsonIgnore
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

    @JsonIgnore
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (id != null ? !id.equals(user.id) : user.id != null) return false;
//        if (username != null ? !username.equals(user.username) : user.username != null) return false;
//        if (usernameCanonical != null ? !usernameCanonical.equals(user.usernameCanonical) : user.usernameCanonical != null)
//            return false;
//        if (email != null ? !email.equals(user.email) : user.email != null) return false;
//        if (emailCanonical != null ? !emailCanonical.equals(user.emailCanonical) : user.emailCanonical != null)
//            return false;
//        if (enabled != null ? !enabled.equals(user.enabled) : user.enabled != null) return false;
//        if (salt != null ? !salt.equals(user.salt) : user.salt != null) return false;
//        if (password != null ? !password.equals(user.password) : user.password != null) return false;
//        if (lastLogin != null ? !lastLogin.equals(user.lastLogin) : user.lastLogin != null) return false;
//        if (locked != null ? !locked.equals(user.locked) : user.locked != null) return false;
//        if (expired != null ? !expired.equals(user.expired) : user.expired != null) return false;
//        if (expiresAt != null ? !expiresAt.equals(user.expiresAt) : user.expiresAt != null) return false;
//        if (confirmationToken != null ? !confirmationToken.equals(user.confirmationToken) : user.confirmationToken != null)
//            return false;
//        if (passwordRequestedAt != null ? !passwordRequestedAt.equals(user.passwordRequestedAt) : user.passwordRequestedAt != null)
//            return false;
//        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
//        if (credentialsExpired != null ? !credentialsExpired.equals(user.credentialsExpired) : user.credentialsExpired != null)
//            return false;
//        if (credentialsExpireAt != null ? !credentialsExpireAt.equals(user.credentialsExpireAt) : user.credentialsExpireAt != null)
//            return false;
//        if (name != null ? !name.equals(user.name) : user.name != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + (usernameCanonical != null ? usernameCanonical.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (emailCanonical != null ? emailCanonical.hashCode() : 0);
//        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
//        result = 31 * result + (salt != null ? salt.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
//        result = 31 * result + (locked != null ? locked.hashCode() : 0);
//        result = 31 * result + (expired != null ? expired.hashCode() : 0);
//        result = 31 * result + (expiresAt != null ? expiresAt.hashCode() : 0);
//        result = 31 * result + (confirmationToken != null ? confirmationToken.hashCode() : 0);
//        result = 31 * result + (passwordRequestedAt != null ? passwordRequestedAt.hashCode() : 0);
//        result = 31 * result + (roles != null ? roles.hashCode() : 0);
//        result = 31 * result + (credentialsExpired != null ? credentialsExpired.hashCode() : 0);
//        result = 31 * result + (credentialsExpireAt != null ? credentialsExpireAt.hashCode() : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }
}
