<%-- 
    Document   : cancelAppointment
    Created on : Dec 1, 2019, 8:47:06 PM
    Author     : DILJOT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancel Appointment</title>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"></jsp:include>
            <h1>Cancel Appointment</h1>
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
                <c:if test="${appointment.isCheckedIn == '0'}">
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
                </c:if>
            </c:forEach>
            <form action="CancelController" method="POST">
                <tr>
                    <td>
                        Select Appointment Number to Cancel:
                    </td>
                    <td>
                        <input type="number" name="cancelIdNum" min="0">
                    </td>
                    <td>
                        <input type="submit" name="submitCancelApp" value="Cancel Appointment">
                    </td>
                    ${cancelMessage}
                    
                </tr>
            </form>
        </table>
    </body>
</html>
