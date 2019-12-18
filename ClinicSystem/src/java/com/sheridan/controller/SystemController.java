package com.sheridan.controller;

import com.sheridan.model.Patient;
import com.sheridan.database.DBConnection;
import com.sheridan.model.Appointment;
import com.sheridan.model.AppointmentList;
import com.sheridan.model.Doctor;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DILJOT
 */
@WebServlet("/SystemController")
public class SystemController extends HttpServlet {

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    Patient patient = new Patient();
    Doctor doctor = new Doctor();

    private ArrayList<Appointment> appointList = new ArrayList<>();
    AppointmentList appList = new AppointmentList();

    @Override
    public void init() {

    }

    public SystemController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        DBConnection DBConn = new DBConnection();
        conn = DBConn.getConnections();

        String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("password");
        String button = request.getParameter("login");
        if (button.equals("Log-in")) {
            boolean login = false;
            try {
                String selectSQL = "SELECT * FROM users";
                ps = conn.prepareStatement(selectSQL);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String dbUsername = rs.getString("username");
                    String dbPassword = rs.getString("password");
                    int dbRole = Integer.parseInt(rs.getString("role"));
                    if (dbUsername.equals(inputUsername) && dbPassword.equals(inputPassword)) {

                        session.setAttribute("username", dbUsername);
                        session.setAttribute("password", dbPassword);
                        session.setAttribute("role", dbRole);
                        if (dbRole == 2) {
                            creatingPatient(dbUsername, dbPassword, dbRole, patient);
                            session.setAttribute("user", patient);
                        } else if (dbRole == 1) {
                            creatingDoctor(dbUsername, doctor);
                            session.setAttribute("user", doctor);
                        }
                        login = true;
                        session.setAttribute("isLoggedIn", true);
                        session.setAttribute("login", login);
                    } else {
                        session.setAttribute("isLoggedIn", false);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (login) {
                creatingAppointment(session, request);
                session.setAttribute("sesOhipNumber", patient.getOhipNumber());
                response.sendRedirect("home.jsp");
            } else {

                session.setAttribute("message", "Invalid username or password!"); // Will be available as ${message}
                response.sendRedirect("index.jsp");
            }

        } else {
            response.sendRedirect("register.jsp");
            request.getRequestDispatcher("register.jsp");
        }
    }

    private static void creatingDoctor(String dbUsername, Doctor doctor) {
        doctor.setLogin(dbUsername);

        try {
            String selectSQL = "SELECT * FROM practitioners WHERE Login = '" + dbUsername + "';";
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                doctor.setCPSO(Integer.parseInt(rs.getString("CPSO")));
                doctor.setFirstName(rs.getString("FirstName"));
                doctor.setMiddleInitials(rs.getString("MiddleInitials"));
                doctor.setLastName(rs.getString("LastName"));
                doctor.setLogin(rs.getString("Login"));
                doctor.setPracticeAddress(Integer.parseInt(rs.getString("PrimaryPracticeAddress")));
                doctor.setPracticeName(rs.getString("PracticeName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void creatingPatient(String dbUsername, String dbPassword, int dbRole, Patient patient) {
        //if (dbRole == 2) {
        patient.setUsername(dbUsername);
        patient.setPassword(dbPassword);
        patient.setRole(dbRole);
        try {
            String selectSQL = "SELECT * FROM addresses WHERE occupant = '" + dbUsername + "';";
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

            selectSQL = "SELECT * FROM phonenumbers WHERE UserName = '" + dbUsername + "';";
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                patient.setPhoneNumber(Long.parseLong(rs.getString("PhoneNumber")));
                patient.setPhoneType(rs.getString("PhoneType"));
            }

            selectSQL = "SELECT * FROM patients WHERE login = '" + dbUsername + "';";
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                patient.setOhipNumber(Long.parseLong(rs.getString("OHIPNumber")));
                patient.setOhipVersion(rs.getString("OHIPVersion"));
                patient.setFirstName(rs.getString("FirstName"));
                patient.setMiddleInitials(rs.getString("MiddleInitials"));
                patient.setLastName(rs.getString("LastName"));
                patient.setGender(rs.getString("Gender").charAt(0));
                patient.setDateOfBirth(rs.getString("DateOfBirth"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void creatingAppointment(HttpSession session, HttpServletRequest request) {

        appointList = appList.getAppointmentList(patient.getOhipNumber(), conn);
        session.setAttribute("appointList", appointList);
    }
}
