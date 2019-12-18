/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sheridan.controller;

import com.sheridan.database.DBConnection;
import com.sheridan.model.Appointment;
import com.sheridan.model.AppointmentList;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DILJOT
 */
@WebServlet(name = "CancelController", urlPatterns = {"/CancelController"})
public class CancelController extends HttpServlet {

    DBConnection DBConn = new DBConnection();

    PreparedStatement ps = null;
    ArrayList<Appointment> appointList = new ArrayList<>();
    Connection conn = DBConn.getConnections();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long ohipNumber = (Long) session.getAttribute("sesOhipNumber");

        try {
            int numRowsAffected = 0;
            String cancelIdNum = request.getParameter("cancelIdNum");
            System.out.println("in1");
            System.out.println("in2");
            ps = conn.prepareStatement("DELETE FROM appointments WHERE ApptNumber = ? AND IsPatientCheckedIn = False AND Patient = ?;");
            ps.setString(1, cancelIdNum);
            ps.setLong(2, ohipNumber);
            System.out.println("in3");
            numRowsAffected = ps.executeUpdate();
            System.out.println("in4");
            if (numRowsAffected == 0) {
                System.out.println("in5");
                session.setAttribute("cancelMessage", "Enter valid Appointment Number!"); // Will be available as ${message}
                response.sendRedirect("cancelAppointment.jsp");
            } else {
                System.out.println("in6");
                session.setAttribute("cancelMessage", "Your selected appointment has been canceled!"); // Will be available as ${message}
                AppointmentList appList = new AppointmentList();

                appointList = appList.getAppointmentList(ohipNumber, conn);
                session.setAttribute("appointList", appointList);
                response.sendRedirect("cancelAppointment.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
