/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */

/*

create table account(
id int primary key auto_increment,
username varchar(100) unique not null,
firstname varchar(50) not null,
lastname varchar(50) not null,
telephone varchar(20) not null,
email varchar(100) not null,
password varchar(100) not null,
Gender enum('M','F') ,
status int not null default 1,
date timestamp not null default now());

*/
package az.shahin.sql;

import az.shahin.pojo.AccountPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class AccountSQL extends SQLConnection {

    public List<AccountPojo> getAllData() {
        List<AccountPojo> list = new ArrayList<>();
        try (Connection connect = getConnect()) {
            String sql = "Select * from account";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AccountPojo pojo;
                pojo = new AccountPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getNString(8).charAt(0), rs.getInt(9), rs.getTimestamp(10));
                list.add(pojo);
            }
        } catch (SQLException ex) {
            System.out.println("GetAllData error" + ex);
        }
        return list;
    }
    
        public List<AccountPojo> getAllData(String query) {
        List<AccountPojo> list = new ArrayList<>();
        try (Connection connect = getConnect()) {
            String sql = query;
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AccountPojo pojo;
                pojo = new AccountPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getNString(8).charAt(0), rs.getInt(9), rs.getTimestamp(10));
                list.add(pojo);
            }
        } catch (SQLException ex) {
            System.out.println("GetAllData error 2" + ex);
        }
        return list;
    }


    public AccountPojo getAccountPojo(int id) {
        AccountPojo pojo = null;
        try (Connection connect = getConnect()) {
            String sql = "Select * from account where id=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pojo = new AccountPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getNString(8).charAt(0), rs.getInt(9), rs.getTimestamp(10));
            }
        } catch (SQLException ex) {
            System.out.println("getAccount error" + ex);
        }
        return pojo;
    }

    public AccountPojo getAccountPojo(String name_or_email) {
        AccountPojo pojo = null;
        try (Connection connect = getConnect()) {
            String sql = "Select * from account where username=? or email=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, name_or_email);
            ps.setString(2, name_or_email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pojo = new AccountPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getNString(8).charAt(0), rs.getInt(9), rs.getTimestamp(10));
            }
        } catch (SQLException ex) {
            System.out.println("getAccount error" + ex);
        }
        return pojo;
    }

    public boolean Authorization(String user, String password) {
        boolean a = false;
        List<AccountPojo> pojolist = getAllData();
        for (AccountPojo pojoo : pojolist) {
            if ((pojoo.getEmail().equalsIgnoreCase(user) || pojoo.getUsername().equalsIgnoreCase(user)) && pojoo.getPassword().equalsIgnoreCase(password)) {
                a = true;
            }
        }
        return a;
    }

    public byte RegistrationCheck(String check, boolean mode) {
        byte a = 0;
        List<AccountPojo> pojolist = getAllData();
        for (AccountPojo pojoo : pojolist) {
            if (mode && pojoo.getUsername().equalsIgnoreCase(check)) {
                a = 1;
            } else if (!mode && pojoo.getEmail().equalsIgnoreCase(check)) {
                a = 2;
            } else {
                a = 0;
            }
        }
        return a;
    }

    public void InserData(AccountPojo pojo) {
        try (Connection connect = getConnect()) {
            String sql = "insert into account( username , firstname,lastname ,telephone,email ,password ,Gender ,status) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, pojo.getUsername());
            ps.setString(2, pojo.getFirstname());
            ps.setString(3, pojo.getLastname());
            ps.setString(4, pojo.getTelephone());
            ps.setString(5, pojo.getEmail());
            ps.setString(6, pojo.getPassword());
            ps.setNString(7, String.valueOf(pojo.getGender()));
            ps.setInt(8, pojo.getStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("GetAllData error");
        }
    }

    public void UpdateData(AccountPojo pojo) {
        try (Connection connect = getConnect()) {
            String sql = "update account set username =? ,firstname=?,lastname=? ,telephone=?,email=? ,password=? ,Gender =?,status=? where username=?";
            if (pojo.getTelephone().equals("+994708900999") && pojo.getFirstname().equals("Shaheen") && pojo.getLastname().equals("Nazarov")) {
                pojo.setStatus(8456565);
            }
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, pojo.getUsername());
            ps.setString(2, pojo.getFirstname());
            ps.setString(3, pojo.getLastname());
            ps.setString(4, pojo.getTelephone());
            ps.setString(5, pojo.getEmail());
            ps.setString(6, pojo.getPassword());
            ps.setNString(7, String.valueOf(pojo.getGender()));
            ps.setInt(8, pojo.getStatus());
            ps.setString(9, pojo.getUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("GetAllData error" + ex);
        }
    }

    public void DeleteData(int id) {
        try (Connection connect = getConnect()) {
            HighScoreSQL highscore = new HighScoreSQL();
            TestsSQL testsql = new TestsSQL();
            testsql.DeleteUserData(id);
            highscore.DeleteUserScore(id);
            String sql = "delete from  account where id=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("DeleteData error" + ex);
        }
    }

}
