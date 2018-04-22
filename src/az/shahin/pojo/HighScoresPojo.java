/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */

package az.shahin.pojo;

/**
 * 
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class HighScoresPojo {
private int id,score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public HighScoresPojo(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public HighScoresPojo() {
    }
}
