/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.InsertAnticipoSueldo;
import Model.Anticipo;
import Model.BuscadorPostulante;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis
 */
public class EditarAnticipo extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditarAnticipo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarAnticipo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            //  processRequest(request, response);
            HttpSession sesion = request.getSession(true);
            String idAnticipo = request.getParameter("id");
            String userID = (String) sesion.getAttribute("userID");
            String userLogin;
            userLogin = (String) sesion.getAttribute("personal_user11");
            BuscadorPostulante postulante = new BuscadorPostulante();
            Anticipo anticipoModel = new Anticipo();
            JsonObject json = new JsonObject();
            InsertAnticipoSueldo anticipo = new InsertAnticipoSueldo();
            json = anticipo.consultaAnticipo(Integer.valueOf(idAnticipo));
            postulante.setPostulante_dni(json.get("postulante_dni").getAsString());
            postulante.setPostulanteid(json.get("id_anticiposueldo").getAsString());
            postulante.setPostulante_primernombre(json.get("nombre").getAsString());
            postulante.setPostulante_segundonombre(json.get("nombre2").getAsString());
            postulante.setPostulante_primerapellido(json.get("apellido").getAsString());
           
            anticipoModel.setMontoanticipado(json.get("monto").getAsString());
            anticipoModel.setCreated_at(json.get("fecha").getAsString());
            anticipoModel.setPersonal_id(json.get("personal_id").getAsString());
            anticipoModel.setPostulante_id(json.get("postulante_id").getAsString());
            request.setAttribute("usuario", postulante);
            request.setAttribute("UserId", userID);
            request.setAttribute("userLogin", userLogin);
            request.setAttribute("anticipo", anticipoModel);
            request.setAttribute("modificar", idAnticipo);
            request.getRequestDispatcher("/Anticiposueldo.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditarAnticipo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
