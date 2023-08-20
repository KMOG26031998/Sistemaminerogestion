package Controller;

import DAO.Insertarasistencia;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import static java.lang.System.out;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
        String op = request.getParameter("op");
        HttpSession sesion = request.getSession();
        switch (op) {
            case "1":
                String cedula = request.getParameter("cedula");
                //Integer galenoid = resquest.getParameter("");
                Insertarasistencia buscar1 = new Insertarasistencia();
                String json = new Gson().toJson(buscar1.Listbuscarpostulante1(cedula));
                out.print(json);
                sesion.setAttribute("DatePostulante", json);
                // Establece el tipo de respuesta en formato json
                response.setContentType("text/javascript");
                response.getWriter().print(json);
                break;

            case "2":
                String users = request.getParameter("user");
                Insertarasistencia buscau = new Insertarasistencia();
                String jsonnn = new Gson().toJson(buscau.Listbuscarm(users));
                System.out.print(jsonnn);
                response.setContentType("text/javascript");
                response.getWriter().print(jsonnn);
                break;
            case "3":
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String x = dtf.format(LocalDateTime.now());
                String idPersonal = sesion.getAttribute("idPersonal").toString();
                String jsonDatePostulante = sesion.getAttribute("DatePostulante").toString();
                String jsonAsistencia = request.getParameter("jsonasistencia");
                String fecha = request.getParameter("fecha");

                JsonParser jsonParser = new JsonParser();
                JsonObject myJson = (JsonObject) jsonParser.parse(jsonDatePostulante);

                String postulanteid = myJson.get("postulanteid").getAsString();
                Insertarasistencia insertarreceta = new Insertarasistencia();

                int id_encabezado = insertarreceta.agregarasistenciaencabezado(idPersonal, postulanteid, x);

                String actividad = "";
                String observacion = "";
//<<<<<<< Updated upstream
                
                insertarreceta.agregarasistenciadetalle(id_encabezado,actividad,observacion);
//                JOptionPane.showMessageDialog(null, "ASISTENCIA AGREGADA CORECTAMENTE");
 

                insertarreceta.agregarasistenciadetalle(id_encabezado, actividad, observacion);
                JOptionPane.showMessageDialog(null, "ASISTENCIA AGREGADA CORECTAMENTE");
//>>>>>>> Stashed changes
                response.sendRedirect("Principal.jsp");
                //JsonParser jsondetalle = new JsonParse();

                break;

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
