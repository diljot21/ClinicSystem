<%-- 
    Document   : header
    Created on : Nov 22, 2019, 4:45:59 PM
    Author     : DILJOT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body>

        <%
            session = request.getSession(false);
            if (session.getAttribute("isLoggedIn") == null || session.getAttribute("isLoggedIn").equals(false)) {
                response.sendRedirect("index.jsp");
            }
        %>
        
        <nav class="navbar navbar-dark bg-dark">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <img src="logo.JPG" width="200" height="65px" class="d-inline-block align-top" alt="">
                </a>
            </nav>
        </nav>

    <c:choose>
        <c:when test="${sessionScope.user.getUsername()!=null}">
            <jsp:include page="sidebar.jsp"></jsp:include>
        </c:when>
    </c:choose>
</body>
</html>
