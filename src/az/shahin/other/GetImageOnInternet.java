/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class GetImageOnInternet {

    private int index = 0;
    private boolean net =false ;
    private String ImageUrl(String searchkey) {
        String url2 = "";
        searchkey= searchkey.replaceAll(" ", "+");
        try {
            URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + searchkey);
            URLConnection connection = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            az.shahin.other.JSONObject json = new az.shahin.other.JSONObject(builder.toString());
            url2 = json.getJSONObject("responseData").getJSONArray("results").getJSONObject(index).getString("url");
            net = true;
        }catch (UnknownHostException e) {
            net = false;
            JOptionPane.showMessageDialog(null, "Check your Internet connection", "Failure", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
        catch (Exception e) {
            net = false;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Failure", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return url2;
    }
    
    public boolean getNet(){
        return net;
    }

    public String nextImageUrl(String searchkey) {
        index++;
        String url = ImageUrl(searchkey);
        return url;
    }

    public String previousImageUrl(String searchkey) {
        index--;
        String url = ImageUrl(searchkey);
        return url;
    }

    public String CustomImageUrl(String searchkey, int index) {
        String url = ImageUrl(searchkey);
        this.index = index;
        return url;
    }

    public int getIndex() {
        return index;
    }
}
