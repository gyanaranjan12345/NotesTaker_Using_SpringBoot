package com.enotes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.enotes.entity.UserDtls;
import com.enotes.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	public UserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDtls user=userRepo.findByEmail(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User Not Exist");
		}else
		{
			CustomUserDtls customUserDtls =new CustomUserDtls(user);
			return customUserDtls;
		}
			
		
	}

}