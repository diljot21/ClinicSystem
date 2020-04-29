/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sheridan.database;

import com.sheridan.model.Patient;
import com.sheridan.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author DILJOT
 */
public class UserDAO {

    DBConnection dbConn = new DBConnection();
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public boolean checkUsernameValidity(String username) {
        try {
            String selectSQL = "SELECT * FROM users";
            conn = dbConn.getConnections();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (username.equals(rs.getString("username"))) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("username!");
        } finally {
            dbConn.closeJDBCObjects(conn, ps, rs);
        }
        return true;
    }

    public User getUser(String inputUsername, String inputPassword) throws SQLException {
        try {
            conn = dbConn.getConnections();
            String selectSQL = "SELECT * FROM users";
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (inputUsername.equals(rs.getString("username"))
                        && inputPassword.equals(rs.getString("password"))) {
                    return new User(rs.getString("username"), rs.getInt("role"),
                            rs.getString("password"));
                }
            }
        } catch (SQLException ex){
            System.out.println("Error in getting user");
        } finally {
            dbConn.closeJDBCObjects(conn, ps, rs);
        }
        return null;
    }

    public void addPatient(Patient patient) {
        try {
            conn = dbConn.getConnections();

            // Inserting into users table
            ps = conn.prepareStatement("INSERT INTO users (username, password, "
                    + "role) VALUES (?,?,?)");
            ps.setString(1, patient.getUsername());
            ps.setString(2, patient.getPassword());
            ps.setString(3, "2");
            ps.executeUpdate();

            // Inserting into addresses table
            ps = conn.prepareStatement("INSERT INTO addresses (streetLine1, "
                    + "streetLine2, aptOrUnitNumber, city, province, postalCode, "
                    + "type, occupant) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, patient.getStreetLine1());
            ps.setString(2, patient.getStreetLine2());
            ps.setString(3, patient.getAptOrUnitNumber());
            ps.setString(4, patient.getCity());
            ps.setString(5, patient.getProvince());
            ps.setString(6, patient.getPostalCode());
            ps.setString(7, patient.getType());
            ps.setString(8, patient.getUsername());
            ps.executeUpdate();

            // Inserting into phone number table
            ps = conn.prepareStatement("INSERT INTO phonenumbers(PhoneNumber, "
                    + "UserName, PhoneType) VALUES (?,?,?)");
            ps.setLong(1, patient.getPhoneNumber());
            ps.setString(2, patient.getUsername());
            ps.setString(3, patient.getPhoneType());
            ps.executeUpdate();

            // Inserting into patients table
            ps = conn.prepareStatement("INSERT INTO patients(OHIPNumber, OHIPVersion, "
                    + "FirstName, MiddleInitials, LastName, Login, Gender, DateOfBirth) "
                    + "VALUES (?,?,?,?,?,?,?,?)");
            ps.setLong(1, patient.getOhipNumber());
            ps.setString(2, patient.getOhipVersion());
            ps.setString(3, patient.getFirstName());
            ps.setString(4, patient.getMiddleInitials());
            ps.setString(5, patient.getLastName());
            ps.setString(6, patient.getUsername());
            ps.setString(7, String.valueOf(patient.getGender()));
            ps.setString(8, patient.getDateOfBirth().toString());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Invalid input users!");
        } finally {
            dbConn.closeJDBCObjects(conn, ps);
        }
    }
}
