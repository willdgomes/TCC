/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gomes
 */
public class ConnectionFactory {

    public static Connection getConnection() throws SQLException{
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
         //   return DriverManager.getConnection("jdbc:mysql://localhost/Farmacia?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "123456@abc");
            return DriverManager.getConnection("jdbc:mysql://localhost/Farmacia", "root", "root");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
    