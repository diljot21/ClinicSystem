package com.sheridan.database;

import com.sheridan.controller.SystemController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DILJOT
 */
public class DBAppointment {

    DBConnection DBConn = new DBConnection();
    Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public void scheduleAppointmentDB(Long ohipNumber, String reasonForVisit, String date, String hour, String mins) {
        conn = DBConn.getConnections();
        try {
            ps = conn.prepareStatement("INSERT INTO appointments (Patient, ReasonForVisit, DateTime, IsPatientCheckedIn) VALUES (?,?, '" + date + " " + hour + ":" + mins +":00', False)");
            ps.setLong(1, ohipNumber);
            ps.setString(2, reasonForVisit);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Invalid input Schedule Appointment!");
        }
    }

}
