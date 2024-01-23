/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classprojectoop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Samantha
 */
public class DatabaseTableCreater {
    static final String URL = "jdbc:mysql://localhost:3306/hermes";
    static String user = "root";
    static String pass = "";
    

    /**
     *
     */
    public void createDatabase(){
        try{
            
            
            Connection connection = DriverManager.getConnection(URL, user, pass);
            Statement statement = connection.createStatement();

            // Create database if not exists
            String createDatabaseStatement = "CREATE DATABASE IF NOT EXISTS hermes";
            statement.executeUpdate(createDatabaseStatement);
            System.out.println("Database Created");

            // Switch to the created database
            connection = DriverManager.getConnection(URL, user, pass);
            System.out.println("Connected to the new database");

            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hermes",user,pass);
            //System.out.println("Connected to new database");

            // Create messages table
            String createTableMessages = "CREATE TABLE IF NOT EXISTS messages ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY not NULL,"
                    + "message VARCHAR(500),"
                    + "time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                    + "profileId INT NOT NULL"
                    + ")";
            statement.executeUpdate(createTableMessages);
            System.out.println("Messages Table Created");

            // Create users table
            String createTableUsers = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "userName VARCHAR(255),"
                    + "password VARCHAR(255),"
                    + "email VARCHAR(255)"
                    + ")";
             statement.executeUpdate(createTableUsers);
            System.out.println("Users Table Created");
            
            
            // Create NewsFeeds table
            String createTableNews = "CREATE TABLE IF NOT EXISTS NewsFeed ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    +"time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                    + "userName VARCHAR(255),"
                    + "newsFeed VARCHAR(255)"
                    + ")";
             statement.executeUpdate(createTableNews);
            System.out.println("NewsFeeds table Created");
            
            
            String newTableM = "CREATE TABLE messages("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "message VARCHAR(255))";
            statement.executeUpdate(newTableM);
            System.out.println("Table created");
            
            System.out.println("Table Created");

        }
        
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param users
     * @param passwords
     * @param email
     * @param newsFeed
     */
    
    
    
    public void insertUser(String users,String passwords, String email){
        try{  
          Connection connection = DriverManager.getConnection(URL,user,pass);
          Statement statement = connection.createStatement();
          String insertUser = "INSERT INTO users(userName,password,email) VALUES('"+users+"','"+passwords+"','"+email+"')";
          String [] strings = new String []{users,passwords,email};
          
          statement.executeUpdate(insertUser, strings);
            System.out.println("User Added");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    /**
     *
     * @param message
     */
    public void sendMessage(String message){
        // send the message
          Connection connection;
        try {
            connection = DriverManager.getConnection(URL,user,pass);
             Statement statement = connection.createStatement();
             String sentMessage = "INSERT INTO messages(message) VALUES('"+message+"')";
             statement.executeUpdate(sentMessage);
             System.out.println("Message Sent");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTableCreater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    public String getMessage(){
        String message = "";
        try {
            
            Connection connection = DriverManager.getConnection(URL,user,pass);
            Statement statement = connection.createStatement();
            String getMessage = "SELECT message FROM messages WHERE id = 1";
            ResultSet resultSet = statement.executeQuery(getMessage);
            
            if (resultSet.next()) {
                 message = resultSet.getString("message");
            }
             
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTableCreater.class.getName()).log(Level.SEVERE, null, ex);
        }
         return message;
    }
    
    /**
     *
     * @param NewsFeed
     */
    public void createNewsFeed(String message){
        // send the message
         String newsFeed = "";
        try {
            Connection Connection = DriverManager.getConnection(URL,user,pass);
            Statement statement = Connection.createStatement();
             String getNewsFeed = "SELECT newsFeed FROM newsFeed WHERE id = 1";
             ResultSet resultSet = statement.executeQuery(getNewsFeed);
             System.out.println("NewsFeed posted");
             
             if (resultSet.next()) {
                 newsFeed = resultSet.getString("NewsFeed");
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTableCreater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}

    
