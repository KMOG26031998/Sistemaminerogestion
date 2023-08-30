/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BD.conexion;
import DAO.Buscadorpostulantecontr;
import Model.BuscadorPostulante;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddContrato", urlPatterns = {"/AddContrato"})
public class AddContrato extends HttpServlet {

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
            out.println("<title>Servlet AddContrato</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddContrato at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        System.out.println(id);
        BuscadorPostulante usuario = new BuscadorPostulante();
        Buscadorpostulantecontr buscar = new Buscadorpostulantecontr();
        usuario = buscar.ListabuscadorpostulanteId(id);
        usuario.setPostulanteid(id);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/ContratoPersonal.jsp").forward(request, response);
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
        //processRequest(request, response);
        String id;
        String Motivo;
        String Observacion;
        String Tiempo;
        String Sueldo;
        Motivo = request.getParameter("Motivo");
        Observacion = request.getParameter("Observacion");
        Tiempo = request.getParameter("Tiempo");
        id = request.getParameter("id");
        Sueldo = request.getParameter("Sueldo");

        String sql = "INSERT INTO public.contrato ( contrato_motivo, "
                + "contrato_tiempo, fk_postulante_id, "
                + "ficha_estado, "
                + "contrato_estado, "
                + "contrato_observacion, sueldo) "
                + "VALUES(?,?,?,?,'Activo', ?, ?);";
        conexion c = new conexion();
        Connection con = c.getConecction();
        PreparedStatement ps = null;
        if (con != null) {
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, Motivo);
                ps.setInt(2, Integer.valueOf(Tiempo));
                ps.setInt(3, Integer.valueOf(id));
                ps.setString(4, "Activo");
                ps.setString(5, Observacion);
                ps.setFloat(6, Float.parseFloat(Sueldo));
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    response.sendRedirect("Principal.jsp");
                } else {
                    response.sendRedirect("AddContrato.jsp");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (ps != null) {
                        ps.close();

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
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
