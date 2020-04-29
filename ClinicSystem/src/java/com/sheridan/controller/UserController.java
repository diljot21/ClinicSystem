package com.sheridan.controller;

import com.sheridan.database.*;
import com.sheridan.model.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author DILJOT
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private ArrayList<Appointment> appointList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String middleInitials = request.getParameter("middleInitials");
        String lastName = request.getParameter("lastName");
        char gender = request.getParameter("gender").charAt(0);
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
        String streetLine1 = request.getParameter("streetLine1");
        String streetLine2 = request.getParameter("streetLine2");
        String aptOrUnitNumber = request.getParameter("aptOrUnitNumber");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String postalCode = request.getParameter("postalCode");
        String type = request.getParameter("type");
        long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
        String phoneType = request.getParameter("phoneType");
        long ohipNumber = Long.parseLong(request.getParameter("ohipNumber"));
        String ohipVersion = request.getParameter("ohipVersion");

        try {
            Patient patient = new Patient(username, 2, password,
                    streetLine1, streetLine2, aptOrUnitNumber, city, province,
                    postalCode, type, phoneNumber, phoneType, ohipNumber, ohipVersion, firstName,
                    lastName, middleInitials, gender, dateOfBirth);

            UserDAO userDao = new UserDAO();

            boolean register = userDao.checkUsernameValidity(patient.getUsername());

            if (register = true) {
                // Inserting into users table
                userDao.addPatient(patient);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("usernameTaken", "Username already taken"); // Will be available as ${message}
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("Exception User Controller");
        }
    }

}
