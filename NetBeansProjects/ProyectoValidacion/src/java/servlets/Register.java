/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.PrendaDAO;
import DB.Conector;
import DTO.Prenda;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author profesoraula
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    final String URL = "localhost";
    final String USER = "SYSTEM";
    final String PW = "root";
    final int PORT = 1521;
    final String SID = "orcl";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
       String nombre = request.getParameter("nombre");
       String precio = request.getParameter("precio");
       String gender = request.getParameter("gender");
       String url = request.getParameter("url");
       
       if(nombre != null && precio != null && gender != null && url != null){
       boolean nombreOk = false;
       if(!nombre.equals("") && nombre.length()>=3){
           nombreOk = true;
       }
       
       int precioReal = -1;
       try{
         precioReal = Integer.valueOf(precio);
       }catch(NumberFormatException e){
           System.out.println("not a number");
       }
       
       boolean genderOk = false;
       if(gender.equals("Masculino") | gender.equals("Femenino") | gender.equals("Unisex")){
           genderOk = true;
       }
       
       boolean urlOk = false;
       if(url.contains("http")){
           urlOk = true;
       }
       
       if(nombreOk && precioReal != -1 && genderOk && urlOk){
            Conector c = new Conector(USER, PW, URL, PORT, SID);
             PrendaDAO dao = new PrendaDAO(c);
             Prenda p = new Prenda(nombre, gender, precioReal, url);
             dao.create(p);
             response.sendRedirect("tabla-productos.jsp");
       }else{
           response.sendRedirect("index.jsp?err=Datos incorrectos");
       }
       }else{
            response.sendRedirect("index.jsp?err=Faltan datos");
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
