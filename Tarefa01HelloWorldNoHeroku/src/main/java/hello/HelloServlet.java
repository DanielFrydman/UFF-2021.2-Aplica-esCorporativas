package hello;

import java.util.Calendar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Calendar c1 = Calendar.getInstance();
	int hora = c1.get(Calendar.HOUR_OF_DAY);
        
        String msg = "", trat = "";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        
        String tratamento = request.getParameter("tratamento");
        if(tratamento==null)
            tratamento = "sr";
        
        String favcolor = "color:" + request.getParameter("favcolor") + ";";
        
        if(hora > 6 && hora < 12){
            switch(lang){
                case "pt":
                    if (tratamento.equals("sr"))
                        trat = "Senhor ";
                    else
                        trat = "Senhora ";
                    msg = "Bom Dia, ";
                    break;
                case "en":
                    if (tratamento.equals("sr"))
                        trat = "Sir ";
                    else
                        trat = "Madam ";
                    msg = "Good Morning, ";
                    break;
                case "fr":
                    if (tratamento.equals("sr"))
                        trat = "Monsieur ";
                    else
                        trat = "Madame ";
                    msg = "Bonjour, ";
                    break;
                case "de":
                    if (tratamento.equals("sr"))
                        trat = "Zotëri ";
                    else
                        trat = "Zonja ";
                    msg = "Guten Morgen, ";
                    break;
                case "he":
                    if (tratamento.equals("sr"))
                        trat = " אֲדוֹנִי";
                    else
                        trat = "ג ְבֶרֶת";
                    msg = " בוקר טוב";
                    break;
                case "es":
                    if (tratamento.equals("sr"))
                        trat = "Señor ";
                    else
                        trat = "Señora ";
                    msg = "Buen día, ";
                    break;
            }
        }else if(hora > 12 && hora < 18){
            switch(lang){
                case "pt":
                    if (tratamento.equals("sr"))
                        trat = "Senhor ";
                    else
                        trat = "Senhora ";
                    msg = "Boa tarde, ";
                    break;
                case "en":
                    if (tratamento.equals("sr"))
                        trat = "Sir ";
                    else
                        trat = "Madam ";
                    msg = "Good afternoon, ";
                    break;
                case "fr":
                    if (tratamento.equals("sr"))
                        trat = "Monsieur ";
                    else
                        trat = "Madame ";
                    msg = "Bon après-midi, ";
                    break;
                case "de":
                    if (tratamento.equals("sr"))
                        trat = "Zotëri ";
                    else
                        trat = "Zonja ";
                    msg = "Guten Tag, ";
                    break;
                case "he":
                    if (tratamento.equals("sr"))
                        trat = " אֲדוֹנִי";
                    else
                        trat = " גְבֶרֶת";
                    msg = " אחר הצהריים טובים";
                    break;
                case "es":
                    if (tratamento.equals("sr"))
                        trat = "Señor ";
                    else
                        trat = "Señora ";
                    msg = "Buenas tardes, ";
                    break;
            }
        }else{
            switch(lang){
                case "pt":
                    if (tratamento.equals("sr"))
                        trat = "Senhor ";
                    else
                        trat = "Senhora ";
                    msg = "Boa noite, ";
                    break;
                case "en":
                    if (tratamento.equals("sr"))
                        trat = "Sir ";
                    else
                        trat = "Madam ";
                    msg = "Good night, ";
                    break;
                case "fr":
                    if (tratamento.equals("sr"))
                        trat = "Monsieur ";
                    else
                        trat = "Madame ";
                    msg = "Bonne nuit, ";
                    break;
                case "de":
                    if (tratamento.equals("sr"))
                        trat = "Zotëri ";
                    else
                        trat = "Zonja ";
                    msg = "Naten e mire, ";
                    break;
                case "he":
                    if (tratamento.equals("sr"))
                        trat = "א ֲדוֹנִי";
                    else
                        trat = " גְבֶרֶת";
                    msg = " לילה טוב";
                    break;
                case "es":
                    if (tratamento.equals("sr"))
                        trat = "Señor ";
                    else
                        trat = "Señora ";
                    msg = "Buenas noches, ";
                    break;
            }
	}
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        if (lang.equals("he"))
            msg = "!"+nome+trat+msg;
        else
            msg = msg+trat+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p style="+favcolor+">" + msg +"</p>");
            out.println("<a href=\".\\helloform.html\">Voltar</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
