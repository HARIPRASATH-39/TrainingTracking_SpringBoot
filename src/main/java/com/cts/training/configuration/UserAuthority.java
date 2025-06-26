package com.cts.training.configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cts.training.entity.Employees;
 

 
public class UserAuthority implements UserDetails {
	private String name;
	private String password;
	private List<GrantedAuthority> authorities;
	public UserAuthority(Employees employee)
	{
		name=employee.getEmployeeName();
		password=employee.getEmployeePassword();
		authorities= Arrays.stream(employee.getEmployeeGrade().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println(authorities);
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return name;
	}
}