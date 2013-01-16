/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author stagiaire
 */
public class cnHQL{
    public void   afficherResultat(List listResultat){
        
    }
    public void  executeHqlQuery(String lsHql){
        //connexion
        Session sess=HibernateUtil.getSessionFactory().openSession();
        //exection de la requette
        Query req=sess.createSQLQuery(lsHql);
        //recup
        List listResultat=req.list();
        afficherResultat(listResultat);
        //fermer session 
        sess.close();
    }
}
