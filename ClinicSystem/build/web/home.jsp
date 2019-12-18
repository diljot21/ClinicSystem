<%-- 
    Document   : home
    Created on : Nov 22, 2019, 3:41:13 PM
    Author     : DILJOT
--%>

<%@page import="com.sheridan.model.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>




    <head>
        <script type="text/javascript">
            var isLoggedIn = "<%= session.getAttribute("isLoggedIn")%>";
            if (isLoggedIn === true)
                window.location.href = "home.jsp";
            } else {
                window.location.href = "index.jsp";
            }
        </script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="styles.css"/>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <h1>Welcome to your personal homepage!</h1>
            <h1>Hello ${sessionScope.user.getFirstName()}</h1>



    </body>

</html>
