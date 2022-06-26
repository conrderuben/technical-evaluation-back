package com.technicalEvaluation.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technicalEvaluation.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query (nativeQuery = true, value ="select * from user where id in (select users_id from user_teams where teams_id = :id)")
	List<User> findUsersByTeamId(@Param("id") Long id);
	

}
