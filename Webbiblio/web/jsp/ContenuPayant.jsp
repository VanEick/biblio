<%-- 
    Document   : ContenuPayant
    Created on : 15 janv. 2013, 17:13:20
    Author     : stagiaire
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payants</title>
    </head>
    <body>
        <h1>Payants</h1>
        
        <%!   

        %>
        
        <%   
        try {
            // --- Connexion
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcConnexion = DriverManager.getConnection("jdbc:mysql://localhost/biblio","root","");

            // --- SELECT
            Statement lstSql = lcConnexion.createStatement();
            ResultSet lrs    = lstSql.executeQuery("SELECT nom_produit, prix FROM produits WHERE prix != 0");
            StringBuilder lsbResultat = new StringBuilder("");

            while(lrs.next()) {

                lsbResultat.append(lrs.getString(1));
                lsbResultat.append(" - ");
                lsbResultat.append(lrs.getString(2));
                lsbResultat.append(" €");
                lsbResultat.append("</br>");
                lsbResultat.append("</a>");
                       
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
