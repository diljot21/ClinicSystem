package com.sheridan.controller;

import com.sheridan.database.DBConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/DBController")
public class DBController extends HttpServlet {

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Connecting to the database
        DBConnection DBConn = new DBConnection();
        conn = DBConn.getConnections();
        
        




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }




}
