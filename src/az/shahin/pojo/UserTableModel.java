/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.pojo;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UserTableModel {
    private AccountPojo pojo ;
    private int Score;

    public AccountPojo getPojo() {
        return pojo;
    }

    public void setPojo(AccountPojo pojo) {
        this.pojo = pojo;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public UserTableModel(AccountPojo pojo, int Score) {
        this.pojo = pojo;
        this.Score = Score;
    }

    public UserTableModel() {
    }
}
