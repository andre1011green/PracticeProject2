package com.Practice.PracticeProject.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tickets")
public class Tickets
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketid;

    private String description;

    private String ticketStatus;

    private float amount;

    private Timestamp dateSubmitted;

    private Timestamp dateResolved;

    private String reimbursementType;

    private int employeeID;

    public Tickets() { }

    public Tickets(String description, String ticketStatus, float amount, Timestamp dateSubmitted, Timestamp dateResolved, String reimbursementType, int employeeID)
    {
        this.description = description;
        this.ticketStatus = ticketStatus;
        this.amount = amount;
        this.dateSubmitted = dateSubmitted;
        this.dateResolved = dateResolved;
        this.reimbursementType = reimbursementType;
        this.employeeID = employeeID;
    }

    public int getTicketID()
    {
        return ticketid;
    }


    public void setTicketID(int ticketid)
    {
        this.ticketid = ticketid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTicketStatus()
    {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus)
    {
        this.ticketStatus = ticketStatus;
    }

    public float getAmount()
    {
        return amount;
    }

    public void setAmount(float amount)
    {
        this.amount = amount;
    }

    public Timestamp getDateSubmitted()
    {
        return dateSubmitted;
    }

    public void setDateSubmitted(Timestamp dateSubmitted)
    {
        this.dateSubmitted = dateSubmitted;
    }

    public Timestamp getDateResolved()
    {
        return dateResolved;
    }

    public void setDateResolved(Timestamp dateResolved)
    {
        this.dateResolved = dateResolved;
    }

    public String getReimbursementType()
    {
        return reimbursementType;
    }

    public void setReimbursementType(String reimbursementType)
    {
        this.reimbursementType = reimbursementType;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    @Override
    public String toString()
    {
            return "tickets{" +
                    "ticketid=" + ticketid +
                    ", description='" + description + '\'' +
                    ", ticketStatus='" + ticketStatus + '\'' +
                    ", amount=" + amount +
                    ", dateSubmitted=" + dateSubmitted +
                    ", dateResolved=" + dateResolved +
                    ", reimbursementType='" + reimbursementType + '\'' +
                    ", employeeID=" + employeeID +
                    '}';
    }
}


