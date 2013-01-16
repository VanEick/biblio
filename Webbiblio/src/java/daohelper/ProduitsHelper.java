package daohelper;

import entity.Produits;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author stagiaire
 */
public class ProduitsHelper {
    
    Session session = null;
    
    public ProduitsHelper(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    // ------------------
    public List getProduits()
    // ------------------
    {
        List<Produits> produitsListe = null;
        try {
            //Query q = session.createQuery("SELECT id_ville, nom_ville, id_departement FROM Villes ORDER BY nom_ville");
            //Query q = session.createQuery("from Villes v, Departements d where v.codeDepartement = d.ville.codeDepartement ");
           Query q = session.createQuery("FROM Produits ORDER BY nom_produit");
           produitsListe = (List<Produits>)q.list();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return produitsListe;
    } /// getDepartements
    
    // ------------------
    public List getFicheProduit(int np)
    // ------------------
    {
        List<Produits> produitsListe = null;
        try {
           Query q = session.createQuery("FROM Produits WHERE id_produit="+np+" ORDER BY nom_produit");
           produitsListe = (List<Produits>)q.list();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return produitsListe;
    } /// getDepartements

   
   // ------------------------
   public void fermerSession()
   {
      try {
         this.session.close();
      }
      catch(Exception e) {
      }
   } /// fermerSession
}
