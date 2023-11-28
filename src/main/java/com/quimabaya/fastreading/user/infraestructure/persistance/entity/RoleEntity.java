package com.quimabaya.fastreading.user.infraestructure.persistance.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;



@Entity
@Table(name = "tm_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     
    private Long rol_id;

    @Column(name = "rol_name")
    private String name;

    @Column(name = "rol_descripcion")
    private String description;

}