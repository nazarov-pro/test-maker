/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.other;

import az.shahin.pojo.AccountPojo;
import az.shahin.pojo.TestTableModel;
import az.shahin.pojo.TestsPojo;
import az.shahin.sql.AccountSQL;
import az.shahin.sql.TestsSQL;
import az.shahin.tests.AllLanguage;
import az.shahin.tests.Level;
import az.shahin.tests.Rate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestModel extends AbstractTableModel {

    private int id;
    private List<TestTableModel> model = new ArrayList<>();

    public TestModel(int id) {
        this.id = id;
        start();
    }

    private void start() {
        model.clear();
        AccountPojo pojoaccount = new AccountPojo();
        List<TestsPojo> listtest = new TestsSQL().getAllData(id, true);
        for (TestsPojo eachpojo : listtest) {
            TestTableModel modeltable = new TestTableModel();
            modeltable.setNumber(String.valueOf(eachpojo.getId()));
            modeltable.setLanguage1(AllLanguage.getLanguage(eachpojo.getLang1()));
            modeltable.setLanguage2(AllLanguage.getLanguage(eachpojo.getLang2()));
            modeltable.setLevel(Level.getLevel(eachpojo.getLevel()));
            modeltable.setDescription(eachpojo.getDescription());
            pojoaccount = new AccountSQL().getAccountPojo(eachpojo.getAccount());
            modeltable.setAuthor(pojoaccount.getFirstname() + " " + pojoaccount.getLastname());
            modeltable.setRating(Rate.getRating(eachpojo.getRating()));
            modeltable.setScore(String.valueOf(eachpojo.getScore()));
            modeltable.setDate(eachpojo.getDate().toString());
            model.add(modeltable);
        }
    }

    public void start(List<TestsPojo> listtest) {
            model.clear();
             AccountPojo pojoaccount = new AccountPojo();
            for (TestsPojo eachpojo : listtest) {
                TestTableModel modeltable = new TestTableModel();
                modeltable.setNumber(String.valueOf(eachpojo.getId()));
                //System.out.println(modeltable.getNumber());
                modeltable.setLanguage1(AllLanguage.getLanguage(eachpojo.getLang1()));
                modeltable.setLanguage2(AllLanguage.getLanguage(eachpojo.getLang2()));
                modeltable.setLevel(Level.getLevel(eachpojo.getLevel()));
                modeltable.setDescription(eachpojo.getDescription());
                pojoaccount = new AccountSQL().getAccountPojo(eachpojo.getAccount());
                modeltable.setAuthor(pojoaccount.getFirstname() + " " + pojoaccount.getLastname());
                modeltable.setRating(Rate.getRating(eachpojo.getRating()));
                modeltable.setScore(String.valueOf(eachpojo.getScore()));
                modeltable.setDate(eachpojo.getDate().toString());
                model.add(modeltable);
            }
    }

    private List<String> getColumns() {
        List<String> columns = new ArrayList<>();
        columns.add("Number");
        columns.add("Language1");
        columns.add("Language2");
        columns.add("Level");
        columns.add("Description");
        columns.add("Author");
        columns.add("Rating");
        columns.add("Score");
        columns.add("Date");
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
        switch (columnIndex) {
            case 0:
                return model.get(rowIndex).getNumber();
            case 1:
                return model.get(rowIndex).getLanguage1();
            case 2:
                return model.get(rowIndex).getLanguage2();
            case 3:
                return model.get(rowIndex).getLevel();
            case 4:
                return model.get(rowIndex).getDescription();
            case 5:
                return model.get(rowIndex).getAuthor();
            case 6:
                return model.get(rowIndex).getRating();
            case 7:
                return model.get(rowIndex).getScore();
            case 8:
                return model.get(rowIndex).getDate();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return getColumns().get(column);
    }

}
