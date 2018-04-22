/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.other;

import az.shahin.pojo.AccountPojo;
import az.shahin.pojo.UserTableModel;
import az.shahin.sql.AccountSQL;
import az.shahin.sql.HighScoreSQL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UserModel extends AbstractTableModel {

    private List<UserTableModel> model = new ArrayList<>();
    private final boolean isAdmin;

    public UserModel(boolean isAdmin) {
        this.isAdmin = isAdmin;
        start();
    }

    private void start() {
        model.clear();
        List<AccountPojo> listaccounts = new AccountSQL().getAllData();
        for (AccountPojo eachpojo : listaccounts) {
            UserTableModel modeltable = new UserTableModel(eachpojo, new HighScoreSQL().getUserScore(eachpojo.getUsername()).getScore());
            model.add(modeltable);
        }
    }

    public void setData(List<AccountPojo> pojoes) {
        model.clear();
        for (AccountPojo pojo : pojoes) {
            UserTableModel modeltable = new UserTableModel(pojo, new HighScoreSQL().getUserScore(pojo.getUsername()).getScore());
            model.add(modeltable);
        }
    }

    private List<String> getColumns() {
        List<String> columns = new ArrayList<>();
        columns.add("ID");
        columns.add("First Name");
        columns.add("Last Name");
        columns.add("Gender");
        columns.add("Telephone");
        columns.add("Score");
        if (isAdmin) {
            columns.add("Username");
            columns.add("Password");
            columns.add("E-Mail");
            columns.add("Status");
        }
        columns.add("Reg. Data");
        return columns;
    }

    @Override
    public int getRowCount() {
        return model.size();
    }

    @Override
    public int getColumnCount() {
        return getColumns().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AccountPojo selected = model.get(rowIndex).getPojo();
        if (isAdmin) {
            switch (columnIndex) {
                case 0:
                    return selected.getId();
                case 1:
                    return selected.getFirstname();
                case 2:
                    return selected.getLastname();
                case 3:
                    return selected.getGender() == 'M' ? "Male" : "Female";
                case 4:
                    return selected.getTelephone();
                case 5:
                    return model.get(rowIndex).getScore();
                case 6:
                    return selected.getUsername();
                case 7:
                    return selected.getPassword();
                case 8:
                    return selected.getEmail();
                case 9:
                    return Admin.isAdmin(selected.getUsername()) ? "Admin" : "User";
                case 10:
                    return selected.getDate().toGMTString();
                default:
                    return null;
            }

        } else {
            switch (columnIndex) {
                case 0:
                    return selected.getId();
                case 1:
                    return selected.getFirstname();
                case 2:
                    return selected.getLastname();
                case 3:
                    return selected.getGender() == 'M' ? "Male" : "Female";
                case 4:
                    return selected.getTelephone();
                case 5:
                    return model.get(rowIndex).getScore();
                case 6:
                    return selected.getDate().toGMTString();
                default:
                    return null;
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        return getColumns().get(column);
    }

}
