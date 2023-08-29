package Controller;

import BD.conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddPersonalContratado", urlPatterns = {"/AddPersonalContratado"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class AddPersonalContratado extends HttpServlet {

    PrintWriter out = null;
    PreparedStatement ps = null;
    HttpSession session = null;
    conexion c = new conexion();
    boolean existe;
    ResultSet rs;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try {
            out = response.getWriter();
            session = request.getSession(false);
            LocalDate fechaActual = LocalDate.now();
            existe = false;
            String dni,
                    EstPrimario,
                    EstSecundario,
                    EstTercerN,
                    EstActuales,
                    ExpLaboral,
                    Refenciapersonal,
                    Referencialaboral,
                    cursosrealizados,
                    habilidades,
                    actitudes;
            dni = request.getParameter("cedula");
            EstPrimario = request.getParameter("EstPrimario");
            EstSecundario = request.getParameter("EstSecundario");
            EstTercerN = request.getParameter("EstTercerN");
            EstActuales = request.getParameter("EstActuales");
            ExpLaboral = request.getParameter("ExpLaboral");
            Refenciapersonal = request.getParameter("Refenciapersonal");
            Referencialaboral = request.getParameter("Referencialaboral");
            cursosrealizados = request.getParameter("cursosrealizados");
            habilidades = request.getParameter("habilidades");
            actitudes = request.getParameter("actitudes");
            String personalUser = (String) session.getAttribute("personal_user11");
            try {
                String sqlVerifica = "select * from personalContratado PC "
                        + "where PC.postulante_dni = ?;";
                ps = c.getConecction().prepareStatement(sqlVerifica);
                ps.setString(1, dni);
                rs = ps.executeQuery();
                if (rs.next()) {
                    existe = true;
                }
            } catch (SQLException e) {
                out.println("Exception: " + e);
                System.out.println("Exception1: " + e);
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                        rs.close();
                    }
                } catch (SQLException e) {
                    out.println(e);
                }
            }
            if (existe) {
                try {
                    String sql = "UPDATE public.personalcontratado "
                            + "SET experiencialaboral=?, refenciapersonal=?, "
                            + "referencialaboral=?, cursosrealizados=?, "
                            + "habilidades=?, actitudes=?, estudioprimario=?, "
                            + "estudiosecundario=?, estudiotercernivel=?, "
                            + "estudiaactual=?, fechaingreso=?, "
                            + "motivoingreso=?, estadotrabajo=?, "
                            + "observacion=?, horariolaboral=?, "
                            + "personal_user=? "
                            + "WHERE postulante_dni=?;";
                    ps = c.getConecction().prepareStatement(sql);
                    ps.setString(1, ExpLaboral);
                    ps.setString(2, Refenciapersonal);
                    ps.setString(3, Referencialaboral);
                    ps.setString(4, cursosrealizados);
                    ps.setString(5, habilidades);
                    ps.setString(6, actitudes);
                    ps.setString(7, EstPrimario);
                    ps.setString(8, EstSecundario);
                    ps.setString(9, EstTercerN);
                    ps.setString(10, EstActuales);
                    ps.setString(11, fechaActual.toString());
                    ps.setString(12, "Actualizacion");
                    ps.setString(13, "Activo");
                    ps.setString(14, "");
                    ps.setString(15, "");
                    ps.setString(16, personalUser);
                    ps.setString(17, dni);
                    ps.executeUpdate();
                    response.sendRedirect("Principal.jsp");
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
            } else {
                try {
                    System.out.println("connection done");
                    String sql = "INSERT INTO public.personalcontratado"
                            + "( postulante_dni,"
                            + "experiencialaboral,"
                            + "refenciapersonal,"
                            + "referencialaboral,"
                            + "cursosrealizados,"
                            + "habilidades,"
                            + "actitudes,"
                            + "estudioprimario,"
                            + "estudiosecundario,"
                            + "estudiotercernivel,"
                            + "estudiaactual,"
                            + "fechaingreso,"
                            + "motivoingreso,"
                            + "estadotrabajo,"
                            + "observacion,"
                            + "horariolaboral,"
                            + "personal_user)VALUES( ?,"
                            + " ?, ?, ?, ?, ?,"
                            + " ?, ?, ?, ?, ?,"
                            + " ?, ?, ?, ?, ?, "
                            + "?);";
                    ps = c.getConecction().prepareStatement(sql);
                    ps.setString(1, dni);
                    ps.setString(2, ExpLaboral);
                    ps.setString(3, Refenciapersonal);
                    ps.setString(4, Referencialaboral);
                    ps.setString(5, cursosrealizados);
                    ps.setString(6, habilidades);
                    ps.setString(7, actitudes);
                    ps.setString(8, EstPrimario);
                    ps.setString(9, EstSecundario);
                    ps.setString(10, EstTercerN);
                    ps.setString(11, EstActuales);
                    ps.setString(12, fechaActual.toString());
                    ps.setString(13, "Nuevo Ingreso");
                    ps.setString(14, "Activo");
                    ps.setString(15, "");
                    ps.setString(16, "");
                    ps.setString(17, personalUser);
                    ps.executeUpdate();
                    response.sendRedirect("Principal.jsp");
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
        } catch (IOException e) {
            out.println("Exception: " + e);
            System.out.println("Exception2: " + e);
        }
    }

}
