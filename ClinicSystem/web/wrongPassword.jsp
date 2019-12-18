<%-- 
    Document   : wrongPassword
    Created on : Nov 22, 2019, 3:39:00 PM
    Author     : DILJOT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <left><p style="color:red">Wrong username or password!</p></left>

    <%
        request.getServletContext().getRequestDispatcher("/index.jsp").include(request,
                response);
    %>
</body>
</html>
