package com.Practice.PracticeProject.Controller;

import com.Practice.PracticeProject.Model.Tickets;
//import com.Practice.PracticeProject.Repositories.TicketRepository;
import com.Practice.PracticeProject.Repositories.TicketRepository;
import com.Practice.PracticeProject.Service.Login;
import com.Practice.PracticeProject.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
public class UserController
{
    private TicketRepository ticketRepository;

    public UserController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    Login mylogin;

    UserDetails currentUser;

    @Autowired
    private UserDetailsService userDetailsService;

    private UserService userService;

    public UserController() { }

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/error")
    public String error()
    {
        System.out.println("/error");
        return "error.html";
    }

    @GetMapping({"/", "/index"})
    public String showForm()
    {
        System.out.println("/index: GetMapping");
        return "index.html";
    }

    @PostMapping("/index")
    public String postForm()
    {
        System.out.println("POST: /index");
        return "home.html";
    }

    @GetMapping("/home")
    public String home( )
    {
        System.out.println("/home");
        return "home.html";
    }

    /* There is also a function named loggInUser in the Login class in the Service package
    * the purpose of loggInUser in this UserController class is to call mylogin.loggInUser, so it can
    * be used as an endpoint so repaymentScript.js can catch and display the username of the current
    * user on the home.html, NOTE: @ResponseBody is used to return a String and not HTML */
    @GetMapping("/loggInUser")
    @ResponseBody
    public String loggInUser(Principal principal, Login mylogin) throws JsonProcessingException
    {
        this.mylogin = mylogin;
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        System.out.println("Current User in UserController.java: " + userDetails.toString());
        String theCurrentUser =  mylogin.loggInUser(principal, userDetailsService);
        return theCurrentUser;

    }

    @GetMapping("/currentUserInfo")
    @ResponseBody
    public String currentUserInfo(Principal principal, Login mylogin) throws JsonProcessingException
    {
        this.mylogin = mylogin;
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        String CurrentUserInformation = mylogin.currentUserInfo(principal, userDetailsService);

        String[] outputString1 = CurrentUserInformation.split(",");

        return outputString1[0] + ",   " + outputString1[1] +  ",   " + outputString1[2] + ",   "
                + outputString1[3] +  ",   " +outputString1[4] +  ",   " +outputString1[5] + ",   "
                + outputString1[6] + ",   " + outputString1[7] + ",   " + outputString1[8] + ",   "
                + outputString1[10] + ",   " + outputString1[11];
    }


    @GetMapping("/displayMyTickets")
    @ResponseBody
    public List<Tickets> displayMyTickets(Login mylogin, TicketRepository ticketRepository)
    {
        this.mylogin = mylogin;
        int id = 1;
        return mylogin.AllMyTickets(id, ticketRepository);
    }




}
