<%-- 
    Document   : sidebar
    Created on : Nov 28, 2019, 7:14:40 PM
    Author     : DILJOT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="../resources/css/sidebar.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="mySidenav" class="dsidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="/ClinicSystem/patients/home.jsp">Home</a>
            <a href="/ClinicSystem/patients/userInformation.jsp">User Information</a>
            <a href="/ClinicSystem/patients/appointments.jsp">Appointments</a>
            <a href="/ClinicSystem/patients/schedAppointment.jsp">Schedule Appointment</a>
            <a href="/ClinicSystem/patients/cancelAppointment.jsp">Cancel Appointment</a>
            <form action="Logout.do" method="POST">
                <input type="submit" name="logout" value="Logout">
            </form>
        </div>

        <span style="font-size:30px; cursor:pointer" onclick="openNav()">&#9776; open</span>

        <script>
            function openNav() {
                document.getElementById("mySidenav").style.width = "250px";
            }

            function closeNav() {
                document.getElementById("mySidenav").style.width = "0";
            }
        </script>

    </body>
</html>
