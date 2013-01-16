<%-- 
    Document   : FicProduit
    Created on : 16 janv. 2013, 15:46:03
    Author     : stagiaire
--%>

<%@page import="entity.Produits"%>
<%@page import="java.util.List"%>
<%@page import="daohelper.ProduitsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Fiche produit</h1>
        
        <form name="bib" action="FicProduit.jsp" method="POST" >
            <input type="hidden" name="id_produit" value="0" />
   <%
   int id_pdt = Integer.parseInt(request.getParameter("id_produit"));
     ProduitsHelper Vh = new ProduitsHelper();
     List listV = Vh.getFicheProduit(id_pdt);
     //out.print("taille : "+listV.size());
     
    out.print("<table border='1'>");
    for(Object enr : listV) {
        Produits pdt = (Produits)enr;
        out.print("<tr><td>"+pdt.getIdProduit()+"</td><td>"+pdt.getNomProduit()+"</td><td></tr>\n");
        }
    out.print("</table><br/>");

   %>
   </form>
    </body>
</html>
