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
        
        <%!   
        Session session = null;
        private String lsPrix, lstSql;
        String lsMessage = "";
        ResultSet  lrs = null;

        private String genererSelect(HttpServletRequest rq, String tb ){
        String lsSel= "SELECT * FROM "+ tb +" WHERE ";
        Enumeration attributsUrl = rq.getParameterNames();
        while(attributsUrl.hasMoreElements()) {
            String lsNomAttribut = (String)attributsUrl.nextElement();
            String lsValeurAttribut = rq.getParameter(lsNomAttribut);
            lsSel+=lsNomAttribut +"='"+lsValeurAttribut+"' AND ";
            }
        if(lsSel.endsWith("AND ")) lsSel=lsSel.substring(0, lsSel.length()-4);
        return lsSel;
    } 

        %>
        
        <%   
        // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
        this.session = HibernateSession.getSessionFactory().openSession();
        
        Connexion cnx = new Connexion();
        String r = cnx.seConnecter("biblio", "root", "");
        //Connection cn = cnx.getConnexion();
        //Connection cn = (Connection)session.getAttribute("connexion");
        
        
               
        // --- Déclarations
        Statement  lstSql      = null;
        ResultSet  lrs         = null;
        StringBuilder lsbContenu = new StringBuilder("");
        //lstSql = cn.createStatement();
        lsMessage += genererSelect(request,"prix");
        lrs = lstSql.executeQuery(lsMessage);

        while(lrs.next()) {
            lsMessage=lsPrix=lrs.getString(1);
           }
        out.print(lsMessage);
        %>
    </head>
    <body>
        <h1>Gratuits</h1>
    </body>
</html>
