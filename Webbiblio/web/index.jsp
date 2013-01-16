<%-- 
    Document   : index
    Created on : 16 janv. 2013, 11:54:53
    Author     : stagiaire
--%>

<%@page import="helper.HelloAnalyticsApi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! HelloAnalyticsApi d;
        %>

        <%
            d = new HelloAnalyticsApi();
                        out.println(d);
        %>
        <h1>Hello World!</h1>
    </body>
</html>
