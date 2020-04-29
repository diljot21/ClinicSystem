<%-- 
    Document   : index
    Created on : Nov 22, 2019, 12:31:27 PM
    Author     : DILJOT
--%>
<%!
    String usernameTaken;
%>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
        <title>Mercury Medical Clinic</title>
        <link rel="stylesheet" type="text/css" href="styles.css"/>
    </head>
    <body>

        <%-- <jsp:include page="header.jsp"></jsp:include> --%>

            <div align="center">
                <h1>Mercury Medical Clinic</h1>
                <h3>Log In Page</h3>
                <div class="form">
                    <form class="container" action="SystemController" method="POST">
                        <table>
                            <tr>
                                <td>
                                    Username:
                                </td>
                                <td>
                                    <input type="text" name="username" required="">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Password:
                                </td>
                                <td>
                                    <input type="password" name="password" required="">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input class="waves-effect waves-light btn" type="submit" name="login" value="Log-in"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <br>
                                    <a href="register.jsp">Register</a>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <left><p style="color:red">${message}</p></left>
            </div>
        </div>
    </body>
</html>
