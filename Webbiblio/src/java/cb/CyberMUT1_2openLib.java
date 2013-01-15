/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb;

/*****************************************************************************
*
* CM_CIC_Paiement "open source" kit for CyberMUT-P@iement(TM)
* and P@iementCIC(TM).
* Integration sample for Java/JCE environment.
*
* File "CyberMUT1_2openLib.java":
*
* This sample shows how to build CyberMUT-P@iement(TM) compliant
* authenticated messages with JCE/Mac. Refer to your Security Officers to
* implement appropriate shared SecretKey administration.
*
* Author : Euro-Information/e-Commerce (contact: centrecom@e-i.com)
* Version : 1.03
* Date : 18/12/2003
*
* Copyright: (c) 2003 Euro-Information. All rights reserved.
* License : see attached document "License.txt".
*
*---------------------------------------------------------------------------*
*
* CM_CIC_Paiement: kit "open source" pour CyberMUT-P@iement(TM)
* et P@iementCIC(TM).
* Exemple d'intégration en environnement Java/JCE.
*
* Fichier "CyberMUT1_2openLib.java" :
*
* Cet exemple montre comment créer des messages pour CyberMUT-P@iement(TM)
* avec JCE/Mac. Reportez-vous à votre responsable sécurité pour administrer
* correctement les clés partagées CyberMUT-Paiement (TM).
*
* Auteur : Euro-Information/e-Commerce (contact: centrecom@e-i.com)
* Version : 1.03
* Date : 18/12/2003
*
* Copyright: (c) 2003 Euro-Information. Tous droits réservés.
* Consulter le document de licence "Licence.txt" joint.
*
*****************************************************************************/

/*===========================================================================*
* Imported modules
*===========================================================================*/

import java.util.Date;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/*===========================================================================*
* Class CyberMUT1_2openLib
*===========================================================================*/

