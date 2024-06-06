package com.Practice.PracticeProject.Service;

import com.Practice.PracticeProject.DTO.UserDTO;
import com.Practice.PracticeProject.Model.User;
import com.Practice.PracticeProject.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserDTO userDTO)
    {
        User user = new User(userDTO.getRole(), userDTO.isEnabled(), userDTO.getUsername(), userDTO.getJobtitle(),
                userDTO.getFirstname(), userDTO.getLastname(), userDTO.getPhone(), userDTO.getEmail(),
                passwordEncoder.encode(userDTO.getPassword()), userDTO.getDatehired(), userDTO.getDatefired());
        return userRepository.save(user);
    }
}
