package com.kma.GameAndroid.entity;

import com.kma.GameAndroid.enumCustom.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;
    @Column(columnDefinition = "double precision default 0.0")
    private Double time1 = 0.0;
    @Column(columnDefinition = "double precision default 0.0")
    private Double time2 = 0.0;
    @Column(columnDefinition = "double precision default 0.0")
    private Double time3 = 0.0;
    @Column(columnDefinition = "double precision default 0.0")
    private Double time4 = 0.0;
    @Column(columnDefinition = "double precision default 0.0")
    private Double time5 = 0.0;
    @Column(columnDefinition = "double precision default 0.0")
    private Double time6 = 0.0;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
