/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb;

/*
* YourServlet2.java
*
* Created on 24 septembre 2003, 17:08
*
* @author (to be) : You ...........dev
* usage : You / CyberMUT-P@iement(TM) integration.
* important : Integration is Merchant's responsibility.
*
*/

/*===========================================================================*
* Imported modules
*===========================================================================*/
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*===========================================================================*
* Your Servlet 2
*===========================================================================*/

public class YourServlet2 extends HttpServlet
{
/*-----------------------------------------------------------------------*
* Initializes the servlet.
*-----------------------------------------------------------------------*/
public void init(ServletConfig config) throws ServletException {
super.init(config);
// ...
}

/*-----------------------------------------------------------------------*
* Destroys the servlet.
*-----------------------------------------------------------------------*/
public void destroy() {
super.destroy();
// ...
}

/*-----------------------------------------------------------------------*
* Processes requests for both HTTP GET and POST methods.
* @param request servlet request
* @param response servlet response
*-----------------------------------------------------------------------*/
protected void processRequest(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-cache");
response.setContentType("text/plain");
PrintWriter out = response.getWriter();

String ChampMac = request.getParameter("MAC");
String TPE = request.getParameter("TPE");
String DateCommande = request.getParameter("date");
String Montant = request.getParameter("montant");
String Reference = request.getParameter("reference");
String TexteLibre = request.getParameter("texte-libre");
String CodeRetour = request.getParameter("code-retour");
String RetourPLUS = request.getParameter("retourPLUS");

if(RetourPLUS==null) {
RetourPLUS = "";
}

try {
YourTpeInstance YourTpe = new YourTpeInstance(TPE, "", "");

String MacOk = YourTpe.TesterHmac(ChampMac,
DateCommande,
Montant,
Reference,
TexteLibre,
CodeRetour,
RetourPLUS);

if (YourTpe.isMsgAuth(MacOk)) { // Message authenticated
// ... log ...

// Payment Ok ?
if (YourTpe.isPayment(CodeRetour)) {
// ... send congratulation mail ...
// ... update (DB) Order Status ...
// ... initiate delivery process ...
}
// Payment test enabled ?
else if (YourTpe.isTestPayment(CodeRetour)) {
// out.println(" [" + MacOk + "]-[" + CodeRetour +"]- ");
// ...
} else {
// No payment now
// (but a succesfull trial may happen thereafter).
// ...
}
// ...
}
else { // Message not authenticated
// ... log alert with MacOk content
}

out.println(YourTpe.CreerAccuseReception(MacOk));

// warning: no extra out.println() allowed

} catch (Exception e) { // log ... e ...
out.println("CyberMUT-P@iement failed");
// Here you may use 'e' to get more information about the
// incident, but be careful not showing it to the user since
// it may contain confidential informations.
}

out.close();
}

/*-----------------------------------------------------------------------*
* Handles the HTTP GET method.
* @param request servlet request
* @param response servlet response
*-----------------------------------------------------------------------*/
protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

/*-----------------------------------------------------------------------*
* Handles the HTTP POST method.
* @param request servlet request
* @param response servlet response
*-----------------------------------------------------------------------*/
protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

/*-----------------------------------------------------------------------*
* Returns a short description of the servlet.
*-----------------------------------------------------------------------*/
public String getServletInfo() {
return "CyberMUT-P@iement&#153; / P@iementCIC&#153; "
+ "Phase Confirmation / Confirmation Step "
+ "(cgi2, asp2, php2, jsp2, a.s.o)";
}

}

/* IMPORTANT :
*
* This servlet is a dialog between Bank Server and Merchant Server.
* After that, the Bank Application will redirect the customer on
* your <UrlRetourOk> (or Nok).
* <UrlRetourOk> must test order context (including an order status
* updated by this servlet).
*
* In order to have an appropriate dialog with your customer:
*
* UrlretourOk and PaymentOk status ==> < Congratulations ! >
*
* UrlRetourOk without PaymentOk ==> Something wrong did happen.
* Typically this servlet failed (or
* customer frauds).
* < Sales service will contact you
* asap... >
*
* UrlRetourNok : Alternate payment ==> < Retry ? Check ? , ... >
*/

// End of servlet


/*===========================================================================*/






