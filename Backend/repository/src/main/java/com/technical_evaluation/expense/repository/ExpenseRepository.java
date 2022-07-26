package com.technical_evaluation.expense.repository;

import com.technical_evaluation.expense.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
	@Query (nativeQuery = true, value ="select * from expense where team_id = :id order by date desc")
	List<Expense> findByTeamId(@Param("id") Long id);
	
	@Query (nativeQuery = true, value ="select * from expense where user_id = :id")
	List<Expense> findByUserId(@Param("id") Long id);
}
