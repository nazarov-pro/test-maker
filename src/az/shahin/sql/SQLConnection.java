/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.sql;

import az.shahin.pojo.ConfigPojo;
import az.shahin.tests.XMLConfigReaderAndWriter;
import com.mysql.jdbc.Driver;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class SQLConnection {

    private Connection connect;
    private  String path ;
    private  String username ;
    private  String password ;

    public void setPath(String path) {
        this.path = "jdbc:mysql://" + path;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected Connection getConnect() {
        if(username == null || password == null){
            try {
                ConfigPojo pojo = new XMLConfigReaderAndWriter().readData();
                setPath(pojo.getHost());
                setUsername(pojo.getUsername());
                setPassword(pojo.getPassword());
            } catch (IOException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            DriverManager.registerDriver(new Driver());
            connect = DriverManager.getConnection(path,username,password);
            successful=true;
        } catch (SQLException ex) {
            successful=false;
        }
        return connect;
    }
    
    private boolean successful;

    public boolean isSuccessful() {
        getConnect();
        return successful;
    }
    

}
