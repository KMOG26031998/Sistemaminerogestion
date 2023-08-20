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
import javax.servlet.http.Part;
 
@WebServlet(name = "AddPersonalContratado", urlPatterns = {"/AddPersonalContratado"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class AddPersonalContratado extends HttpServlet {

    PrintWriter out = null;
    PreparedStatement ps = null;
    HttpSession session = null;
    conexion c = new conexion();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try {
            out = response.getWriter();
            session = request.getSession(false);
//            String folderName = "resources";
//            String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName;//for netbeans use this code
//            //String uploadPath = request.getServletContext().getRealPath("") + folderName;//for eclipse use this code
//            File dir = new File(uploadPath);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
            String dni, Pnom, Snom, telefono, direccion, provincia, canton, parroquia, email, ap, af, aq, fecha, mc, ep, diag, tipo;
            dni = request.getParameter("cedula");
            Pnom = request.getParameter("experiencialaboral");
            Snom = request.getParameter("refenciapersonal");
            telefono = request.getParameter("referencialaboral");
            direccion = request.getParameter("cursosrealizadoS");
            provincia = request.getParameter("habilidades");
            canton = request.getParameter("actitudes");
            parroquia = request.getParameter("estudioprimario");
            ap = request.getParameter("estudiosecundario");
            af = request.getParameter("estudiotercernivel");
            aq = request.getParameter("estudiaactual");
            fecha = request.getParameter("Fechaingreso");
            mc = request.getParameter("motivoingreso");
            ep = request.getParameter("estadotrabajo");
            diag = request.getParameter("observacion");
            tipo = request.getParameter("horariolaboral");
            String personalUser = (String) session.getAttribute("personal_user11");
 
            Part filePart = request.getPart("CargarArchivo");
//            Part filePart = request.getPart("file");//Textbox value of name file.
//            String firstName = request.getParameter("firstname");//Textbox value of name firstname.
//            String lastName = request.getParameter("lastname");//Textbox value of name lastname.
//            String fileName = filePart.getSubmittedFileName();
//            String patch = folderName + File.separator + fileName;
//            Timestamp added_date = new Timestamp(System.currentTimeMillis());
//            InputStream is = filePart.getInputStream();
//            Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
            try {
                System.out.println("connection done");
                String sql = "insert into personalContratado(postulante_dni, experiencialaboral, refenciapersonal, referencialaboral, \n"
                        + "            cursosrealizadoS, habilidades, actitudes, estudioprimario, estudiosecundario, estudiotercernivel, \n"
                        + "            estudiaactual, fechaingreso, motivoingreso, estadotrabajo, \n"
                        + "            observacion, horariolaboral,personal_user) values(?, ?, ?, ?, \n"
                        + "            ?, ?, ?, ?, ?, ?, \n"
                        + "            ?, ?, ?, ?, \n"
                        + "            ?, ?, ?)";
                ps = c.getConecction().prepareStatement(sql);
                ps.setString(1, dni);
                ps.setString(2, Pnom);
                ps.setString(3, Snom);
                ps.setString(4, telefono);
                ps.setString(5, direccion);
                ps.setString(6, provincia);
                ps.setString(7, canton);
                ps.setString(8, parroquia);
                ps.setString(9, ap);
                ps.setString(10, af);
                ps.setString(11, aq);
                ps.setString(12, fecha);
                ps.setString(13, mc);
                ps.setString(14, ep);
                ps.setString(15, diag);
                ps.setString(16, tipo);
                ps.setString(17, personalUser);
                ps.executeUpdate();
//                JOptionPane.showMessageDialog(null, "CONSULTA AGREGADA CORECTAMENTE");
//                request.getRequestDispatcher("/Personalcontratado.jsp").forward(request, response);
                response.sendRedirect("Principal.jsp");
//                response.sendRedirect("Asistencia.jsp");
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

        } catch (IOException | ServletException e) {
            out.println("Exception: " + e);
            System.out.println("Exception2: " + e);
        }
    }

}
