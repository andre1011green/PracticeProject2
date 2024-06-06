package com.Practice.PracticeProject.Service;

import com.Practice.PracticeProject.Model.User;
import com.Practice.PracticeProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("Username or Password not found!");
        }

        return new CustomUserDetails(user.getEmployeeid(), authorities(), user.isEnabled(), user.getUsername(),
                user.getJobtitle(), user.getFirstname(), user.getLastname(), user.getPhone(), user.getEmail(),
                user.getPassword(), user.getDatehired(), user.getDatefired());

    }

    public Collection<? extends GrantedAuthority> authorities()
    {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
    }
}
