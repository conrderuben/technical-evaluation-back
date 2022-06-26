package com.technicalEvaluation.user.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.technicalEvaluation.team.entities.Team;
import com.technicalEvaluation.team.repository.TeamRepository;
import com.technicalEvaluation.user.entities.User;
import com.technicalEvaluation.user.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	public List<User> getAllUsers(@RequestParam Long id){
		 return userRepository.findUsersByTeamId(id);
	}

	public User createUser(User user) {
		Team team = teamRepository.getById(1L);
		user.addTeam(team);
		
		return userRepository.save(user);
	}
	
}
