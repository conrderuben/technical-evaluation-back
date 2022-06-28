package com.technicalEvaluation.expense.services;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.technicalEvaluation.expense.entities.Expense;
import com.technicalEvaluation.expense.repository.ExpenseRepository;
import com.technicalEvaluation.team.entities.Team;
import com.technicalEvaluation.user.entities.User;
import com.technicalEvaluation.user.repository.UserRepository;

class ExpenseServiceTest {

	@Mock
	private ExpenseRepository expenseRepository;
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private ExpenseService expenseService;
	
	private Expense expense;
	private User userA;
	private Team team;
	
	private Expense expense2;
	private User userB;
	
	private ArrayList<HashMap> result = new ArrayList<HashMap>();
	private HashMap<String, Object> userBalanceA = new HashMap<String, Object>();
	private HashMap<String, Object> userBalanceB= new HashMap<String, Object>();
	
	@BeforeEach
	void getBalance() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		team = new Team();
		team.setId(1L);
		
		userA = new User();
		userA.setId(1L);
		userA.setName("test");
		userA.addTeam(team);
		
		userB = new User();
		userB.setId(2L);
		userB.setName("test");
		userB.addTeam(team);
		
		expense = new Expense();
		expense.setAmount(100D);
		expense.setDate(new Date());
		expense.setDescription("test");
		expense.setId(1L);
		expense.setTeam(team);
		expense.setUser(userA);
		
		userBalanceA.put("id", 1L);
		userBalanceA.put("amount", 50D);
		userBalanceB.put("id", 2L);
		userBalanceB.put("amount", -50D);
		result.add(userBalanceA);
		result.add(userBalanceB);
		
		
	}

	@Test
	void should_return_the_balance_given_two_users_and_one_expense() {
		when(expenseRepository.findAll()).thenReturn(Arrays.asList(expense));
		when(userRepository.findUsersByTeamId(any(Long.class))).thenReturn(Arrays.asList(userA,userB));
		when(expenseRepository.findByUserId(1L)).thenReturn(Arrays.asList(expense));
		when(expenseRepository.findByUserId(2L)).thenReturn(Arrays.asList());
		assertEquals(result, expenseService.getBalance(1L));
	}

}