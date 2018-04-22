/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.other;

import az.shahin.pojo.AccountPojo;
import az.shahin.sql.AccountSQL;
import javax.swing.JOptionPane;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class Admin {
private AccountSQL sql = new AccountSQL();
private AccountPojo pojo = new AccountPojo();
    public static boolean isAdmin(String username) {
        Admin admin = new Admin();
        return admin.checking(username);
    }
    
    private  boolean checking(String username){
        pojo = sql.getAccountPojo(username);
        if(pojo.getStatus() == 8456565){
            return true;
        }
        else{
            //JOptionPane.showConfirmDialog(null, "You are not Admin !", "System Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
