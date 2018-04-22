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
public class Rate {

    public static String[] getAllString() {
        String[] rating = new String[6];
        int i = 0;
        for (Rating rate : Rating.values()) {
            rating[i] = rate.toString();
            i++;
        }
        return rating;
    }

    public static String getRating(int rating) {
        String[] raties = getAllString();
        if (rating < 5) {
            return raties[0];
        } else if (rating < 10) {
            return raties[1];
        } else if (rating < 20) {
            return raties[2];
        } else if (rating < 50) {
            return raties[3];
        } else if (rating < 100) {
            return raties[4];
        } else {
            return raties[5];
        }
    }

    public static int getRating(String rating) {
        String[] raties = getAllString();
        if (raties[0].equals(rating)) {
            return 5;
        } else if (raties[1].equals(rating)) {
            return 10;
        } else if (raties[2].equals(rating)) {
            return 20;
        } else if (raties[3].equals(rating)) {
            return 50;
        } else if (raties[4].equals(rating)) {
            return 100;
        } else {
            return 200;
        }
    }

}
