package com.minvydas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Minv1s on 16/08/22.
 */
public class TestJdbcConnection {

    public static void main(String[] args) throws Exception{
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            System.out.println("connection to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connected successfully!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
