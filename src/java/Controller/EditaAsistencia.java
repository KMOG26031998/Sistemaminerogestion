/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Buscadorpostulantecontr;
import DAO.Insertarasistencia;
import Model.Asistencia;
import Model.BuscadorPostulante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis
 */
public class EditaAsistencia extends HttpServlet {

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
            out.println("<title>Servlet EditaAsistencia</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditaAsistencia at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);
        HttpSession sesion = request.getSession(true);
        String id = "";
        id = request.getParameter("id");
        String userLogin;
        String userID;
        userLogin = (String) sesion.getAttribute("personal_user11");
        userID = (String) sesion.getAttribute("userID");
        Insertarasistencia InAsistencia = new Insertarasistencia();
        Asistencia asistencia = InAsistencia.ConsultaAsistencia(id);
        if (asistencia != null) {
            BuscadorPostulante usuario = new BuscadorPostulante();
            Buscadorpostulantecontr buscar = new Buscadorpostulantecontr();
            usuario = buscar.ListabuscadorpostulanteId(asistencia.getPostulante_id());
            request.setAttribute("usuario", usuario);
            request.setAttribute("UserId", userID);
            request.setAttribute("userLogin", userLogin);
            request.setAttribute("Asistencia", asistencia);
            request.setAttribute("modificar", id);

            request.getRequestDispatcher("/Asistencia.jsp").forward(request, response);
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
