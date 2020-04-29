<%-- 
    Document   : appointments
    Created on : Nov 29, 2019, 2:41:07 PM
    Author     : DILJOT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointments</title>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"></jsp:include>
        <h1>Appointments</h1>

        <table>
            <tr>
                <td>
                    Appointment Number
                </td>
                <td>
                    Reason For Visit
                </td>
                <td>
                    Date and Time
                </td>
                <td>
                    Appointment Status
                </td>
            </tr>
            <c:forEach items="${appointList}" var="appointment">
                <tr>
                    <td>
                        ${appointment.apptNumber}
                    </td>
                    <td>
                        ${appointment.reasonForVisit}
                    </td>
                    <td>
                        ${appointment.dateTime}
                    </td>
                    <td>
                        ${appointment.isCheckedIn}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
