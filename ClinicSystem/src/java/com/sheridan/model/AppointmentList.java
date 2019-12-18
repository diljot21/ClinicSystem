package com.sheridan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DILJOT
 */
public class AppointmentList {

    private ArrayList<Appointment> appointList = new ArrayList<>();
    private Appointment appointment = new Appointment();
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public ArrayList<Appointment> getAppointmentList(long ohipNumber, Connection conn) {
        try {
            //String temp = (String)session.getAttribute("user.getOhipNumber");
            appointList.removeAll(appointList);
            String temp = Long.toString(ohipNumber);
            ps = conn.prepareStatement("SELECT * FROM appointments WHERE Patient = " + temp + " ");
            //ps.setString(1, temp);
            rs = ps.executeQuery();
            while (rs.next()) {
                int apptNumber = Integer.parseInt(rs.getString("ApptNumber"));
                long patient = Long.parseLong(rs.getString("Patient"));
                String reasonForVisit = rs.getString("ReasonForVisit");
                String dateTime = rs.getString("DateTime");
                String isCheckedIn = rs.getString("IsPatientCheckedIn");
                appointment = new Appointment(apptNumber, patient, reasonForVisit, dateTime, isCheckedIn);
                appointList.add(appointment);
            }
        } catch (SQLException ex) {
            System.out.println("Error AppointmentList!");
        }

        return appointList;
    }
}
