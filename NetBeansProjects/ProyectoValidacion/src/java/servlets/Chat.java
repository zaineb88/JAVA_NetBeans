/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.MensajeDAO;
import DB.Conector;
import DTO.Mensaje;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author profesoraula
 */
@WebServlet(name = "Chat", urlPatterns = {"/Chat"})
public class Chat extends HttpServlet {

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
       
    final String URL = "localhost";
    final String USER = "SYSTEM";
    final String PW = "root";
    final int PORT = 1521;
    final String SID = "orcl"; 
    Conector c = new Conector(USER, PW, URL, PORT, SID);
    MensajeDAO dao = new MensajeDAO(c);
    
        
        String p = request.getParameter("mode");
        ArrayList<Mensaje> msgs = null;
        Gson g = new Gson();
        String respuesta = null;
        
        System.out.println("mode: "+p);
        
        switch(p){
            case "loadNew":
                System.out.println("Leyendo nuevos");
                msgs = dao.obtenerMensajes(0);
                if(msgs != null){
                   dao.updateLeidos(msgs);
                }
                respuesta = g.toJson(msgs);
                response.setContentType("application/json");
                break;
            
            case "loadOld":
                 System.out.println("Leyendo viejos");
                 msgs = dao.obtenerMensajes(1);
                 respuesta = g.toJson(msgs);
                 response.setContentType("application/json");
                 break;
                
            case "insert":
                 String user = request.getParameter("user");
                 String message = request.getParameter("message");
    
                 BufferedReader reader = request.getReader();
                 StringBuilder sb = new StringBuilder();
                 String temp = null;
                 while((temp = reader.readLine()) != null){
                     sb.append(temp);
                 }
                 System.out.println(sb.toString());
                Mensaje msg = g.fromJson(sb.toString(), Mensaje.class);
                
                 dao.insertarMensaje(msg);
                 PrintWriter writer = response.getWriter();
                 response.setContentType("text/plain");
                 respuesta = "success";
        }

        
        try (PrintWriter writer = response.getWriter()) {
            writer.write(respuesta);
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
