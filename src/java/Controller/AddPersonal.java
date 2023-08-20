package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ConstructorPersonal;
import DAO.InsertAddPersonal;


@WebServlet(name = "AddPersonal", urlPatterns = {"/AddPersonal"})
public class AddPersonal extends HttpServlet {

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
            String Celular = request.getParameter("celular");
            String Provincia = request.getParameter("Provincia");
            String canton = request.getParameter("canton");
            String parroquia = request.getParameter("parroquia");
            String Direccion = request.getParameter("direccion");
            String email = request.getParameter("email");
            String usuario = request.getParameter("user");
            String pass = request.getParameter("pass"); 
            String TipoDepartamento = request.getParameter("departamento");
            if ("ADMINISTRADOR 1".equals(TipoDepartamento)) {
                TipoDepartamento = "1";
            } else {
                TipoDepartamento = "0";
            }

            String estado = "0";
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String x = dtf.format(LocalDateTime.now());

            if (!TipoIden.equalsIgnoreCase("") && !Identificacion.equalsIgnoreCase("") && !PrimerNombre.equalsIgnoreCase("") && !PrimerApellido.equalsIgnoreCase("") && !SegundoApellido.equalsIgnoreCase("")
                    && !Celular.equalsIgnoreCase("") && !SegundoNombre.equalsIgnoreCase("") && !Provincia.equalsIgnoreCase("") && !canton.equalsIgnoreCase("") && !Direccion.equalsIgnoreCase("")
                    && !parroquia.equalsIgnoreCase("") && !email.equalsIgnoreCase("") && !usuario.equalsIgnoreCase("") && !pass.equalsIgnoreCase("")
                    && !x.equalsIgnoreCase("") && !estado.equalsIgnoreCase("") && !TipoDepartamento.equalsIgnoreCase("")) {
                ConstructorPersonal personal = new ConstructorPersonal(TipoIden, Identificacion, PrimerApellido, PrimerNombre, Celular, Direccion, x, usuario, pass, SegundoApellido, SegundoNombre, Provincia, canton, parroquia, estado, TipoDepartamento, email);
                boolean sw = InsertAddPersonal.agregarPersonal(personal);

                if (sw) {
//                    JOptionPane.showMessageDialog(null, "AGREGADO CORRECTAMENTE");
                    response.sendRedirect("index.jsp");
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
