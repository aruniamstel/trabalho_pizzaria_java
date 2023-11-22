package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String database = "trabalholpoo2";
        String userDb = "root";
        String senhaDb = "root";

        Connection connection = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=" + database;

            connection = DriverManager.getConnection(url, userDb, senhaDb);
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao acessar o banco: " + ex.getMessage());
        }

        return null;
    }
}

