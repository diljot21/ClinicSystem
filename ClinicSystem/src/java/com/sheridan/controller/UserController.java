package com.sheridan.controller;

import com.sheridan.database.DBConnection;
import com.sheridan.model.Appointment;
import com.sheridan.model.AppointmentList;
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
import java.util.ArrayList;

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

        boolean register;

        // Connecting to the database
        DBConnection DBConn = new DBConnection();
        conn = DBConn.getConnections();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String middleInitials = request.getParameter("middleInitials");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String streetLine1 = request.getParameter("streetLine1");
        String streetLine2 = request.getParameter("streetLine2");
        String aptOrUnitNumber = request.getParameter("aptOrUnitNumber");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String postalCode = request.getParameter("postalCode");
        String type = request.getParameter("type");
        String phoneNumber = request.getParameter("phoneNumber");
        String phoneType = request.getParameter("phoneType");
        String ohipNumber = request.getParameter("ohipNumber");
        String ohipVersion = request.getParameter("ohipVersion");

        try {
            String selectSQL = "SELECT * FROM users";
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                String dbUsername = rs.getString("username");
                if (dbUsername.equals(username)) {
                    register = false;
                    request.setAttribute("usernameTaken", "Username already taken"); // Will be available as ${message}
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            }
        } catch (SQLException ex) {
            System.out.println("username!");
        }

        if (register = true) {
            // Inserting into users table
            try {
                ps = conn.prepareStatement("INSERT INTO users (username, password, role) VALUES (?,?,?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, "2");

                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Invalid input users!");
            }

            // Inserting into addresses table
            try {
                ps = conn.prepareStatement("INSERT INTO addresses (streetLine1, streetLine2, aptOrUnitNumber, city, province, postalCode, type, occupant) "
                        + "VALUES (?,?,?,?,?,?,?,?)");
                ps.setString(1, streetLine1);
                ps.setString(2, streetLine2);
                ps.setString(3, aptOrUnitNumber);
                ps.setString(4, city);
                ps.setString(5, province);
                ps.setString(6, postalCode);
                ps.setString(7, type);
                ps.setString(8, username);

                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Invalid input addresses!");
            }

            // Inserting into phone number table
            try {
                ps = conn.prepareStatement("INSERT INTO phonenumbers(PhoneNumber, UserName, PhoneType) VALUES (?,?,?)");
                ps.setString(1, phoneNumber);
                ps.setString(2, username);
                ps.setString(3, phoneType);

                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Invalid input phonenumbers!");

            }

            //inserting into patients table
            try {
                ps = conn.prepareStatement("INSERT INTO patients(OHIPNumber, OHIPVersion, FirstName, MiddleInitials, LastName, Login, Gender, DateOfBirth) "
                        + "VALUES (?,?,?,?,?,?,?,?)");
//            INSERT INTO patients(OHIPNumber, OHIPVersion, FirstName, MiddleInitials, LastName, Login, Gender, DateOfBirth)
//            VALUES (1234366669, "LC", "robin", NULL, "Lansiquot", "whatthefuck", "M", "1991-12-09");

                ps.setString(1, ohipNumber);
                ps.setString(2, ohipVersion);
                ps.setString(3, firstName);
                ps.setString(4, middleInitials);
                ps.setString(5, lastName);
                ps.setString(6, username);
                ps.setString(7, gender);
                ps.setString(8, dateOfBirth);

                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Invalid input Patients!");
            }

            DBConnection.closeJDBCObjects(conn, ps);

            response.sendRedirect("index.jsp");
        }
        
        
    }

}
