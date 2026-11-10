package com.miapp.finanzasPersonales.features.Users;

import com.miapp.finanzasPersonales.features.CommonFeatures.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "usuarios")
@Getter
@Setter

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name="password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Currency PredetCurrency;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private Timestamp createdAt;

    @PrePersist
    protected void create() {
        this.createdAt = Timestamp.from(Instant.now());
    }
}
