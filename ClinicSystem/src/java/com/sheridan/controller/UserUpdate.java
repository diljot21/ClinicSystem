package com.sheridan.controller;

import com.sheridan.database.DBConnection;
import javafx.scene.control.Button;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        DBConnection DBConn = new DBConnection();
        conn = DBConn.getConnections();
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String middleInitials = request.getParameter("middleInitials");
        String password = request.getParameter("password");
        String ohipVersion = request.getParameter("ohipVersion");
        String ohipNumber = request.getParameter("ohipNumber");

        try {
            ps = conn.prepareStatement(
                    "UPDATE patients set firstName=?, lastName=?, middleInitials=? WHERE ohipNumber=?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, middleInitials);
            ps.setString(4, ohipNumber);
            ps.executeUpdate();
            ps = conn.prepareStatement(
                    "UPDATE users inner join patients set users.password=? where users.username=patients.login " +
                            "AND ohipNumber=?");
            ps.setString(1, password);
            ps.setString(2, ohipNumber);
            ps.executeUpdate();
            response.sendRedirect("userInformation.jsp");
        } catch (SQLException e) {
            pw.write("Error occurred");
            e.printStackTrace();
        }
    }
}
