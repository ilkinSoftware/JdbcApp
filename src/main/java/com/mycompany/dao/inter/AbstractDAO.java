/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lenovo
 */
public abstract class AbstractDAO {

    public Connection connect() throws Exception {
        // Class.forName("com.mysql.jdbc.Driver"); ehtiyac yoxdu buna java-8 den sonra
        String url = "jdbc:mysql://localhost:3306/user?serverTimezone=UTC";
        String username = "root";
        String password = "12345";
        Connection c = DriverManager.getConnection(url, username, password);      
        return c;
    }

}
