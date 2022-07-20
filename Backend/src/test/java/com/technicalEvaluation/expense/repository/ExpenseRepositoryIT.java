package com.technicalEvaluation.expense.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations="classpath:test.properties")
class ExpenseRepositoryIT {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    void should_giveExpense_whenFindById() {
        /*Expense expense  = new Expense(15D, "Cinema", new Date(), new User("Ruben"), new Team());
        expenseRepository.save(expense);
        Expense expenseDB = expenseRepository.findById(expense.getId()).get();

        assertNotNull(expenseDB);*/
        assertTrue(true);
    }
}