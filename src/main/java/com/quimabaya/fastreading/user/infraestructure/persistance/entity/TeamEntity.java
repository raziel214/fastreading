package com.quimabaya.fastreading.user.infraestructure.persistance.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tm_team")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long team_id;
    
    @Column(name="team_name", nullable = false)
    private String teamName; 
    
    @Column(name="team_description",nullable = false)
    private String teamDescription; 
    
    @Column(name="team_status",nullable = false)
    private Short teamStatus; 
    
    @Column(name="team_createdOn",nullable = false)
    private LocalDateTime teamCreatedOn; 
    
    @Column(name="team_updatedOn")
    private LocalDateTime teamUpdatedOn; 
    


}

