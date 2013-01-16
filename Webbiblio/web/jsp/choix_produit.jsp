<%-- 
    Document   : produit
    Created on : 15 janv. 2013, 16:58:01
    Author     : stagiaire
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <script>
        function choixPdt(num){
        document.bib.id_produit.value=num;
        document.bib.submit();
        }
        
    </script>
    </head>
    <body>
        <h1>Visualisaion du fichier</h1>
           <form name="bib" action="commentaire.jsp" method="post">
               <input type="hidden" name="id_produit" value="0" />
        <%
        try {
            // --- Connexion
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcConnexion = DriverManager.getConnection("jdbc:mysql://localhost/biblio","root","");

            // --- SELECT
            Statement lstSql = lcConnexion.createStatement();
            ResultSet lrs    = lstSql.executeQuery("SELECT id_produit, nom_produit FROM produits");
            StringBuilder lsbResultat = new StringBuilder("");
            
            
            
            while(lrs.next()) {
                lsbResultat.append("<a href='#' onclick='choixPdt("+Integer.toString(lrs.getInt(1))+")'>");
                lsbResultat.append(Integer.toString(lrs.getInt(1)));
                lsbResultat.append("-");
                lsbResultat.append(lrs.getString(2));
                lsbResultat.append("-");
                lsbResultat.append("</a>");
                       
            }
            out.println(lsbResultat.toString());
            // --- Deconnexion
            lrs.close();
            lcConnexion.close();
        }

        catch(Exception e) { out.println(e.getMessage()); }
    %>
           </form>
    </body>
</html>
