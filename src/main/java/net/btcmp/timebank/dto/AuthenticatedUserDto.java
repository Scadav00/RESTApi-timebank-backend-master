package net.btcmp.timebank.dto;

import net.btcmp.timebank.entity.User;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AuthenticatedUserDto implements UserDetails, CredentialsContainer {
    private Long id;

    private String username;

    private String phone;

    private String password;

    public AuthenticatedUserDto() {
        // empty constructor
    }

    public AuthenticatedUserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.password = user.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    /**
     * Return empty list of authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }
}
