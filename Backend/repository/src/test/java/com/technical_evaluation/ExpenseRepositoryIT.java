package com.technical_evaluation;

import com.technical_evaluation.expense.entities.Expense;
import com.technical_evaluation.expense.repository.ExpenseRepository;
import com.technical_evaluation.team.entities.Team;
import com.technical_evaluation.team.repository.TeamRepository;
import com.technical_evaluation.user.entities.User;
import com.technical_evaluation.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ExpenseRepositoryIT {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void should_giveExpense_whenFindById() {
        Expense expense  = new Expense(15D, "Cinema", new Date(), new User("Ruben"), new Team());
        expenseRepository.save(expense);
        Expense expenseDB = expenseRepository.findById(expense.getId()).get();
        assertNotNull(expenseDB);
    }

    @Test
    void should_deleteExpense() {
        Expense expense  = new Expense(15D, "Cinema", new Date(), new User("Ruben"), new Team());
        expenseRepository.save(expense);
        expenseRepository.delete(expense);
        Optional<Expense> expenseDeleted = expenseRepository.findById(expense.getId());
        assertFalse(expenseDeleted.isPresent());
    }

    @Test
    void should_returnExpense_findByTeamId() {
        Team team = new Team();
        teamRepository.save(team);
        User user = new User("Ruben");
        userRepository.save(user);
        Expense expense  = new Expense(15D, "Cinema", new Date(), user, team);
        expenseRepository.save(expense);
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(expense);
        List<Expense> expenseListDB = expenseRepository.findByTeamId(expense.getTeam().getId());
        assertEquals(expenseList, expenseListDB);
    }
}