package com.technicalEvaluation.expense.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.technicalEvaluation.expense.entities.Expense;



@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
	@Query (nativeQuery = true, value ="select * from Expense where team_id = :id order by date desc")
	List<Expense> findByTeamId(@Param("id") Long id); 
	
	@Query (nativeQuery = true, value ="select * from Expense where user_id = :id")
	List<Expense> findByUserId(@Param("id") Long id); 
}
