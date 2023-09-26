package Controller;
import BD.conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
          try (PrintWriter out = response.getWriter()) {

            String personalid = request.getParameter("personal_id");
            String postulanteid = request.getParameter("postulante_id");
            String montoanticipado = request.getParameter("montoanticipado");


            try {
                System.out.println("connection done");


                String sqlAsistencia = "INSERT INTO public.anticiposueldo(\n"
                    + "            personal_id, postulante_id, \n"
                    + "            montoanticipado)\n"
                    + "    VALUES (?, ?, ?);";


                ps = c.getConecction().prepareStatement(sqlAsistencia, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, Integer.parseInt(personalid));
                ps.setInt(2, Integer.parseInt(postulanteid));

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd, HH:mm:ss");
                String date = dateFormat.format(Calendar.getInstance().getTime());
 
                ps.setString(3, montoanticipado);
                int resAsistencia = 0;

                resAsistencia = ps.executeUpdate();
                if (resAsistencia != 0) {
                    response.sendRedirect(request.getContextPath() + "/Anticiposueldo.jsp");
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