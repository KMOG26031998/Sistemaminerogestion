package Controller;
import BD.conexion;
import DAO.InsertAddPostulante;
import DAO.Insertarasistencia;
import Model.Constructorasistencia;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Addasistencia", urlPatterns = {"/Addasistencia"})
public class Addasistencia extends HttpServlet {
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
            String Fecha= request.getParameter("fecha");
            String actividadobservacion = request.getParameter("actividadobservacion");


            try {
                System.out.println("connection done");


                String sqlAsistencia = "INSERT INTO public.asistencia(\n"
                    + "            personal_id, postulante_id, \n"
                    + "            fecha, \n"
                    + "            actividadobservacion)\n"
                    + "    VALUES (?, ?, ?, ?);";


                ps = c.getConecction().prepareStatement(sqlAsistencia, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, Integer.parseInt(personalid));
                ps.setInt(2, Integer.parseInt(postulanteid));

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd, HH:mm:ss");
                String date = dateFormat.format(Calendar.getInstance().getTime());

                ps.setString(3, date); 
                ps.setString(4, actividadobservacion);
                int resAsistencia = 0;

                resAsistencia = ps.executeUpdate();
                if (resAsistencia != 0) {
                    response.sendRedirect(request.getContextPath() + "/Asistencia.jsp");
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
 /*
            if (!personalid.equalsIgnoreCase("") && !postulanteid.equalsIgnoreCase("")
                    && !Fecha.equalsIgnoreCase("") && !actividadobservacion.equalsIgnoreCase("")){
                Constructorasistencia busuario = new Constructorasistencia(personalid, postulanteid, Fecha, actividadobservacion );
                boolean sw = Insertarasistencia.agregarAsistencia(busuario);
                if (sw) {
//                    JOptionPane.showMessageDialog(null, "PACIENTE AGREGADA/O CORECTAMENTE");
                    response.sendRedirect("Asistencia.jsp");
//                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                } else {
                    int a = 1;
//                    out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
                }
            }*/
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