/*
 * A class used to establish JDBC Connections.
 */

package com.sheridan.database;

import java.sql.*;


public class DBConnection {
    private static String url = "jdbc:mysql://localhost:3306/mercury";
    private static String username = "root";
    private static String password = "P@ssw0rd";

    public DBConnection() {

    }
    public Connection getConnections() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found");
        } catch (SQLException e) {
            System.out.println("Error getting connection!");
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeJDBCObjects(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ignored) {
        }
    }

    public static void closeJDBCObjects(Connection conn, Statement stmt) {
        closeJDBCObjects(conn, stmt, null);
    }
}
