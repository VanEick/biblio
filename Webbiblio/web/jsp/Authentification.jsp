<%-- 
    Document   : Authentification
    Created on : 16 janv. 2013, 12:04:43
    Author     : stagiaire   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification:</title>
    </head>
    <body>
        <%!
        String lsMessage;
        %>
         
        <h1>Authentification:</h1>
        <form  method="post">
        <label class="login">Login: </label>
        <input type="text" name="login" /><br>
        <label class="pass">Password: </label>
        <input type="password" name="pass" /><br>
        
        <%
        if(request.getParameter("login") != null) {
            if(request.getParameter("login").toString().trim().equals("") || request.getParameter("pass").toString().trim().equals("")) {
                out.println("Toutes les saisies sont obligatoires");
//                String lsDestination = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +
//                "/jsp/Authentification.jsp";
//                response.sendRedirect(lsDestination);
            }
            else {
                String lsDestination = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +
               "/jsp/validationAuthentification.jsp";
             response.sendRedirect(lsDestination);
               request.getParameter("login");
               request.getParameter("mdp");
            }
        }
    %>
    <br>
        <input type="submit" value="se loguer">
        </form>
    </body>
</html>
