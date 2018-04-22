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
public class ConfigPojo {
private String host;
private String username;
private String password;
private String adminsPassword;
private boolean tip;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminsPassword() {
        return adminsPassword;
    }

    public void setAdminsPassword(String adminsPassword) {
        this.adminsPassword = adminsPassword;
    }

    public boolean isTip() {
        return tip;
    }

    public void setTip(boolean tip) {
        this.tip = tip;
    }

    public ConfigPojo(String host, String username, String password, String adminsPassword, boolean tip) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.adminsPassword = adminsPassword;
        this.tip = tip;
    }

    public ConfigPojo() {
    }
}
