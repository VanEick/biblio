<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML>

<!-- _modele.jsp -->

<f:view>
    <html>
        <head>
            <meta charset="utf-8" />
            <title>Vente en ligne de livres, Cd audio, Films </title>
            <link href="../css/bootstrap.css" rel="stylesheet">
            <link href="../css/bootstrap-responsive.css" rel="stylesheet">
            <link href="../css/biblio.css" rel="stylesheet" type="text/css" />
        </head>

        <body>
            <jsp:include page="_entete.jsp" flush="true" />
            <div class="row-fluid">
                   <div class="span12">
                        <jsp:include page="_sommaire.jsp" flush="true" />
                         <div class="span9" id="contenu">
                             
                                <h3><h:outputText value="Modèle"/></h3>

                        </div>
                   </div>
            </div>                

            <jsp:include page="_pied.jsp" flush="true" />
        </body>
    </html>
</f:view>
