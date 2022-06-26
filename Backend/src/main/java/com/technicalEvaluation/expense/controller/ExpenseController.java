package com.technicalEvaluation.expense.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.technicalEvaluation.expense.entities.Expense;
import com.technicalEvaluation.expense.services.ExpenseService;


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
