package com.Practice.PracticeProject.Service;


import com.Practice.PracticeProject.Model.Tickets;
import com.Practice.PracticeProject.Repositories.TicketRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Service
public class Login
{
    Authentication currentUser;

    @Autowired
    private UserDetailsService userDetailsService;

    private Principal principal;

    //private TicketRepository ticketRepository;

    public Login() { }

    public Login(Authentication currentUser, UserDetailsService userDetailsService, Principal principal)
    {
        this.currentUser = currentUser;
        this.userDetailsService = userDetailsService;
        this.principal = principal;
    }

//    @Autowired
//    public void setTicketRepository(TicketRepository ticketRepository)
//    {
//        this.ticketRepository = ticketRepository;
//    }

    public String loggInUser(Principal principal, UserDetailsService userDetailsService) throws JsonProcessingException
    {
        this.principal = principal;
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

        if (userDetails != null)
        {
            System.out.println("Andre the current user is " + userDetails.getUsername());
            return userDetails.getUsername();
        }
        else
        {
            System.out.println("No current user");
            return "No Current User";
        }

    }

    public String currentUserInfo(Principal principal, UserDetailsService userDetailsService) throws JsonProcessingException
    {
        this.principal = principal;
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        if (userDetails != null)
        {
            return userDetails.toString();
        }
        else
        {
            return "No Current User";
        }
    }

    public List<Tickets> AllMyTickets(int id, TicketRepository ticketRepository )
    {

        List<Tickets> myTickets = ticketRepository.findAllByemployeeID(id);
        if(myTickets.isEmpty())
        {
            System.out.println("Did not find any Tickets for given empoyeeid");
            System.exit(0);
        }
        return myTickets;
    }

}
