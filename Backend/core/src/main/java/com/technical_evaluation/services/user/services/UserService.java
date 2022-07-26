package com.technical_evaluation.services.user.services;

import com.technical_evaluation.team.entities.Team;
import com.technical_evaluation.team.repository.TeamRepository;
import com.technical_evaluation.user.entities.User;
import com.technical_evaluation.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
