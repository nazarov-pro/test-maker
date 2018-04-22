/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.tests;

import az.shahin.pojo.LanguagePojo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class AllLanguage {

    private AllLanguage() {

    }

    public static List<LanguagePojo> getAllLanguage() {
        List<LanguagePojo> languagelist = new ArrayList<>();
        for (Language lang : Language.values()) {
            languagelist.add(new LanguagePojo(lang.name(), lang.getText(), lang.getId()));
        }
        return languagelist;
    }
    
    public static String getLanguage(int langid){
        return getAllLanguage().get(langid).getLanguage();
    }

}
