/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sheridan.controller;

import com.sheridan.model.Appointment;
import com.sheridan.database.DBAppointment;
import com.sheridan.database.DBConnection;
import com.sheridan.model.AppointmentList;
import com.sheridan.model.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet("/AppointmentController")
public class AppointmentController extends HttpServlet {

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private ArrayList<Appointment> appointList = new ArrayList<>();
    private Appointment appointment = new Appointment();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBConnection DBConn = new DBConnection();
        conn = DBConn.getConnections();
        HttpSession session = request.getSession(false);
        Patient patient = (Patient) session.getAttribute("user");
        Long ohipNumber = (Long) session.getAttribute("sesOhipNumber");
        String reasonForVisit = request.getParameter("reasonForVisit");
        String dateTime = request.getParameter("date");
        String hour = request.getParameter("hour");
        String mins = request.getParameter("mins");
        DBAppointment dbApp = new DBAppointment();
        dbApp.scheduleAppointmentDB(ohipNumber, reasonForVisit, dateTime, hour, mins);
        AppointmentList appList = new AppointmentList();
        appointList = appList.getAppointmentList(ohipNumber, conn);
        session.setAttribute("appointList", appointList);
        response.sendRedirect("appointments.jsp");
    }
}
