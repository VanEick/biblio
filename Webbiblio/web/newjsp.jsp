<%-- 
    Document   : newjsp
    Created on : 15 janv. 2013, 17:15:28
    Author     : stagiaire
--%>
import java.util.HashMap;

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            public class Calendrier3 {
    
    public static void main(String[] args) {
        
      HashMap<String Integer> hmMois = new HashMap();
      
      hmMois.put("Janvier", 31);
      hmMois.put("Février", 28);
      hmMois.put("Mars", 31);
      hmMois.put("Avril", 30);
      hmMois.put("Mai", 31);
      hmMois.put("Juin", 30);
      hmMois.put("Juillet", 31);
      hmMois.put("Août", 31);
      hmMois.put("Septembre", 30);
      hmMois.put("Octobre", 31);
      hmMois.put("Novembre", 30);
      hmMois.put("Décembre", 31);
      
      int[] tJoursMois = {31,28,31,30,31,30,31,31,30,31,30,31};
        
//      String[] tNomsMois = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
//      int[] tJoursMois = {31,28,31,30,31,30,31,31,30,31,30,31};

      int[][] tCalendrier = new int[12][31];
      
      // --- Remplissage
      for(int i=0; i<tCalendrier.length; i++) {
          //System.out.print(tCalendrier[i] +  "|");
          for(int j=0; j<tJoursMois[i]; j++) {
            tCalendrier[i][j] = j+1;
            //System.out.print(tCalendrier[i][j] + "|");
          } // Fin J
          //System.out.println("");
      } // Fin I      
      
      // --- Affichage
      for(int i=0; i<tCalendrier.length; i++) {
          //System.out.print(tCalendrier[i] +  "|");
          for(int j=0; j<tCalendrier[i].length; j++) {
            if(tCalendrier[i][j] != 0)
                System.out.print(tCalendrier[i][j] + "|");
          } // Fin J
          System.out.println("");
      } // Fin I
    }    
}
        </h1>
    </body>
</html>
