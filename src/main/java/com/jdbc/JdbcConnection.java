package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?serverTimezone=Europe/Warsaw&useSSL=false";
        String user = "al";
        String pass = "all";

        try {
            System.out.println("Connecting to database " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
