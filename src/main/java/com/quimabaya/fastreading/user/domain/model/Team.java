package com.quimabaya.fastreading.user.domain.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
	@JsonIgnore
	private Long team_id;
    private String teamName; 
    private String teamDescription; 
    private Short teamStatus; 
    private Date teamCreatedOn; 
    private Date teamUpdatedOn; 

}
