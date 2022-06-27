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
import com.technicalEvaluation.expense.services.ExpenseService;
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
	private User user;
	private Team team;
	
	private Expense expense2;
	private User user2;
	
	
	private ArrayList<HashMap> result = new ArrayList<HashMap>();
	private HashMap<String, Object> map = new HashMap<String, Object>();
	private HashMap<String, Object> map2 = new HashMap<String, Object>();
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		team = new Team();
		team.setId(1L);
		
		user = new User();
		user.setId(1L);
		user.setName("test");
		user.addTeam(team);
		
		user2 = new User();
		user2.setId(2L);
		user2.setName("test");
		user2.addTeam(team);
		
		expense = new Expense();
		expense.setAmount(100D);
		expense.setDate(new Date());
		expense.setDescription("test");
		expense.setId(1L);
		expense.setTeam(team);
		expense.setUser(user);
		
//		expense2 = new Expense();
//		expense2.setAmount(100D);
//		expense2.setDate(new Date());
//		expense2.setDescription("test");
//		expense2.setId(1L);
//		expense2.setTeam(team);
//		expense2.setUser(user);
		
		map.put("id", 1L);
		map.put("amount", 50D);
		map2.put("id", 2L);
		map2.put("amount", -50D);
		result.add(map);
		result.add(map2);
		
		
	}

	@Test
	void test() {
		when(expenseRepository.findAll()).thenReturn(Arrays.asList(expense));
		when(userRepository.findUsersByTeamId(any(Long.class))).thenReturn(Arrays.asList(user,user2));
//		when(expenseRepository.findByUserId(any(Long.class))).thenReturn(Arrays.asList(expense));
		when(expenseRepository.findByUserId(1L)).thenReturn(Arrays.asList(expense));
		when(expenseRepository.findByUserId(1L)).thenReturn(Arrays.asList(expense));
		assertEquals(result, expenseService.getBalance(1L));
	}

}