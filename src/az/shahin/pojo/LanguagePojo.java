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
public class LanguagePojo {
private String language;
private String languageShort;
private int id;

    public LanguagePojo(String language, String languageShort, int id) {
        this.language = language;
        this.languageShort = languageShort;
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageShort() {
        return languageShort;
    }

    public void setLanguageShort(String languageShort) {
        this.languageShort = languageShort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LanguagePojo{" + "language=" + language + ", languageShort=" + languageShort + ", id=" + id + '}';
    }

    public LanguagePojo() {
    }

}
