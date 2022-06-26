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

		// Calculated the global amount for all expenses
		for (Expense expense : expenses) {
			totalAmount += expense.getAmount();
		}

		for (User user : users) {
			HashMap<String, Object> userBalance = new HashMap<>();

			// Returning the userAmount to 0 on each user
			userAmount = 0.00;

			// Getting all the expenses for each user
			List<Expense> userExpenseList = expenseRepository.findByUserId(user.getId());

			// Calculating the amount of the user
			for (Expense e : userExpenseList) {
				userAmount += e.getAmount();
			}

			// Calculating the difference
			double difference = Math.round(((-totalAmount / users.size()) + userAmount) * 100.00) / 100.00;

			// Adding the user balance to the total balance
			userBalance.put("id", user.getId());
			userBalance.put("amount", difference);
			totalBalance.add(userBalance);
		}
		return totalBalance;
	}

	public Expense createExpense(@RequestParam Expense expense) {
		return expenseRepository.save(expense);
	}

}
