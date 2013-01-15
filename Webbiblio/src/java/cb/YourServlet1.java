/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb;

/*
* YourServlet1.java
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
import java.lang.Integer.*;

/*===========================================================================*
* Your Servlet 1
*===========================================================================*/

public class YourServlet1 extends HttpServlet
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
response.setDateHeader("Expires",0);
response.setContentType("text/html");
PrintWriter out = response.getWriter();

out.println("<html>");
out.println("<head>");
out.println( "<title>CyberMUT-P@iement&#153; / P@iementCIC&#153;"
+ " Phase Aller </title>");
out.println("</head>");
out.println("<body>");
out.println( "<h2>CyberMUT-P@iement&#153; / P@iementCIC&#153;"
+ " -- YourServlet1 1.03</h2>CyberMUT compliance test:"
+ "<hr size=1>");

try {
YourTpeInstance YourTpe = new YourTpeInstance("", "", "");

out.println("<tt>TPE CM-CIC : " + YourTpe.getTPE() );
out.println(" - Bank Server : " + YourTpe.getBankServer() );
out.println("<br> Interface Version : "
+ YourTpe.getVersion() );
out.println(" - Hash Method : " + YourTpe.getHash() );
out.println("<br> " + YourTpe.getCtlHmac() + " -");

out.println("</tt><hr size=1>End of CyberMUT compliance test.<br>"
+ "First, check that the CtlHmac value obtained above is the "
+ "same as the one you got from extract2HmacSha1.htm. "
+ "If it is equal and you are rejected from the bank test "
+ "server with a message saying that the security requirements "
+ "have not been met, then copy the compliance test above and "
+ "send it to <a href=mailto:centrecom@e-i.com>CENTRECOM</a>."
+ "<br><b>BUT DO *NEVER* SEND YOUR SECRET KEY TO ANYBODY !</b>"
+ "<p><font color=blue>Before clicking on the button, "
+ "you should have edited the code of this Servlet and "
+ "changed it according to your personnal parameters"
+ "</font></p>" + "Payment button : <br>");

// test-only pseudoRandom reference generator
String Reference = Integer.toHexString(YourTpe.hashCode());

// You must fill the parameters below with your own values

String Formulaire = YourTpe.CreerFormulaireHmac(
"123.45EUR", // Amount+Currency EUR USD CHF GBP ... (*)
Reference, // Order Reference (Unique, AlphaN, Max chars 12)
"infos libres utiles", // Some text (No special chars)
"http://www.myshop.eur/",
// home page of the merchant
"http://www.myshop.eur/OK?ref=facture00000000000001",
// url where to redirect customer after payment
"http://www.myshop.eur/NOK?ref=facture00000000000001",
// your url where to redirect customer without payment
"FR", // language EN DE IT ES FR (*)
"societe", // Shop code (= code société) (*)
"Paiement CB"); // payment button text

// (*) according to CentreCom's settings for your merchant account

out.println(Formulaire);

out.println( "<br>Information : Form source :<hr size=1><xmp>"
+ Formulaire + "</xmp><hr size=1>End of form source.");

} catch (Exception e) { // log ... e ...
out.println("CyberMUT-P@iement failed.");
// Here you may use 'e' to get more information about the
// incident, but be careful not showing it to the user since
// it may contain confidential informations.
}

out.println("<h2>CyberMUT-P@iement&#153; / P@iementCIC&#153;</h2>");
out.println("</body>");
out.println("</html>");

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
return "CyberMUT-P@iement&#153; / P@iementCIC&#153; Phase Aller "
+ "/ Checkout Step (cgi1, asp1, php1, jsp1, a.s.o)";
}
}
// End of servlet


/*===========================================================================*/




