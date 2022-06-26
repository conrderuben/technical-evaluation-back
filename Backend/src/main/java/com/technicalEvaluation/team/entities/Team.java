package com.technicalEvaluation.team.entities;

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
import com.technicalEvaluation.user.entities.User;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "team")
	private Collection<Expense> expenses;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "teams")
	private Collection<User> users;
	
	public Team() {
		this.expenses =new ArrayList<Expense>();
		this.users =new ArrayList<User>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Collection<Expense> expenses) {
		this.expenses = expenses;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", expenses=" + expenses + ", users=" + users + "]";
	}
	
	
	
}
