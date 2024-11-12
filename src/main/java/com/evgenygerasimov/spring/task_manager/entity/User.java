package com.evgenygerasimov.spring.task_manager.entity;

import com.evgenygerasimov.spring.task_manager.validation.CheckEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
@ToString
public class User implements UserDetails {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(System.currentTimeMillis());

    @Column(name = "id")
    private long id = ID_GENERATOR.incrementAndGet();
    @Id
    @Column(name = "username")
    @Pattern(regexp = "[a-z]{2,50}", message = "The name is required field and must be a minimum of 2 characters and a maximum of 50 characters!")
    private String username;
    @NotBlank(message = "Don not use the blanks")
    @Size(min = 4, max = 100, message = "The password must be a minimum of 4 characters and a maximum of 100 characters!")
    private String password;
    @Column(name = "enabled")
    private int enabled = 1;
    @Column(name = "email")
    @CheckEmail
    private String email;
    @Column(name = "phone_number")
    @Pattern(regexp = "\\+7\\d{10}", message = "The phone number is required field! Please use the pattern: +7XXXXXXXXXX")
    private String phoneNumber;
    @Column(name = "role")
    private String role;
    @OneToMany(mappedBy = "user")
    private Set<Task> tasks;

    private transient Map<String, String> roles;

    public User() {
        roles = new HashMap<>();
        roles.put("ROLE_CUSTOMER", "CUSTOMER");
        roles.put("ROLE_EXECUTOR", "EXECUTOR");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority(role));
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
}
