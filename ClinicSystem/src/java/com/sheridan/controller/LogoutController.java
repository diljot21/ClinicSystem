/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sheridan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sheridan.model.Patient;

/**
 *
 * @author DILJOT
 */
//@WebServlet(name = "LogoutController", urlPatterns = {"/LogoutController"})
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null){
            session = request.getSession(false);
        } else {
            response.sendRedirect("index.jsp");
        }
        
        if(session.getAttribute("isLoggedIn")!=null || session.getAttribute("isLoggedIn").equals(true)){
            session.setAttribute("isLoggedIn", false);
            session.invalidate();
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
