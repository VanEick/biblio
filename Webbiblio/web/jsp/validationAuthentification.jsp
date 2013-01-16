<%-- 
    Document   : validationAuthentification
    Created on : 16 janv. 2013, 12:09:10
    Author     : stagiaire    
--%>

<%@page import="java.util.Iterator"%>
<%@page import="entity.Personnes"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="org.hibernate.Session"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.Hibernate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>validation Authentification:</title>
    </head>
    <body>
        <h1>validation  Authentification:</h1>
        
        <%!
        String lsLogin;
        String lsMdp;
        %>
        <%= lsLogin=request.getParameter("login")%>
        <%= lsMdp=request.getParameter("pass")%>
        
        <%
        Session sess=HibernateUtil.getSessionFactory().openSession();
     
        Query lsReq=sess.createQuery("FROM Personnes where login='"+lsLogin+"'");
        List lsRs=lsReq.list();
        out.print(lsRs);
       
        // Récupération d'un Iterator sur maListe
        Iterator iter = lsRs.iterator();
     // Parcours de la liste et affichage des éléments
       while (iter.hasNext()) {
           String elem = (String) iter.next();
              out.println(elem.toString());
        }
        
        sess.close();
        
        
        
        %>
    </body>
</html>
