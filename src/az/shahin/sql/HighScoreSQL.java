/*
create table highscore(
user_id int primary key,
Score double default 0.0,
foreign key(user_id) references Account(Id)
);
*/
package az.shahin.sql;

import az.shahin.pojo.HighScoresPojo;
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
public class HighScoreSQL extends SQLConnection {

    public void DeleteUserScore(int id) {
        try (Connection connect = getConnect()) {
            PreparedStatement ps = connect.prepareStatement("delete from highscore where User_Id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Delete high score error");
        }
    }

    public List<HighScoresPojo> getAll() {
        List<HighScoresPojo> map = new ArrayList<>();
        try (Connection connect = getConnect()) {
            String sql = "select * from highscore  Order By Score DESC limit 10";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                map.add(new HighScoresPojo(rs.getInt(1), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            System.out.println("ADD error");
        }
        return map;
    }

    public HighScoresPojo getUserScore(String username) {
        HighScoresPojo map = null;
        try (Connection connect = getConnect()) {
            int id = new AccountSQL().getAccountPojo(username).getId();
            String sql = "select * from highscore where user_id=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                map = new HighScoresPojo(rs.getInt(1), rs.getInt(2));
            }
        } catch (SQLException ex) {
            System.out.println("ADD error");
        }
        return map;
    }

    public void Clear(int id) {
        try (Connection connect = getConnect()) {
            String sql = id != -1 ? "update highscore set Score=? where User_Id=? " : "update highscore set Score=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, 0);
            if (id != -1) {
                ps.setInt(2, id);
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Clear error");
        }
    }

    public void Add(String username) {
        try (Connection connect = getConnect()) {
            int id = new AccountSQL().getAccountPojo(username).getId();
            String sql = "insert into highscore(user_id) values (?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ADD error");
        }
    }

    public void Update(String username, int Score) {
        try (Connection connect = getConnect()) {
            int id = new AccountSQL().getAccountPojo(username).getId();
            String sql = "update highscore set Score=? where user_id=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, Score);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update error");
        }
    }
}
