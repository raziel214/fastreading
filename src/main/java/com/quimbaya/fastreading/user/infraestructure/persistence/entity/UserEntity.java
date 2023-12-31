package com.quimbaya.fastreading.user.infraestructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quimbaya.fastreading.ciudad.infraestructure.persistence.entity.CiudadEntity;
import com.quimbaya.fastreading.role.infrastructure.persistence.entity.RoleEntity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tm_users")  // Asegúrate de que el nombre de la tabla sea correcto
public class UserEntity {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userLastName;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @JsonIgnore
    @Column(nullable = false)
    private String userPass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity  userRole;

    @Column(nullable = false)
    private LocalDateTime dateCreation;

    @Column
    private LocalDateTime dateUpdate;

    @Column
    private LocalDateTime dateDelete;

    @Column(nullable = false)
    private Short state;

    @Column(nullable = false)
    private Short first;

    @Column(nullable = false)
    private Integer recoveryPass;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad_id")
    private CiudadEntity  userCiudad;

}
