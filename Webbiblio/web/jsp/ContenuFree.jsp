<%-- 
    Document   : ContenuFree
    Created on : 15 janv. 2013, 17:12:32
    Author     : stagiaire
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Enumeration"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="entity.Produits"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="util.HibernateUtil"%>
<%@page import="daohelper.*"%>

<%@page import="org.apache.el.lang.FunctionMapperImpl.Function"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gratuits</title>
    </head>
    <body>
        <h1>Gratuits</h1>
        
        <%!   

        %>
        
        <%   
        try {
            // --- Connexion
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcConnexion = DriverManager.getConnection("jdbc:mysql://localhost/biblio","root","");

            // --- SELECT
            Statement lstSql = lcConnexion.createStatement();
            ResultSet lrs    = lstSql.executeQuery("SELECT nom_produit, prix FROM produits WHERE prix = 0");
            StringBuilder lsbResultat = new StringBuilder("");

            while(lrs.next()) {

                lsbResultat.append(lrs.getString(1));
                lsbResultat.append(" - ");
                lsbResultat.append(" </a> ");
                       
            }
            out.println(lsbResultat.toString());
            // --- Deconnexion
            lrs.close();
            lcConnexion.close();
        }

        catch(Exception e) { out.println(e.getMessage()); }
        
        %>
        
    </body>
</html>
