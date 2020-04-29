/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sheridan.database;

import com.sheridan.model.Appointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DILJOT
 */
public class AppointmentDAO {
    
    DBConnection DBConn = new DBConnection();
    Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    
    public void scheduleAppointmentDB(Long ohipNumber, String reasonForVisit, String dateTime) {
        try {
            conn = DBConn.getConnections();
            ps = conn.prepareStatement("INSERT INTO appointments (Patient, ReasonForVisit, DateTime, IsPatientCheckedIn) VALUES (?,?,?, False)");
            ps.setLong(1, ohipNumber);
            ps.setString(2, reasonForVisit);
            ps.setString(3, dateTime);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Invalid input Schedule Appointment!");
        } finally {
            DBConn.closeJDBCObjects(conn, ps);
        }
    }
    
    public ArrayList<Appointment> getPatientAppointmentList(long ohipNumber) {
        ArrayList<Appointment> appointList = new ArrayList<>();
        try {
            conn = DBConn.getConnections();
            appointList.removeAll(appointList);
            ps = conn.prepareStatement("SELECT * FROM appointments WHERE Patient = ? ");
            ps.setLong(1, ohipNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                int apptNumber = Integer.parseInt(rs.getString("ApptNumber"));
                long patient = Long.parseLong(rs.getString("Patient"));
                String reasonForVisit = rs.getString("ReasonForVisit");
                String dateTime = rs.getString("DateTime");
                String isCheckedIn = rs.getString("IsPatientCheckedIn");
                appointList.add(new Appointment(apptNumber, patient, reasonForVisit, dateTime, isCheckedIn));
            }
        } catch (SQLException ex) {
            System.out.println("Error AppointmentList!");
        } finally {
            DBConn.closeJDBCObjects(conn, ps);
        }

        return appointList;
    }
}
