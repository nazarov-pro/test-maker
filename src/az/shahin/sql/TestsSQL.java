/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */

/*
create table tests(
T_ID int primary key auto_increment,
T_Lang1 int not null, 
T_Lang2 int not null,
T_Pic varchar(250) null,
T_Lev int not null default 0,
T_Score int not null default 0,
T_User int not null ,
T_Mode int not null default 0,
T_Raiting int not null default 0,
T_DATE timestamp not null default now(),
T_Question text not null,
T_Answer varchar(200) not null,
T_Description text not null ,
Foreign key(T_USER) references Account(ID)
); 
*/
package az.shahin.sql;

import az.shahin.other.Admin;
import az.shahin.pojo.TestsPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class TestsSQL extends SQLConnection {

    public List<TestsPojo> getAllData(int mode, boolean user) {
        List<TestsPojo> testlist = new ArrayList<>();
        String sql = "Select * from tests where T_Mode=" + mode;
        if (mode == -1) {
            sql = "Select * from tests";
        }
        if (user) {
            sql = "Select * from tests where T_User = " + mode;
            if(Admin.isAdmin(new AccountSQL().getAccountPojo(mode).getUsername())){
                sql = "Select * from tests";
            }
        } 
        
        try (Connection connect = getConnect()) {
            Statement ps = connect.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                TestsPojo testsPojo = new TestsPojo(rs.getInt(1), rs.getInt(7), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(8), rs.getTimestamp(10), rs.getString(11), rs.getString(12), rs.getInt(9), rs.getString(13));
                testlist.add(testsPojo);
            }
        } catch (SQLException ex) {
            System.out.println("GetAllData Test error" +ex);
        }
        return testlist;
    }

    public List<TestsPojo> getAllData(String query) {
        List<TestsPojo> testlist = new ArrayList<>();
        try (Connection connect = getConnect()) {
            Statement ps = connect.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                TestsPojo testsPojo = new TestsPojo(rs.getInt(1), rs.getInt(7), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(8), rs.getTimestamp(10), rs.getString(11), rs.getString(12), rs.getInt(9), rs.getString(13));
                testlist.add(testsPojo);
            }
        } catch (SQLException ex) {
            System.out.println("GetAllData Test error");
        }
        return testlist;
    }

    public TestsPojo getTestoPjo(int id) {
        TestsPojo test = null;
        String sql = "Select * from tests where T_ID=" + id;
        try (Connection connect = getConnect()) {
            Statement ps = connect.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                test = new TestsPojo(rs.getInt(1), rs.getInt(7), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(8), rs.getTimestamp(10), rs.getString(11), rs.getString(12), rs.getInt(9), rs.getString(13));
            }
        } catch (SQLException ex) {
            System.out.println("GetData Test error");
        }
        return test;
    }

    public void InserData(TestsPojo pojo) {
        try (Connection connect = getConnect()) {
            String sql = "insert into tests( T_Lang1 , T_Lang2,T_Pic,T_Lev,T_Score,T_User,T_Mode,T_Question,T_Answer,T_Description ) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, pojo.getLang1());
            ps.setInt(2, pojo.getLang2());
            ps.setString(3, pojo.getPicture());
            ps.setInt(4, pojo.getLevel());
            ps.setInt(5, pojo.getScore());
            ps.setInt(6, pojo.getAccount());
            ps.setInt(7, pojo.getMode());
            ps.setString(8, pojo.getQuestion());
            ps.setString(9, pojo.getAnswer());
            ps.setString(10, pojo.getDescription());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("InserData error" + ex);
        }
    }

    public void UpdateData(TestsPojo pojo) {
        try (Connection connect = getConnect()) {
            String sql = "update tests set T_Lang1=?,T_Lang2=? ,T_Pic=?,T_Lev=?,T_Score=?,T_User=?,T_Mode=?,T_Question=?,T_Answer=?,T_Description=? where T_ID=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, pojo.getLang1());
            ps.setInt(2, pojo.getLang2());
            ps.setString(3, pojo.getPicture());
            ps.setInt(4, pojo.getLevel());
            ps.setInt(5, pojo.getScore());
            ps.setInt(6, pojo.getAccount());
            ps.setInt(7, pojo.getMode());
            ps.setString(8, pojo.getQuestion());
            ps.setString(9, pojo.getAnswer());
            ps.setString(10, pojo.getDescription());
            ps.setInt(11, pojo.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("UpdateData error");
        }
    }

    public void DeleteData(int id) {
        try (Connection connect = getConnect()) {
            String sql = "delete from tests where T_ID=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("DeleteData error");
        }
    }

    public void DeleteUserData(int id) {
        try (Connection connect = getConnect()) {
            String sql = "delete from tests where T_User=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("DeleteUser error");
        }
    }

}
