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
public class TestTableModel {

    private String number;
    private String language1;
    private String language2;
    private String level;
    private String score;
    private String author;
    private String rating;
    private String description;
    private String date;

    public TestTableModel(String number, String language1, String language2, String level, String score, String author, String rating, String description, String date) {
        this.number = number;
        this.language1 = language1;
        this.language2 = language2;
        this.level = level;
        this.score = score;
        this.author = author;
        this.rating = rating;
        this.description = description;
        this.date = date;
    }

    public TestTableModel() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLanguage1() {
        return language1;
    }

    public void setLanguage1(String language1) {
        this.language1 = language1;
    }

    public String getLanguage2() {
        return language2;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
}

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
