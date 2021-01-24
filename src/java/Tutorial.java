/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Enryp
 */
@WebServlet(urlPatterns = {"/Tutorial"})
public class Tutorial extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Reindirizzare senza modificare URL
        RequestDispatcher rd = request.getRequestDispatcher("servlet2");
        rd.forward(request, response);

        //Per fare un redirect su un'altra servlet: (con modifica dell'url)
        response.sendRedirect("servlet2?possibiliValori");
       
        //Sessione --> Login :D
        HttpSession session = request.getSession();
        session.setAttribute("name", "value");
        
        session.getAttribute("name");
        session.removeAttribute("name");
        
        //Cookies
        Cookie c = new Cookie("nome", "valore");
        response.addCookie(c);
        
        Cookie[] cs = request.getCookies();
        for(Cookie ck : cs){
            
        }
        
        //Config e Context
        //In XML:
        /* <context-param>
             <param-name>name</param-name>
             <param-value>Enrico</param-value>
           </context-param>
        */
        //Context è per tutte le servlet, config no
        ServletContext ctx = getServletContext();
        ctx.getInitParameter("name"); //--> Ritorna Enrico dall'XML
        
        /* <servlet>
           <...>
           <init-param>
             <param-name>cell</param-name>
             <param-value>Xiaomao</param-value>
           </init-param>
           </servlet>
        */
        ServletConfig cg = getServletConfig();
        cg.getInitParameter("cell"); //--> Ritorna Xiaomao, ma solo per
        
        //Annotations --> Permette di evitare l'utilizzo di XML
        //@WebServlet("/nomeServlet") va prima del public class 
        
        //JSP --> Java Server Pages --> Tutorial.jsp
        //JSP = Creare una pagina
        //Servlet = Processare dati
        
        //MVC = Model View Controller
    }

}
