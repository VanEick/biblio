<%-- 
    Document   : SelProduits
    Created on : 15 janv. 2013, 17:08:19
    Author     : stagiaire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>;
<%@page import="daohelper.*"%>;
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function voirPdt(num){
                document.bib.id_produit.value=num;
                document.bib.submit();
            }
            
        </script>
    </head>
    <body>
        <h1>Biblio</h1>
        
        
        <h3>Liste des Produits</h3>
        <form name="bib" action="FicProduit.jsp" method="POST" >
            <input type="hidden" name="id_produit" value="0" />
   <%
     ProduitsHelper Vh = new ProduitsHelper();
     List listV = Vh.getProduits();
     //out.print("taille : "+listV.size());
     
    out.print("<table border='1'>");
    for(Object enr : listV) {
        Produits pdt = (Produits)enr;
       // Object[] tCol = {pdt.getIdProduit(), pdt.getNomProduit()};
        //out.print("<tr><td>"+tCol[0].toString()+"</td><td>"+tCol[1].toString()+"</td><td></tr>\n");
      //  out.print("<tr><td>"+pdt.getIdProduit()+"</td><td>"+pdt.getNomProduit()+"</td><td></tr>\n");
        out.print("<tr><td>"+pdt.getIdProduit()+"</td><td><a href='#' onclick='voirPdt("+pdt.getIdProduit()+")' >"+pdt.getNomProduit()+"</a></td><td></tr>\n");
        }
    out.print("</table><br/>");

   %>
   </form>
    </body>
</html>
