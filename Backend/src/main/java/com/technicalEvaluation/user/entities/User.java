package com.technicalEvaluation.user.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.technicalEvaluation.expense.entities.Expense;
import com.technicalEvaluation.team.entities.Team;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Collection<Expense> expenses;
	
	@JsonIgnore
	@ManyToMany
	private Collection<Team> teams;

	public User(String name) {
		this.name = name;
		this.teams = new ArrayList<Team>();
		this.expenses= new ArrayList<Expense>();
	}

	public User() {
		this.teams = new ArrayList<Team>();
		this.expenses= new ArrayList<Expense>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Collection<Expense> expenses) {
		this.expenses = expenses;
	}

	public Collection<Team> getTeams() {
		return teams;
	}

	public void setTeams(Collection<Team> teams) {
		this.teams = teams;
	}
	
	public void addTeam(Team team) {
		this.teams.add(team);
		team.getUsers().add(this);	
	}
	
	

	
	
	
	

	
	
	
	
}
