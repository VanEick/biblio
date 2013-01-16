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
        
        <script>
        function choixPdt(num){
        document.bib.id_produit.value=num;
        document.bib.submit();
        }
        </script>
        
               <form name="bib" action="commentaire.jsp" method="post">
               <input type="hidden" name="id_produit" value="0" />
               
        <%!   

        %>
        
        <%   
        try {
            // --- Connexion
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcConnexion = DriverManager.getConnection("jdbc:mysql://localhost/biblio","root","");

            // --- SELECT
            Statement lstSql = lcConnexion.createStatement();
            ResultSet lrs    = lstSql.executeQuery("SELECT id_produit, nom_produit, prix FROM produits WHERE prix != 0");
            StringBuilder lsbResultat = new StringBuilder("");

            lsbResultat.append("<table border='1' >");
            while(lrs.next()) {

                lsbResultat.append("<tr>");
                lsbResultat.append("<td>");
                lsbResultat.append(Integer.toString(lrs.getInt(1)));
                lsbResultat.append("</td><td>");
                lsbResultat.append("<a href='#' onclick='choixPdt("+Integer.toString(lrs.getInt(1))+")'>");
                lsbResultat.append(lrs.getString(2));
                lsbResultat.append("</a>");
                lsbResultat.append("</td><td>");
                lsbResultat.append(lrs.getString(3));
                lsbResultat.append(" €");
                //lsbResultat.append("</br>");
               // lsbResultat.append("</a>");
                lsbResultat.append("</td>");
                lsbResultat.append("</tr>");
                       
            }
            lsbResultat.append("</table>");
            out.println(lsbResultat.toString());
            // --- Deconnexion
            lrs.close();
            lcConnexion.close();
        }

        catch(Exception e) { out.println(e.getMessage()); }
        
        %>
        
    </body>
</html>
