/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.tests;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Level {

    public static String getLevel(int levelcode) {
        switch (levelcode) {
            case 0:
                return "Beginner";
            case 1:
                return "Elementary";
            case 2:
                return "Pre-Intermediate";
            case 3:
                return "Low Intermediate";
            case 4:
                return "Intermediate";
            case 5:
                return "Upper Intermediate";
            case 6:
                return "Pre-advanced";
            case 7:
                return "Advanced";
            case 8:
                return "Very Advanced";
    }
        return null;
    }
    

}
