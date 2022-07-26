package com.technical_evaluation.expense.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.technical_evaluation.team.entities.Team;
import com.technical_evaluation.user.entities.User;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double amount;
	private String description;
	private Date date;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private User user;

	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Team team;

	public Expense(Double amount, String description, Date date, User user, Team team) {
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.user = user;
		this.team = team;
	}

	public Expense() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", amount=" + amount + ", description=" + description + ", date=" + date
				+ ", user=" + user + ", team=" + team + "]";
	}

}
