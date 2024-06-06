package com.Practice.PracticeProject.Repositories;

import com.Practice.PracticeProject.Model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Integer>
{

    //@Query(value = "SELECT * FROM tickets WHERE ticketid = ?1", nativeQuery = true)
    List<Tickets> findAllByemployeeID(int id);



}
