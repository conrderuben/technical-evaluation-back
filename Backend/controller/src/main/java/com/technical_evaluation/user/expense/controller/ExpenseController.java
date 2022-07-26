package com.technical_evaluation.user.expense.controller;


import com.technical_evaluation.expense.entities.Expense;
import com.technical_evaluation.user.expense.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public List<Expense> getAllExpenses(){
		return expenseService.getAllExpenses(1L);
	}
	
	@GetMapping("/balance")
	public ArrayList<HashMap> getBalance(){
		return expenseService.getBalance(1L);
	}
	
	@PostMapping("/")
	public Expense createExpense(@RequestBody Expense expense) {
		return expenseService.createExpense(expense);
		
	}
}
