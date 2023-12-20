package com.flipkart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection singleInstance = null;
    public static Connection connect() throws SQLException{

        if(singleInstance ==null){

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                FileInputStream inputStream = new FileInputStream("/Users/t.nikhitha/Downloads/GMS-JEDI-Flipkart-JAVA-Project/JEDI-2.0-GMS-JavaProject/config.properties");
                Properties newProp = new Properties();
                newProp.load(inputStream);
                Connection connection = DriverManager.getConnection(newProp.getProperty("url"),newProp.getProperty("user"),newProp.getProperty("password"));
                singleInstance = connection;
                return connection;
            }
            catch (ClassNotFoundException ex){
                System.err.println("Could not find jdbc driver.");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else{
            return singleInstance;
        }

        return null;
    }
}