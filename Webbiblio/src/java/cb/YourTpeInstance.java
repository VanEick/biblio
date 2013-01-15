/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb;

/*****************************************************************************
* YourTpeInstance.java
*
* Retrieving Key from KeyStore Stub.
* Stub to initiliaze Hmac Builder during test phases.
*
* Author : Euro-Information/e-Commerce (contact: centrecom@e-i.com)
*
* This sample shows how to build CyberMUT-P@iement(TM) compliant
* authenticated messages with JCE/Mac. Refer to your security officer
* to implement appropriate shared SecretKey administration.
*
* Cet exemple montre comment créer des messages pour CyberMUT-P@iement(TM)
* avec JCE/Mac. Reportez-vous à votre responsable sécurité pour administrer
* correctement les clés partagées CyberMUT-Paiement (TM).
*****************************************************************************/

/*===========================================================================*
* Class YourTpeInstance
*===========================================================================*/

final public class YourTpeInstance extends CyberMUT1_2openLib {

/*-----------------------------------------------------------------------*
* Constructor: creates a new instance of YourTpeInstance, according to
* your merchant account settings at <centrecom@e-i.com>.
* IPSP by CM : CyberMUT P@iement(TM) Internet Payment Service Provider
* by Crédit Mutuel
* Tpe means Merchant id and associated shared SecretKey for Hmac.
*-----------------------------------------------------------------------*/

public YourTpeInstance(String TPE, String Version, String xKey)
throws Exception {

super("1234567",
"0xfed01df816f8359b01920f2b272980547dfe73cf"); // <<<---

// super( TPE, HowToGetTheSecondPartOfKeyFrom(TPE, xKey) );

/* A personnaliser avec vos outils d'administration de clés.
* Ce n'est pas votre clé ni votre méthode de stockage et
* d'exploitation de clé secrète.
*
* Eclater la clef en 2 fragments est une bonne pratique.
* Les 2 fragments sont dans le source ci-dessus uniquement pour une
* première compilation.
*
* CentreCom vous fournira une clé commerçant (secret partagé,
* associé à une méthode de hachage). Il vous appartiendra
* de la protéger selon vos règles et outils de sécurité.
*
* Gardez à l'esprit qu'une clé secrète doit être secrète !
*/

/* To be customized with your KeyStore administration Tools.
* This is not a realistic key. This is not your merchant key.
* This is not your way of storing and retrieving secret keys.
*
* Splitting the FullKey as two pieces is a good practice. Both pieces
* are in source below just for your first compilation only.
*
* CentreCom will provide you a merchant key (shared secret,
* associated with hash method). You have to store and retrieve
* its value according to your security rules and tools.
*
* Keep in mind that a SecretKey must be Secret!
*/

if (Version != "") { // contrôle de la version demandée
if (Version != this.getVersion())
throw new IllegalArgumentException(" Pbm de Version");
}
}

/*-----------------------------------------------------------------------*
* Some code to determine Bank Server Url according to PSP settings
*-----------------------------------------------------------------------*/
// return ("www.creditmutuel.fr/telepaiement" + "/test/");
// return ("ssl.paiement.cic-banques.fr" + "/test/");
// return ("ssl.paiement.banque-obc.fr" + "/test/");
// return ("paiement.caixanet.fr" + "/test/");

final protected String TpeToBankServer() {
String TPE = this.getTPE();
return ("payment.somebank.net" + "/test/"); // Bank Server <<<---
}
final protected String TpeToPassPhrase() {
String TPE = this.getTPE();
return "YouGotThisPassPhrase"; // HowToGetThePhrase <<<---
}

// return HowToGetThePhraseFromYour(TPE);
/*-----------------------------------------------------------------------*
* Retrieves the PassPhrase generated for this Merchant ID (TPE)
*-----------------------------------------------------------------------*/
}
// End of class


/*===========================================================================*/




