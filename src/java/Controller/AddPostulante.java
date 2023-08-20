package Controller;

import DAO.InsertAddPostulante;
import Model.ControladorPostulante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "AddPostulante", urlPatterns = {"/AddPostulante"})
public class AddPostulante extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String TipoIden = request.getParameter("TipoIden");
            String Identificacion = request.getParameter("Identificacion");
            String PrimerNombre = request.getParameter("PrimerNombre");

            String SegundoNombre = request.getParameter("SegundoNombre");
            String PrimerApellido = request.getParameter("PrimerApellido");
            String SegundoApellido = request.getParameter("SegundoApellido");

            String Fechadenacimiento = request.getParameter("Fechadenacimiento");
            String convencional = request.getParameter("convencional");

            String Celular = request.getParameter("celular");
            String Provincia = request.getParameter("Provincia");
            String canton = request.getParameter("canton");

            String Direccion = request.getParameter("Direccion");
            String parroquia = request.getParameter("parroquia");
            String estadoCivil = request.getParameter("estadoCivil");

            String Ayuda1 = request.getParameter("Ayuda");
            String nacionalidad = request.getParameter("nacionalidad");
            String discapacidad = request.getParameter("discapacidad");

            String cargo = request.getParameter("cargo");
            String genero = request.getParameter("genero");
            String email = request.getParameter("email");

            if (!TipoIden.equalsIgnoreCase("") && !Identificacion.equalsIgnoreCase("") && !PrimerNombre.equalsIgnoreCase("") && !PrimerApellido.equalsIgnoreCase("") && !SegundoApellido.equalsIgnoreCase("")
                    && !Fechadenacimiento.equalsIgnoreCase("") && !convencional.equalsIgnoreCase("") && !Celular.equalsIgnoreCase("")
                    && !Provincia.equalsIgnoreCase("") && !canton.equalsIgnoreCase("") && !Direccion.equalsIgnoreCase("")
                    && !parroquia.equalsIgnoreCase("") && !estadoCivil.equalsIgnoreCase("") && !Ayuda1.equalsIgnoreCase("")
                    && !nacionalidad.equalsIgnoreCase("") && !discapacidad.equalsIgnoreCase("") && !cargo.equalsIgnoreCase("") && !email.equalsIgnoreCase("")
                    && !genero.equalsIgnoreCase("")) {
                ControladorPostulante busuario = new ControladorPostulante(TipoIden, Identificacion, PrimerApellido, PrimerNombre, Fechadenacimiento, Direccion, Celular, genero, discapacidad,
                        Ayuda1, SegundoApellido, SegundoNombre, Provincia, canton, parroquia, nacionalidad, estadoCivil, convencional, cargo, email);
                boolean sw = InsertAddPostulante.agregarUsuario(busuario);
                if (sw) {
//                    JOptionPane.showMessageDialog(null, "PACIENTE AGREGADA/O CORECTAMENTE");
                    response.sendRedirect("Principal.jsp");
//                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                } else {
//                    out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
                }
            }
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
