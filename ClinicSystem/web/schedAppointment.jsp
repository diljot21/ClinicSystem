<%-- 
    Document   : schedAppointment
    Created on : Dec 1, 2019, 12:43:17 AM
    Author     : DILJOT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule Appointment</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h1>Schedule Appointment</h1>
        <form action="AppointmentController" method="POST">
            <table>
                <tr>
                    <td>
                        Reason For Visit:
                    </td>
                    <td>
                        <input type="text" name="reasonForVisit">
                    </td>
                </tr>
                <tr>
                    <td>
                        Date
                    </td>
                    <td>
                        <input type="date" name="date" required="">
                    </td>
                </tr>
                <tr>
                    <td>
                        Time
                    </td>
                    <td>
                        <input type="number" name="hour" max="24" min="0" required="">HH
                        <input type="number" name="mins" max="60" min="0" required="">MM
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="schedAppoint">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
