/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sheridan.database;

import com.sheridan.controller.UserController;
import com.sheridan.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DILJOT
 */
public class PatientDAO {
    
    DBConnection dbConn = new DBConnection();
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    
    public Patient getPatient(User user) throws Exception {
        Patient patient = new Patient();
        patient.setUsername(user.getUsername());
        patient.setPassword(user.getPassword());
        patient.setRole(user.getRole());
        try {
            conn = dbConn.getConnections();
            String selectSQL = "SELECT * FROM addresses WHERE occupant = '"
                    + patient.getUsername() + "';";
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                patient.setAddressId(Long.parseLong(rs.getString("addressId")));
                patient.setStreetLine1(rs.getString("streetLine1"));
                patient.setStreetLine2(rs.getString("streetLine2"));
                patient.setAptOrUnitNumber(rs.getString("aptOrUnitNumber"));
                patient.setCity(rs.getString("city"));
                patient.setProvince(rs.getString("province"));
                patient.setPostalCode(rs.getString("postalCode"));
                patient.setType(rs.getString("type"));
            }

            selectSQL = "SELECT * FROM phonenumbers WHERE UserName = '" + patient.getUsername() + "';";
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                patient.setPhoneNumber(Long.parseLong(rs.getString("PhoneNumber")));
                patient.setPhoneType(rs.getString("PhoneType"));
            }

            selectSQL = "SELECT * FROM patients WHERE login = '" + patient.getUsername() + "';";
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                patient.setOhipNumber(Long.parseLong(rs.getString("OHIPNumber")));
                patient.setOhipVersion(rs.getString("OHIPVersion"));
                patient.setFirstName(rs.getString("FirstName"));
                patient.setMiddleInitials(rs.getString("MiddleInitials"));
                patient.setLastName(rs.getString("LastName"));
                patient.setGender(rs.getString("Gender").charAt(0));
                patient.setDateOfBirth(LocalDate.parse(rs.getString("DateOfBirth")));
            }

        } catch (SQLException ex) {
            //Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Get Patient error!");
        } finally {
            dbConn.closeJDBCObjects(conn, ps, rs);
        }
        return patient;
    }
}
