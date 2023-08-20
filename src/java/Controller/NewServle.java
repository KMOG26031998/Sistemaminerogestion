package Controller;

import DAO.Insertarasistencia;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class NewServle extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        switch (op) {
            case "1":
                String cedula = request.getParameter("cedula");
                //Integer galenoid = resquest.getParameter("");
                Insertarasistencia buscar1 = new Insertarasistencia();
                String jsons = new Gson().toJson(buscar1.Listbuscarpostulante1(cedula));
                System.out.print(jsons);
                //  sesion.setAttribute("DatePaciente", json);
                // Establece el tipo de respuesta en formato json
                response.setContentType("text/javascript");
                response.getWriter().print(jsons);
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
                String x = dtf.format(LocalDateTime.now());            ////datos de encabezado          

                String idpersonal = request.getParameter("personalid");
                String postulanteid = request.getParameter("postulanteid");
                Insertarasistencia insertarreceta = new Insertarasistencia();
                int id_encabezado = insertarreceta.agregarasistenciaencabezado(idpersonal, postulanteid, x);

                String dt = request.getParameter("dt");
                JsonArray array = new JsonParser().parse(dt).getAsJsonArray();

                for (JsonElement item : array) {
                    JsonObject gsonObj = item.getAsJsonObject();
                    String actividad = gsonObj.get("actividad").getAsString();
                    String observacion = gsonObj.get("observacion").getAsString();
                    insertarreceta.agregarasistenciadetalle(id_encabezado, actividad, observacion);
                }
                response.getWriter().write(String.valueOf(id_encabezado));

                //JsonParser jsondetalle = new JsonParse();
                ////VALIDAR LOS TEXT
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
