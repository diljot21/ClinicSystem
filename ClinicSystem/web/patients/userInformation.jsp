<%-- 
    Document   : userInformation
    Created on : Nov 28, 2019, 10:06:18 PM
    Author     : DILJOT
--%>

<%@page import="com.sheridan.model.Patient" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Information Page</title>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"></jsp:include>
        <h1>User Information</h1><br><br>
        <form action="UserUpdate" method="post">
            First Name: <input type="text"  pattern="[a-zA-Z]*$"  value="${sessionScope.user.getFirstName()}" name="firstName"/><br>
            Last Name: <input type="text" pattern="[a-zA-Z]*$"  value="${sessionScope.user.getLastName()}" name="lastName"/><br>
            Middle Initials: <input type="text" pattern="^[A-Z]$" value="${sessionScope.user.getMiddleInitials()}" name="middleInitials"/><br>
            Password: <input type="text" value="${sessionScope.user.getPassword()}" name="password"/><br>
            OHIP Number: <input readonly value="${sessionScope.user.getOhipNumber()}" name="ohipNumber" /><br>
            OHIP Version: <input type="text" pattern="^[a-zA-Z]{2}$" value="${sessionScope.user.getOhipVersion()}" name="ohipVersion"/><br>
            Gender: ${sessionScope.user.getGender()}<br>
            Date of Birth: ${sessionScope.user.getDateOfBirth()}<br>
            Street Line1: ${sessionScope.user.getStreetLine1()}<br>
            Street Line2: ${sessionScope.user.getStreetLine2()}<br>
            Apt or Unit No.: ${sessionScope.user.getAptOrUnitNumber()}<br>
            City: ${sessionScope.user.getCity()}<br>
            Province: ${sessionScope.user.getProvince()}<br>
            Postal Code: ${sessionScope.user.getPostalCode()}<br>
            Address Type: ${sessionScope.user.getType()}<br>
            Phone Number: ${sessionScope.user.getPhoneNumber()}<br>
            <input type="submit" name="Apply"/>
        </form>
    </body>
</html>
