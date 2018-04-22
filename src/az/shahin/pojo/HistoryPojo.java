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
public class HistoryPojo {

    private int userId;
    private int testId;
    private String my;
    private String correct;
    private String time;
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) { 
        this.time = time;
    }

    public HistoryPojo(int userId, int testId, String my, String correct, String time, int score) {
        this.userId = userId;
        this.testId = testId;
        this.my = my;
        this.correct = correct;
        this.time = time;
        this.score = score;
    }
    private int score;

    public HistoryPojo() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getMy() {
        return my;
    }

    public void setMy(String my) {
        this.my = my;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
