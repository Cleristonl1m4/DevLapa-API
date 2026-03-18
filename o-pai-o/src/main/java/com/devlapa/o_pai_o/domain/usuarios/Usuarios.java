package com.devlapa.o_pai_o.domain.usuarios;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuarios implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String nome;


    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(columnDefinition = "VARCHAR(100) DEFAULT 'USUARIO'")
    private String perfil;

    private LocalDateTime dataModificacao;


    @Column(nullable = false)
    private Boolean ativo;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now();
        if (this.ativo == null) this.ativo = true;
        if (this.perfil == null) this.perfil = "USUARIO";
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.perfil != null && this.perfil.equalsIgnoreCase("ADMIN")) {

            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_GERENTE"));
        }

        if (this.perfil != null && this.perfil.equalsIgnoreCase("GERENTE")) {
            return List.of(new SimpleGrantedAuthority("ROLE_GERENTE"));
        }

        return List.of(new SimpleGrantedAuthority("ROLE_VISUALIZADOR"));
    }

    @Override
    public String getPassword() {
        return hash;
    }

    @Override
    public String getUsername() {
        return login;
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
        return ativo != null ? ativo : true;
    }
}
