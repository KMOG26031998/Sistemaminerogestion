package Controller;
import DAO.InsertAddPostulante;
import DAO.Insertarasistencia;
import Model.Constructorasistencia;
import Model.ControladorPostulante;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
@WebServlet(name = "Addasistencia", urlPatterns = {"/Addasistencia"})
public class Addasistencia extends HttpServlet {

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
            String personalid = request.getParameter("personal_id");
            String postulanteid = request.getParameter("postulante_id");
            String Fecha= request.getParameter("fecha");
            String actividadobservacion = request.getParameter("actividadobservacion");

             

            if (!personalid.equalsIgnoreCase("") && !postulanteid.equalsIgnoreCase("")
                    && !Fecha.equalsIgnoreCase("") && !actividadobservacion.equalsIgnoreCase("")){
                Constructorasistencia busuario = new Constructorasistencia(personalid, postulanteid, Fecha, actividadobservacion );
                boolean sw = Insertarasistencia.agregarAsistencia(busuario);
                if (sw) {
//                    JOptionPane.showMessageDialog(null, "PACIENTE AGREGADA/O CORECTAMENTE");
                    response.sendRedirect("Asistencia.jsp");
//                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                } else {
//                    out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
                }
            }
        }
               
//<<<<<<< Updated upstream
                
              //   insertarasistencia.agregarasistenciadetalle(id_encabezado,fecha,observacion);
//                JOptionPane.showMessageDialog(null, "ASISTENCIA AGREGADA CORECTAMENTE");
 

                // insertarasistencia.agregarasistenciadetalle(id_encabezado, fecha, observacion);
                // JOptionPane.showMessageDialog(null, "ASISTENCIA AGREGADA CORECTAMENTE");
//>>>>>>> Stashed changes
                // response.sendRedirect("Principal.jsp");
                //JsonParser jsondetalle = new JsonParse(); 

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
