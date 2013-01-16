package daohelper;

import java.sql.*;

public class Connexion {
    // 
    private Connection icn;
    
    // 
    public String seConnecter (String asBD, String asUser, String asMDP){
        
        String lsRetour = "";
        
        // Try -> Catch
        try {
		Class.forName("org.gjt.mm.mysql.Driver");
		this.icn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + asBD, asUser, asMDP);
                this.icn.setAutoCommit(false);
                
                lsRetour = "OK";
                
        } /// try
        
        
        catch (Exception e) {
            lsRetour = e.getMessage();
            
        } /// catch
        
        return lsRetour;
        
    } /// seConnecter
    
    
    // Getters & Setters
    public Connection getConnexion(){
        
        return this.icn;
        
    } /// getConnexion
    
    
    public boolean seDeconnecter() {
        
        boolean lbOk = true;
        
        try {
            this.icn.close();
        } ///try
        
        catch (Exception e) {
        
        } /// catch
        
        return lbOk;
        
    } /// seDeconnecter
    
    public boolean valider(){
        
       boolean lbOk = false;
       
        try {
            this.icn.commit();
        } 
        
        catch (Exception e) {
        }
       
       return lbOk;
       
    } /// valider
    
    public boolean annuler(){
        
       boolean lbOk = false;
       
        try {
            this.icn.rollback();
        } 
        
        catch (Exception e) {
        }
       
       return lbOk;
       
    } /// annuler
    
} /// Connexion