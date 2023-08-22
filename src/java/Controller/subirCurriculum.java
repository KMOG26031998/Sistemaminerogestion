package Controller;
import BD.conexion;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
 
@WebServlet(name = "subirCurriculum", urlPatterns = {"/subirCurriculum"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class subirCurriculum extends HttpServlet {

    PrintWriter out = null;
    PreparedStatement ps = null;
    HttpSession session = null;
    conexion c = new conexion();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");

//        try {
//            out = response.getWriter();
//            session = request.getSession(false);
//            String folderName = "resources";
//            String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName;//for netbeans use this code
//            //String uploadPath = request.getServletContext().getRealPath("") + folderName;//for eclipse use this code
//            File dir = new File(uploadPath);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            Part filePart = request.getPart("cargarArchivos");
//            Integer codigo = Integer.valueOf(request.getParameter("codigo"));
////            Part filePart = request.getPart("file");//Textbox value of name file.
////            String firstName = request.getParameter("firstname");//Textbox value of name firstname.
////            String lastName = request.getParameter("lastname");//Textbox value of name lastname.
//            String fileName = filePart.getSubmittedFileName();
//            String patch = folderName + File.separator + fileName;
//            Timestamp added_date = new Timestamp(System.currentTimeMillis());
//            InputStream is = filePart.getInputStream();
//            Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
//            try {
//                System.out.println("connection done");
//                String sql = "UPDATE public.personalcontratado\n"
//                        + "   SET cargararchivo=?, patch=?\n"
//                        + " WHERE idpersonalcontratado = ?";
//                ps = c.getConecction().prepareStatement(sql);
//                ps.setString(1, fileName);
//                ps.setString(2, patch);
//                ps.setInt(3, codigo);
//                ps.executeUpdate();
//                response.sendRedirect("Principal.jsp");
//            } catch (SQLException e) {
//                out.println("Exception: " + e);
//                System.out.println("Exception1: " + e);
//            } finally {
//                if (ps != null) {
//                    try {
//                        ps.close();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(subirCurriculum.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            out.println("Exception: " + e);
//            System.out.println("Exception2: " + e);
//        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
