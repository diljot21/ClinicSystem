<%-- 
    Document   : register
    Created on : Nov 22, 2019, 2:02:23 PM
    Author     : DILJOT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.sheridan.model.Patient" %>

<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" type="text/css" href="styles.css"/>
    </head>
    <body>
        <h1 align="center">Make an Account!</h1>
    <left><p style="color:red">${usernameTaken}</p></left>
    <table align="center">
        <form action="UserController" method="POST">
            <tr>
                <td>Username:</td>
                <td><input type="text" pattern="^[a-zA-Z0-9_.-]*$" name="username" autocomplete="on" required/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required="on"/></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="firstName" pattern="[a-zA-Z]*$" autocomplete="on" required/></td>
            </tr>
            <tr>
                <td>Middle Initials:</td>
                <td><input type="text" name="middleInitials" pattern="^[A-Z]$" autocomplete="on"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" pattern="[a-zA-Z]*$" name="lastName" autocomplete="on" required=""/></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <select name="gender" autocomplete="on">
                        <option name="gender" value="M">Male</option>
                        <option name="gender" value="F">Female</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><input type="text" placeholder="YYYY-MM-DD" pattern="\d{4}-\d{2}-\d{2}" required  autocomplete="on" name="dateOfBirth"/></td>
            </tr>
            <tr>
                <td>Apartment or Unit No:</td>
                <td><input type="text" name="aptOrUnitNumber" pattern="^\d+[a-zA-Z]*$" autocomplete="on" required="on"/>
                </td>
            </tr>
            <tr>
                <td>StreetLine1:</td>
                <td><input type="text" name="streetLine1" required="" autocomplete="on" required/></td>
            </tr>
            <tr>
                <td>StreetLine2:</td>
                <td><input type="text" name="streetLine2"/></td>
            </tr>

            <tr>
                <td>City</td>
                <td><input type="text" name="city" pattern="[a-zA-Z]*$" required="" autocomplete="on"/></td>
            </tr>
            <tr>
                <td>Province</td>
                <td>
                    <select name="province" value="" required="">
                        <option value="ON">ON</option>
                        <option value="NL">NL</option>
                        <option value="PE">PE</option>
                        <option value="NS">NS</option>
                        <option value="QC">QC</option>
                        <option value="MB">ON</option>
                        <option value="SK">SK</option>
                        <option value="AB">AB</option>
                        <option value="BC">BC</option>
                        <option value="YT">YT</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Postal Code</td>
                <td><input type="text" name="postalCode" pattern="^[A-Za-z]\d[A-Za-z][ -]?\d[A-Za-z]\d$" required=""
                           autocomplete="on"/></td>
            </tr>
            <tr>
                <td>Type</td>
                <td>
                    <select name="type" autocomplete="on">
                        <option value="Home">Home</option>
                        <option value="Office">Office</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Phone Number</td>
                <td><input type="number" name="phoneNumber" pattern="^[0-9]{7,10}$" autocomplete="on" required=""/></td>
            </tr>
            <tr>
                <td>Phone Type</td>
                <td>
                    <select name="phoneType" autocomplete="on">
                        <option value="Home">Home</option>
                        <option value="Office">Office</option>
                        <option value="Work">Work</option>
                        <option value="Fax">Fax</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>OHIP Number:</td>
                <td><input type="text" name="ohipNumber" pattern="^\d{10}$" autocomplete="on" required=""/></td>
            </tr>
            <tr>
                <td>OHIP Version:</td>
                <td><input type="text" name="ohipVersion" pattern="^[a-zA-Z]{2}$" autocomplete="on" required=""/></td>
            </tr>
            <tr>
                <td>
                    <a href="/ClinicSystem/index.jsp">CANCEL</a>
                </td>
                <td>
                    <input type="submit" name="register" value="submit"/>
                </td>

            </tr>
        </form>
    </table>
</body>
</html>
