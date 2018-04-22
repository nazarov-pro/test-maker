/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */

package az.shahin.pojo;

import java.sql.Timestamp;

/**
 * 
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class AccountPojo {
private int id,status=0;
private String username,firstname,lastname,telephone,email,password;
private Timestamp date;
private char gender;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public AccountPojo() {
    }
    public AccountPojo( String username, String firstname, String lastname, String telephone, String email, String password, char gender) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }
    public AccountPojo(int id, String username, String firstname, String lastname, String telephone, String email, String password, char gender,int status,Timestamp date) {
        this.id = id;
        this.status = status;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.date=date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    
    
    
}
