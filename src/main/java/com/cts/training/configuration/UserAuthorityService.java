package com.cts.training.configuration;

 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cts.training.entity.Employees;
import com.cts.training.repository.EmployeeRepository;


 

 
@Component
public class UserAuthorityService implements UserDetailsService {
 
	@Autowired
	private EmployeeRepository employeeRepository;
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employees> employee=employeeRepository.findByEmployeeName(username);
		return employee.map(UserAuthority::new)
			.orElseThrow(()->new UsernameNotFoundException("user not found"));
	}
}