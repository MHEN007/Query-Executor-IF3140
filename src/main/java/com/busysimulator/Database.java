package com.busysimulator;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

class Database {
    private static Database INSTANCE = null;
    private Connection conn = null;

    private Database() throws SQLException{
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/db_name"; // CHANGE THIS ACCORDINGLY FOR port AND db_name
            String username = "postgres";
            String password = "root";
            this.conn = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Connection getConnection(){
        return conn;
    }

    public static Database getInstance(){
        if (INSTANCE == null){
            try {
                INSTANCE = new Database();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return INSTANCE;
    }
}