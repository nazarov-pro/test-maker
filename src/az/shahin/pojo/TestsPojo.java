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
public class TestsPojo {
private int id;
private int account;
private int lang1;
private int lang2;
private String picture;
private String question;
private String answer;
private int level;
private int score;
private int mode;
private Timestamp date;
private int rating;
private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getLang1() {
        return lang1;
    }

    public void setLang1(int lang1) {
        this.lang1 = lang1;
    }

    public int getLang2() {
        return lang2;
    }

    public void setLang2(int lang2) {
        this.lang2 = lang2;
    }

    public String getPicture() {
        return picture;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public TestsPojo(int id, int account, int lang1, int lang2, String picture, int level, int score, int mode, Timestamp date,String question,String answer,int rating,String description) {
        this.id = id;
        this.account = account;
        this.lang1 = lang1;
        this.lang2 = lang2;
        this.picture = picture;
        this.level = level;
        this.score = score;
        this.mode = mode;
        this.date = date;
        this.question=question;
        this.answer=answer;
        this.rating = rating;
        this.description=description;
    }

    public TestsPojo() {
        
    }

}
