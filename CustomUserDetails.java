package com.Practice.PracticeProject.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;

public class CustomUserDetails implements UserDetails
{
    private BigInteger employeeid;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled;
    private String username;
    private String jobtitle;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;
    private Timestamp datehired;
    private Timestamp datefired;

    public CustomUserDetails(BigInteger employeeid, Collection<? extends GrantedAuthority> authorities, boolean enabled,
                             String username, String jobtitle, String firstname, String lastname,
                             String phone, String email, String password, Timestamp datehired,
                             Timestamp datefired)
    {
        this.employeeid = employeeid;
        this.authorities = authorities;
        this.enabled = enabled;
        this.username = username;
        this.jobtitle = jobtitle;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.datehired = datehired;
        this.datefired = datefired;
    }

    public BigInteger getEmployeeid(){return employeeid;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return authorities;}

    @Override
    public String getUsername() {return username;}

    public String getJobtitle() {return jobtitle;}

    public String getFirstname() {return firstname;}

    public String getLastname() {return lastname;}

    public String getPhone() {return phone;}

    public String getEmail() {return email;}

    @Override
    public String getPassword() {return password;}

    public Timestamp getDatehired() {return datehired;}

    public Timestamp getDatefired() {return datefired;}

    @Override
    public boolean isAccountNonExpired() {return true;}

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() {return true;}

    @Override
    public String toString()
    {
        return "employeeid:" + employeeid + "," +
                "authorities:" + authorities + "," +
                "enabled:" + enabled + "," +
                "username:" + username + "," +
                "jobtitle:" + jobtitle + "," +
                "firstname:" + firstname + "," +
                "lastname:" + lastname + "," +
                "phone:" + phone + "," +
                "email:" + email + "," +
                "password:" + password + "," +
                "datehired:" + datehired + "," +
                "datefired:" + datefired ;
    }
}
