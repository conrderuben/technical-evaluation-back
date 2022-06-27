package com.technicalEvaluation.expense.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.technicalEvaluation.expense.entities.Expense;
import com.technicalEvaluation.expense.repository.ExpenseRepository;
import com.technicalEvaluation.user.entities.User;
import com.technicalEvaluation.user.repository.UserRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<Expense> getAllExpenses(@RequestParam Long id) {
		return expenseRepository.findByTeamId(id);
	}

	public ArrayList<HashMap> getBalance(@RequestParam Long id) {

		Double totalAmount = 0.00;
		Double userAmount = 0.00;
		ArrayList<HashMap> totalBalance = new ArrayList();

		List<Expense> expenses = expenseRepository.findAll();
		List<User> users = userRepository.findUsersByTeamId(id);

		totalAmount = calculateTotalAmount(expenses);
		
		for (User user : users) {
			HashMap<String, Object> userBalance = new HashMap<>();

			userAmount = 0.00;

			List<Expense> userExpenseList = expenseRepository.findByUserId(user.getId());

			userAmount = calculateUserAmount(userExpenseList);
			
			double difference = calculateDiference(totalAmount, users, userAmount);

			userBalance.put("id", user.getId());
			userBalance.put("amount", difference);
			totalBalance.add(userBalance);
		}
		return totalBalance;
	}
	
	public double calculateTotalAmount(List<Expense> expenses) {
		Double totalAmount = 0.00;
		
		for (Expense e : expenses) {
			totalAmount += e.getAmount();
		}
		
		return totalAmount;
	}
	
	public double calculateUserAmount(List<Expense> userExpenseList) {
		Double userAmount = 0.00;
		
		for (Expense e : userExpenseList) {
			userAmount += e.getAmount();
		}
		
		return userAmount;
	}
	
	public double calculateDiference(Double totalAmount, List<User> users, Double userAmount ) {
		
		return Math.round(((-totalAmount / users.size()) + userAmount) * 100.00) / 100.00;
	}

	public Expense createExpense(@RequestParam Expense expense) {
		return expenseRepository.save(expense);
	}

}
