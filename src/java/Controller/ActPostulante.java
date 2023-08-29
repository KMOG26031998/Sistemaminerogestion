package Controller;

import BD.conexion;
import DAO.Buscadorpostulantecontr;
import Model.BuscadorPostulante;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ActPostulante", urlPatterns = {"/ActPostulante"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class ActPostulante extends HttpServlet {

    PrintWriter out = null;
    PreparedStatement ps = null;
    HttpSession session = null;
    conexion c = new conexion();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        out = response.getWriter();
        session = request.getSession(false);
        String TipoIden = request.getParameter("TipoIden");
        String Identificacion = request.getParameter("Identificacion");
        String PrimerNombre = request.getParameter("PrimerNombres");
        String SegundoNombre = request.getParameter("SegundoNombres");
        String PrimerApellido = request.getParameter("PrimerApellidos");
        String SegundoApellido = request.getParameter("SegundoApellidos");
        String Fechadenacimiento = request.getParameter("Fechadenacimiento");
        String convencional = request.getParameter("convencional");
        String Celular = request.getParameter("celular");
        String Provincia = request.getParameter("Provincia");
        String Direccion = request.getParameter("Direccion");
        String parroquia = request.getParameter("parroquia");
        String estadoCivil = request.getParameter("estadoCivil");
        String Ayuda1 = request.getParameter("Ayuda");
        String nacionalidad = request.getParameter("nacionalidad");
        String discapacidad = request.getParameter("discapacidad");
        String cargo = request.getParameter("cargo");
        String genero = request.getParameter("genero");
        String email = request.getParameter("email");
        String cond = request.getParameter("cedula");
        try {
            System.out.println("connection done");
            String sql = "UPDATE public.postulante"
                    + "   SET postulante_apellido_paterno=?,"
                    + "       postulante_primer_nombre=?, "
                    + "       postulante_fnacimiento=?, "
                    + "       postulante_direccion=?, "
                    + "       postulante_telefono=?, "
                    + "       postulante_genero=?, "
                    + "       postulante_grupo=?, "
                    + "       postulante_social=?,"
                    + "       postulante_apellido_materno=?, "
                    + "       postulante_segundo_nombre=?,"
                    + "       postulante_provincia=?,"
                    + "       postulante_parroquia=?,"
                    + "       postulante_nacionalidad=?, "
                    + "       postulante_estado_civil=?, "
                    + "       postulante_convencional=?, "
                    + "       postulante_cargo=?, postulante_correoelectronico=?"
                    + " WHERE postulante_dni=?;";
            ps = c.getConecction().prepareStatement(sql);
            ps.setString(1, PrimerApellido);
            ps.setString(2, PrimerNombre);
            ps.setString(3, Fechadenacimiento);
            ps.setString(4, Direccion);
            ps.setString(5, Celular);
            ps.setString(6, genero);
            ps.setString(7, discapacidad);
            ps.setString(8, Ayuda1);
            ps.setString(9, SegundoApellido);
            ps.setString(10, SegundoNombre);
            ps.setString(11, Provincia);
            ps.setString(12, parroquia);
            ps.setString(13, nacionalidad);
            ps.setString(14, estadoCivil);
            ps.setString(15, convencional);
            ps.setString(16, cargo);
            ps.setString(17, email);
            ps.setString(18, cond);
            ps.executeUpdate();
            response.sendRedirect("./Principal.jsp");
        } catch (IOException | SQLException e) {
            out.println("Exception: " + e);
            System.out.println("Exception1: " + e);
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
        BuscadorPostulante usuario = new BuscadorPostulante();
        String id = request.getParameter("id");
        String tipo = request.getParameter("Tipo") != null ? request.getParameter("Tipo") : "";
        Buscadorpostulantecontr buscar = new Buscadorpostulantecontr();
        if (tipo.equals("delete")) {
            buscar.ActualizaEstadoPsotulante(id);
            response.sendRedirect("ListaPersonalModificar.jsp");
        } else if (tipo.equals("mod")) {
            usuario = buscar.ListabuscadorpostulanteId(id);
            String fechaString = usuario.getPostulante_fechanacimiento(); // Cambia esto por la fecha real
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(fechaString, formatter);
            int año = localDate.getYear();
            int mes = localDate.getMonthValue();
            String mesFormateado = (mes < 10) ? String.format("0%d", mes) : String.valueOf(mes);
            int dia = localDate.getDayOfMonth();
            String diaFormateado = (dia < 10) ? String.format("0%d", dia) : String.valueOf(dia);
            usuario.setPostulante_fechanacimiento(String.valueOf(año) + "-" + mesFormateado + "-" + diaFormateado);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("Actualizardatos.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
