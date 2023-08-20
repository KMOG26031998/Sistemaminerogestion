 
package Controller;

import BD.conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
 
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
            String sql = "UPDATE public.postulante\n"
                    + "   SET postulante_apellido_paterno=?, \n"
                    + "       postulante_primer_nombre=?, postulante_fnacimiento=?, postulante_direccion=?, \n"
                    + "       postulante_telefono=?, postulante_genero=?, postulante_grupo=?, postulante_social=?, \n"
                    + "       postulante_apellido_materno=?, postulante_segundo_nombre=?, \n"
                    + "       postulante_provincia=?,postulante_parroquia=?, \n"
                    + "       postulante_nacionalidad=?, postulante_estado_civil=?, postulante_convencional=?, \n"
                    + "       postulante_cargo=?, postulante_correoelectronico=?\n"
                    + " WHERE postulante_dni=?;";
            ps = c.getConecction().prepareStatement(sql);
            ps.setString(2, PrimerNombre);
            ps.setString(10, SegundoNombre);
            ps.setString(1, PrimerApellido);
            ps.setString(9, SegundoApellido);
            ps.setString(3, Fechadenacimiento);
            ps.setString(15, convencional);
            ps.setString(5, Celular);
            ps.setString(11, Provincia);
            ps.setString(4, Direccion);
            ps.setString(12, parroquia);
            ps.setString(14, estadoCivil);
            ps.setString(8, Ayuda1);
            ps.setString(13, nacionalidad);
            ps.setString(7, discapacidad);
            ps.setString(16, cargo);
            ps.setString(6, genero);
            ps.setString(17, email);
            ps.setString(18, cond);
            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "ACTUALIZADO INFORMACION CORRECTAMENTE");
            response.sendRedirect("Principal.jsp");
        } catch (IOException | SQLException e) {
            out.println("Exception: " + e);
            System.out.println("Exception1: " + e);
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
