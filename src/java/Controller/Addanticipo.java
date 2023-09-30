package Controller;

import BD.conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Addanticipo", urlPatterns = {"/Addanticipo"})
public class Addanticipo extends HttpServlet {

    PrintWriter out = null;
    PreparedStatement ps = null;
    HttpSession session = null;
    conexion c = new conexion();

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

             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            String personalid = request.getParameter("personal_id");
            String postulanteid = request.getParameter("postulante_id");
            String montoanticipado = request.getParameter("montoanticipado"); 
            String fecha = request.getParameter("created_at");
            String modificar = request.getParameter("modificar");
             Date parsedDate = dateFormat.parse(fecha);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());

            try {
                System.out.println("connection done");
                if (!modificar.equals("")) {

                    String sqlModificar = "UPDATE public.anticiposueldo SET montoanticipado=?, created_at= ? "
                            + "WHERE id_anticiposueldo=? and  personal_id=? and postulante_id=?;";
                    ps = c.getConecction().prepareStatement(sqlModificar, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, montoanticipado);
                    ps.setTimestamp(2,timestamp );
                    ps.setInt(3, Integer.parseInt(modificar));
                    ps.setInt(4, Integer.parseInt(personalid));
                    ps.setInt(5, Integer.parseInt(postulanteid));
                    int resAsistencia = 0;
                    resAsistencia = ps.executeUpdate();
                    if (resAsistencia != 0) {
                        response.sendRedirect(request.getContextPath() + "/HistorialAnticipoSueldo.jsp");
                    }
                } else {

                    String sqlAsistencia = "INSERT INTO public.anticiposueldo(\n"
                            + "            personal_id, postulante_id, \n"
                            + "            montoanticipado)\n"
                            + "    VALUES (?, ?, ?);";
                    ps = c.getConecction().prepareStatement(sqlAsistencia, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, Integer.parseInt(personalid));
                    ps.setInt(2, Integer.parseInt(postulanteid));

                    
                    String date = dateFormat.format(Calendar.getInstance().getTime());

                    ps.setString(3, montoanticipado);
                    int resAsistencia = 0;

                    resAsistencia = ps.executeUpdate();
                    if (resAsistencia != 0) {
                        response.sendRedirect(request.getContextPath() + "/HistorialAnticipoSueldo.jsp");
                    }
                }
            } catch (SQLException e) {
                out.println("Exception: " + e);
                System.out.println("Exception1: " + e);
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                } catch (SQLException e) {
                    out.println(e);
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(Addanticipo.class.getName()).log(Level.SEVERE, null, ex);
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
