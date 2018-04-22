/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.other;

import az.shahin.swings.TestOperations;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author shaheen
 */
public class OpenFile {

    public static void openFile(File file) {

        try {
            if (System.getProperty("os.name").equals("Linux")) {
                System.out.println("xdg-open " + file.getAbsolutePath());
            Runtime.getRuntime().exec("xdg-open " + file.getAbsolutePath());
            } else {
                Runtime.getRuntime().exec("explorer " + file.getAbsolutePath());
            }
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(TestOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