abstract public class CyberMUT1_2openLib {

/*===========================================================================*
* CyberMUT1_2openLib methods
*===========================================================================*/

/*-----------------------------------------------------------------------*
* Constructor :
* inits Mac with the shared SecretKey related to Merchant ID (TPE)
*-----------------------------------------------------------------------*/
public CyberMUT1_2openLib(String TPE, String xKey) throws Exception {
this.Tpe = TPE;

MessageDigest md = MessageDigest.getInstance("SHA");
md.update(stringToByteArray(this.TpeToPassPhrase()));
byte[] sksBytes = md.digest();
byte[] sks2ndBytes = hexStringToByteArray(xKey);
for (int i = 0; i < sksBytes.length; i++) {
sksBytes[i] = (byte) (sksBytes[i] ^ sks2ndBytes[i]);
}

if (this.Tpe.equals("Jefe")) { // RFC2104 HmacMD5 test deck
sksBytes = this.Tpe.getBytes();
}
else if (this.Tpe.equals("0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b")) {
sksBytes = hexStringToByteArray(this.Tpe);
}

SecretKeySpec sks = new SecretKeySpec(sksBytes,
this.TpeHmac.getAlgorithm());
SecretKey sk = (SecretKey) sks;
this.TpeHmac.init(sk); // sha1(PassPhrase) XOR 2ndPartOfKey

this.TpeBankServer = TpeToBankServer();
}

abstract protected String TpeToPassPhrase();
abstract protected String TpeToBankServer();
// final implementation requested (merchant)

/*=======================================================================*
* CyberMUT-P@iement functions
*
* - CreerFormulaireHmac (Phase 1)
* - TesterHmac (Phase 2)
* - CreerAccuseReception (Phase 2)
*=======================================================================*/

/*-----------------------------------------------------------------------*
* Formatting payment form - Creer le formulaire de paiement
*-----------------------------------------------------------------------*/
final public String CreerFormulaireHmac(String montant,
String reference,
String textelibre,
String url_retour,
String url_retour_ok,
String url_retour_err,
String langue,
String societe,
String textebouton) throws Exception {

String DatePaiement = datePaiement();
String MacChamps = this.Tpe + "*"
+ DatePaiement + "*"
+ montant + "*"
+ reference + "*"
+ textelibre + "*"
+ this.TpeVersion + "*"
+ langue + "*"
+ societe + "*";

String HiddN = "\">\r\n<INPUT TYPE=\"hidden\" NAME=\"";
String SubmT = "\">\r\n<INPUT TYPE=\"submit\" NAME=\"";

StringBuffer Formulaire = new StringBuffer(8192);

Formulaire.append("<FORM ACTION=\"https://"
+ htmlEncode(this.TpeBankServer)
+ "paiement.cgi"
+ "\" METHOD=\"post\" TARGET=\"_top\" NAME=\""
+ "\"PaymentRequest\"");
Formulaire.append(HiddN + "version\" VALUE=\""
+ htmlEncode(this.TpeVersion));
Formulaire.append(HiddN + "TPE\" VALUE=\""
+ htmlEncode(this.Tpe));
Formulaire.append(HiddN + "date\" VALUE=\""
+ htmlEncode(DatePaiement));
Formulaire.append(HiddN + "montant\" VALUE=\""
+ htmlEncode(montant));
Formulaire.append(HiddN + "reference\" VALUE=\""
+ htmlEncode(reference));
Formulaire.append(HiddN + "MAC\" VALUE=\""
+ htmlEncode(calculerMAC(MacChamps)));
Formulaire.append(HiddN + "url_retour\" VALUE=\""
+ htmlEncode(url_retour));
Formulaire.append(HiddN + "url_retour_ok\" VALUE=\""
+ htmlEncode(url_retour_ok));
Formulaire.append(HiddN + "url_retour_err\" VALUE=\""
+ htmlEncode(url_retour_err));
Formulaire.append(HiddN + "lgue\" VALUE=\""
+ htmlEncode(langue));
Formulaire.append(HiddN + "societe\" VALUE=\""
+ htmlEncode(societe));
Formulaire.append(HiddN + "texte-libre\" VALUE=\""
+ htmlEncode(textelibre));
Formulaire.append(SubmT + "bouton\" VALUE=\""
+ htmlEncode(textebouton) + "\"></FORM>");
// Formulaire.append("\r\n<BR>" + MacChamps + "<BR>");

return Formulaire.toString();
}

/*-----------------------------------------------------------------------*
* Testing confirmation MAC - Verifier le MAC de la confirmation
*-----------------------------------------------------------------------*/
final public String TesterHmac(String HMAC,
String date_commande,
String montant,
String reference,
String textelibre,
String coderetour,
String retourPLUS) throws Exception {

String MacChamps = retourPLUS + this.Tpe + "+"
+ date_commande + "+"
+ montant + "+"
+ reference + "+"
+ textelibre + "+"
+ this.TpeVersion + "+"
+ coderetour + "+";

if (HMAC.equalsIgnoreCase(calculerMAC(MacChamps))) {
return "1";
} else {
return ("0-" + MacChamps);
}
}

/*-----------------------------------------------------------------------*
* Formatting a receipt/response to the confirmation message
* sent by bank server.
* Crée un accusé de réception en réponse au message de confirmation
* émis par la banque.
*-----------------------------------------------------------------------*/
final public String CreerAccuseReception(String MacOk) {
StringBuffer Reponse = new StringBuffer("Version:1\n" );
if (MacOk.equals("1")) {
Reponse.append("OK\n");
} else {
Reponse.append("Document falsifie\n");
}
Reponse.append(datePaiement());
return Reponse.toString();
}

/*-----------------------------------------------------------------------*
* Miscellaneous functions - Divers
*-----------------------------------------------------------------------*/
final public boolean isMsgAuth(String MacOk) {
return MacOk.startsWith("1");
}
final public boolean isPayment(String CodeRetour) {
return CodeRetour.equals("paiement");
}
final public boolean isTestPayment(String CodeRetour) {
return CodeRetour.equals("payetest");
}

/*-----------------------------------------------------------------------*
* Your CyberMUT-P@iement(TM) Merchant ID - Numéro de TPE Virtuel
*-----------------------------------------------------------------------*/
final public String getTPE() {
return this.Tpe;
}

/*-----------------------------------------------------------------------*
* Payment Server Interface Version - Version de l'interface serveur
*-----------------------------------------------------------------------*/
final public String getVersion() {
return this.TpeVersion;
}

/*-----------------------------------------------------------------------*
* Bank Payment Server - Serveur de paiement bancaire
*-----------------------------------------------------------------------*/
final public String getBankServer() {
return this.TpeBankServer;
}

/*-----------------------------------------------------------------------*
* Underlying Hash Method - Méthode de hachage sous-jacente
*-----------------------------------------------------------------------*/
final public String getHash() {
return this.TpeHmac.getAlgorithm();
}

/*-----------------------------------------------------------------------*
* Malfunction basic tests - Tests de bon fonctionnement
*-----------------------------------------------------------------------*/
final public String getCtlHmac () throws Exception {

String LibV = ("V1.03--") + this.TpeHmac.toString() + "--";

if (this.Tpe.equals("Jefe")) { // RFC2104 HmacMD5 test deck
return(LibV + "Jefe... = 0x" +
calculerMAC("what do ya want for nothing?"));
}
else if (this.Tpe.equals("0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b")) {
return(LibV + "....0b0b = 0x" +
calculerMAC("Hi There"));
}
else { // CyberMUT test deck
return(LibV + "CtlHmac-" + this.TpeVersion
+ "-[" + this.Tpe + "]-"
+ calculerMAC("CtlHmac"+ this.TpeVersion + this.Tpe));
}
}

/*-----------------------------------------------------------------------*
* Computing Hmac for CyberMUT-P@iement(TM) compliant payment messages.
* Calcul de sceau Hmac conforme aux spécifications CyberMUT-P@iement(TM)
*-----------------------------------------------------------------------*/
final public String calculerMAC(String MacChamps) throws Exception {

if ( MacChamps == null) { return null; }

this.TpeHmac.reset();
byte [] resMAC = this.TpeHmac.doFinal(MacChamps.getBytes());
this.TpeHmac.reset();

if (this.Tpe.equals("Jefe")) { // RFC2104 HmacMD5 test deck
resMAC =
this.TpeHmac.doFinal("what do ya want for nothing?".getBytes());
}
else if (this.Tpe.equals("0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b")) {
resMAC = this.TpeHmac.doFinal("Hi There".getBytes());
}

return byteArrayToHexString(resMAC);
}


/*==========================================================================*
* CyberMUT1_2openLib privates
*==========================================================================*/

/*-----------------------------------------------------------------------*
* french style date format / format date francais
*-----------------------------------------------------------------------*/
final private static String datePaiement() {
SimpleDateFormat formatter =
new SimpleDateFormat ("dd/MM/yyyy:HH:mm:ss");
Date now = new Date();
return formatter.format(now);
}

/*-----------------------------------------------------------------------*
* convert String to Byte Array
*-----------------------------------------------------------------------*/
final private static byte[] stringToByteArray(String str) {
byte[] ba = new byte[str.length()];
for (int i = 0; i < str.length(); i++) {
ba[i] = (byte) str.charAt(i);
}
return ba;
}

/*-----------------------------------------------------------------------*
* convert hex String to Byte Array
*-----------------------------------------------------------------------*/
final private static int charToNibble (char c) {
if ('0' <= c && c<= '9') { return c - '0'; }
else if ('a' <= c && c<= 'f') { return c - 'a' + 0xa; }
else if ('A' <= c && c<= 'F') { return c - 'A' + 0xa; }
else throw new IllegalArgumentException ("Invalid hex characters");
}
final private static byte[] hexStringToByteArray (String hs) {
if(hs == null) { return null; }
int hslength = hs.length();
if ((hslength & 0*1) != 0)
throw new IllegalArgumentException(" hexStringToByteArray"
+ " requires an even number of hex characters");
int hsstart = 0;
if(hs.startsWith("0x")) { hsstart += 2; }
byte[] ba = new byte[(hslength-hsstart)/2];
for (int i=hsstart, j=0; i< hslength; i+=2,j++) {
int high = charToNibble (hs.charAt(i));
int low = charToNibble (hs.charAt(i+1));
ba[j] = (byte) ((high << 4) | low);
}
return ba;
}

/*-----------------------------------------------------------------------*
* convert byte Array to Hex String
*-----------------------------------------------------------------------*/
final private static char[] hexChar = {
'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
}; // to convert a 4bit-byte to a hex char.
final private static String byteArrayToHexString ( byte[] ba ) {
StringBuffer sb = new StringBuffer( ba.length * 2 );
for ( int i=0 ; i<ba.length ; i++ ) {
sb.append( hexChar [ ( ba[i] & 0xf0 ) >>> 4 ] ) ;
// look up high nibble half-byte
sb.append( hexChar [ ba[i] & 0x0f ] ) ;
// look up low nibble half-byte
}
return sb.toString();
}

/*-----------------------------------------------------------------------*
* html Encode non safe ascii chars < 127
*-----------------------------------------------------------------------*/
final private static String SAFE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
+ "abcdefghijklmnopqrstuvwxyz"
+ "0123456789_.-";
final private static String htmlEncode(String str) {
int len = str.length();
StringBuffer encoded = new StringBuffer(len*6);
for(int i=0; i<len; i++) {
if(SAFE_CHARS.indexOf(str.charAt(i)) >= 0) {
encoded.append(str.charAt(i));
} else {
int c = (int) str.charAt(i);
if(c <= 0x7F) {
encoded.append("&#x" + Integer.toHexString(c) + ";");
} else {
encoded.append(str.charAt(i));
}
}
}
return encoded.toString();
}

/*-----------------------------------------------------------------------*
* private members
*-----------------------------------------------------------------------*/
final private String Tpe;
final private String TpeBankServer;
final private Mac TpeHmac = Mac.getInstance("HmacSHA1");
// Note: for RFC2104 HmacMD5 compliance tests, use:
// ... = Mac.getInstance("HmacMD5");
final private static String TpeVersion = "1.2open";

}
// End of abstract class


/*===========================================================================*/



