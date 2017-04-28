/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DBUtils.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author profesoraula
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        // Recogemos los datos de las peticiones
        String user = request.getParameter("id");
        String pw = request.getParameter("pw");
        String action = request.getParameter("action");
        
        // Si la acción es "log", es que hay un intento de login
        if(action.equals("log")){
        String nextJSP = "";
        
        // Comprobamos credenciales, que no sean nulos y que sean correctos
        if(user != null | pw != null){ 
            if(UsuariosDAO.checkCredentials(user, pw)){
                // En caso de estar bien, asignamos una variable a la sesión
                // del usuario, para poder filtrarla cuando queramos saber si
                // está logueado:
                HttpSession session = request.getSession();
                session.setAttribute("loggedAs", user);
                
                // Si quiere recordar el login, ponemos una cookie.
                String r = request.getParameter("recordar");
                if(r != null){
                    System.out.println("remember");
                    Cookie cookie = new Cookie("user", user);
                    cookie.setMaxAge(36000);
                    response.addCookie(cookie);
                }
                   // Redirigimos a la página de usuario
                   nextJSP = "/userpage.jsp";
            }else{
                // ¿Credenciales erróneos? A index, con un error particular
                nextJSP = "/index.jsp?err=invaliddata";
            }
        }else{
            // ... lo mismo si faltan datos.
            nextJSP = "/index.jsp?err=missingdata";
        }
        // Finalmente redirigimos al usuario a la dirección elegida.
        RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        }else if(action.equals("register")){
            // En caso de registro, creamos el usuario en la DB y listo.
            UsuariosDAO.createUser(user, pw);
            
            RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher("/index.jsp?msg=registered");
            dispatcher.forward(request,response);
            response.setContentType("text/html;charset=UTF-8");
            
            
            // Para desloguear, quitamos el atributo de la sesión, y borramos
            // la cookie que podamos haber guardado, para recordar su login.
        }else if(action.equals("logoff")){

           request.getSession().removeAttribute("loggedAs");
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie c : cookies){
                    if(c.getName().equals("user")){
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }
        response.sendRedirect("index.jsp?msg=loggedoff");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
