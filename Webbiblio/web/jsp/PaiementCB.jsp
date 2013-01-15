<%-- 
    Document   : PaiementCB
    Created on : 15 janv. 2013, 20:21:36
    Author     : alpha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
          
      <form method="post" name="CMCICFormulaire" target="_top" action="https://paiement.creditmutuel.fr/test/paiement.cgi">
          <input type="hidden" name="version" value="3.0"></input>
          <input type="hidden" name="TPE" value="1234567"></input>
          <input type="hidden" name="date" value="05/12/2006:11:55:23"></input>
          <input type="hidden" name="montant" value="62.73EUR"></input>
          <input type="hidden" name="reference" value="ABERTPY00145"></input>
          <input type="hidden" name="MAC" value="78bc376c5b192f1c48844794cbdb0050f156b9a2"></input>
          <input type="hidden" name="url_retour"  value="http://url.retour.com/ko.cgi?order_ref=votreRF12345"></input>
          <input type="hidden" name="url_retour_ok" value="http://url.retour.com/ok.cgi?order_ref=votreRF12345"></input>
          <input type="hidden" name="url_retour_err" value="http://url.retour.com/err.cgi?order_ref=votreRF12345"></input>
          <input type="hidden" name="lgue" value="FR"></input>
          <input type="hidden" name="societe" value="monSite1"></input>
          <input type="hidden" name="texte-libre" value="ExempleTexteLibre"></input>
          <input type="hidden" name="mail" value="internaute@sonemail.fr"></input>
          <input type="submit" name="bouton" value="Paiement CB"></input>
                
      </form>
    </body>
</html>
