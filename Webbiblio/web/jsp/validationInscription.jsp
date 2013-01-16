<%-- 
    Document   : validationInscription
    Created on : 16 janv. 2013, 14:01:07
    Author     : stagiaire
--%>

<%@page import="entity.Personnes"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validation inscription</title>
    </head>
    <body>
        <h1>Validation inscription:</h1>
         <%!
        String lsNom;
        String lsPrenom;
        String lsAdresse;
        String lsMail;
        String lsLogin;
        String lsMdp;
        String lsProfil;
        %>
        Nom : 
        <strong>
        <%= lsNom=request.getParameter("nom")%>
        </strong><br>
        
        Prenom : 
        <strong>
        <%=lsPrenom=request.getParameter("prenom")%>    
        </strong><br>  
        adresse : 
        <strong>
        <%=lsAdresse=request.getParameter("adresse")%>
        </strong><br>
        
        Mail: 
        <strong>
        <%=lsMail=request.getParameter("mail")%>
        </strong><br>
        
        Login : 
        <strong>
        <%=lsLogin=request.getParameter("login")%>
        </strong><br>
        
        Mdp : 
        <strong>
        <%= lsMdp=request.getParameter("pass")%>
        </strong><br>
        
        Profil : 
       
        <strong>
        <%=lsProfil=request.getParameter("profil")%>
        </strong>
        <%
        Session session1=HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();
        Personnes p=new Personnes();
        p.setNom(lsNom);
        p.setPrenom(lsPrenom);
        p.setAdresse(lsAdresse);
        p.setEmail(lsMail);
        p.setLogin(lsLogin);
        p.setMdp(lsMdp);
        p.setProfil(lsProfil);
        session1.save(p);
        session1.getTransaction().commit();
        session1.close();
        
        %>
    </body>
</html>
