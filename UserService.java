package com.Practice.PracticeProject.Service;

import com.Practice.PracticeProject.DTO.UserDTO;
import com.Practice.PracticeProject.Model.User;

public interface UserService
{
    User findByUsername(String username);
    User save (UserDTO userdto);
}
