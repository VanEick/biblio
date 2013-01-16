<%-- 
    Document   : commentaire
    Created on : 15 janv. 2013, 16:58:01
    Author     : stagiaire
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Enumeration"%>
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
    </head>
    <body>
        <h3>Visualisation du fichier</h3>

        <h4>Selecion du fichier</h4>
        <!-- <form action="AuteursInsertConfirmation.jsp" method="post">
             <label class="id_fichier">Id </label>
             <input type="text" name="id_fichier" value="2" />
             <input type="submit" />
         </form> -->

    


        <%
        int id_pdt = Integer.parseInt(request.getParameter("id_produit").toString()); 
        %>
        <!--form action="commentaire_maj.jsp" method="post"-->
            <%
     //       int pdt_id = Integer.parseInt(request.getAttribute("id_produit").toString());

                
            
            try {
                    // --- Connexion
                    Class.forName("org.gjt.mm.mysql.Driver");
                    Connection lcConnexion = DriverManager.getConnection("jdbc:mysql://localhost/biblio", "root", "");

                    // --- SELECT
                    Statement lstSql = lcConnexion.createStatement();
                    ResultSet lrs = lstSql.executeQuery("SELECT * FROM produits WHERE id_produit="+id_pdt+" ");
                    StringBuilder lsbResultat = new StringBuilder("");

                    while (lrs.next()) {

                        lsbResultat.append("id produits : ");
                        lsbResultat.append(lrs.getString(1));
                        lsbResultat.append("<br/>");
                        lsbResultat.append("titre : ");
                        lsbResultat.append(lrs.getString(2));
                        lsbResultat.append("<br/>");
                        lsbResultat.append("auteur : ");
                        lsbResultat.append(lrs.getString(4));
                        lsbResultat.append("<br/>");
                        lsbResultat.append("descripion : ");
                        lsbResultat.append(lrs.getString(6));
                        lsbResultat.append("<br/>");
                        lsbResultat.append("<br/>");


                    }
                    out.println(lsbResultat.toString());
                    // --- Deconnexion
                    lrs.close();
                    lcConnexion.close();
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            %>
        <!--/form-->

        <form action="produit.jsp" method="post">
            <%
                try {
                    // --- Connexion
                    Class.forName("org.gjt.mm.mysql.Driver");
                    Connection lcConnexion = DriverManager.getConnection("jdbc:mysql://localhost/biblio", "root", "");

                    // --- SELECT
                    Statement lstSql = lcConnexion.createStatement();
                    ResultSet lrs = lstSql.executeQuery("SELECT * FROM commentaires WHERE id_produit="+id_pdt+" AND etat='valide'");
                    StringBuilder lsbResultat = new StringBuilder("");

                    while (lrs.next()) {

                        lsbResultat.append("Commentaires valiés :  ");
                        lsbResultat.append(lrs.getString(2));
                        lsbResultat.append("<br/>");
                        lsbResultat.append(lrs.getString(3));
                        lsbResultat.append("<br/>");



                    }
                    out.println(lsbResultat.toString());
                    // --- Deconnexion
                    lrs.close();
                    lcConnexion.close();
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            %>
        </form>

    </body>
</html>
