<%-- 
    Document   : inscription
    Created on : 16 janv. 2013, 09:36:35
    Author     : stagiaire   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>inscription:</h1>
         <form action="validationInscription.jsp" method="post">
                 <label class="nom">Nom: </label>
                 <input type="text" name="nom" /><br>
                 <label class="prenom">Prénom: </label>
                 <input type="text" name="prenom" /><br>
                 <label class="adresse">Adresse: </label>
                 <input type="text" name="adresse" /><br>
                 <label class="mail">E-Mail: </label>
                 <input type="text" name="mail" /><br>
                 <label class="login">Login: </label>
                 <input type="text" name="login" /><br>
                 <label class="pass">Password: </label>
                 <input type="password" name="pass" /><br>
                  <label class="profil">Profil: </label>
                <select name="profil" size="1">
                    <option value="utilisateurs">Utlisateurs</option>
                    <option value="administrateur">Administrateur</option>
                </select><br>
                <input type="submit" value="valider">

         </form>
    </body>
</html>
