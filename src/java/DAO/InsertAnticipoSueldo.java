package DAO;

import BD.conexion;
import Model.Anticipo;
import com.google.gson.JsonObject;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class InsertAnticipoSueldo {

    public static boolean agregarAnticipoSueldo(Anticipo AnticipoSueldo) {
        boolean agregado = false;
        try {
            conexion c = new conexion();
            Connection con = c.getConecction();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                String sql = "INSERT INTO anticiposueldo(personal_id, postulante_id,montoanticipado )VALUES ('" + AnticipoSueldo.getPersonal_id() + "','" + AnticipoSueldo.getPostulante_id()
                        + "','" + AnticipoSueldo.getMontoanticipado() + "')";
                st.executeUpdate(sql);
                agregado = true;
                st.close();
            }
            c.isConected();
        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

    public JsonObject consultaAnticipo(int id) throws ParseException {
        Anticipo anticipo = new Anticipo();
        JsonObject json = new JsonObject();
        conexion cn = new conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select ant.id_anticiposueldo as id_anticiposueldo,\n"
                    + "ant.personal_id as personal_id,\n"
                    + "ant.postulante_id as postulante_id,\n"
                    + "ant.montoanticipado as monto,\n"
                    + "ant.created_at as fecha,\n"
                    + "p.postulante_dni as postulante_dni,\n"
                    + "p.postulante_primer_nombre as nombre,\n"
                    + "p.postulante_segundo_nombre as nombre2,\n"
                    + "p.postulante_apellido_paterno as apellido\n"
                    + "from anticiposueldo ant inner join postulante p on ant.personal_id =p.postulante_id "
                    + "where ant.id_anticiposueldo = ?";
            ps = cn.getConecction().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                json = new JsonObject();
                json.addProperty("id_anticiposueldo", rs.getString("id_anticiposueldo"));
                json.addProperty("personal_id", rs.getString("personal_id"));
                json.addProperty("postulante_id", rs.getString("postulante_id"));
                json.addProperty("monto", rs.getString("monto"));
                SimpleDateFormat sdfEntrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date fecha = sdfEntrada.parse(rs.getString("fecha"));
                SimpleDateFormat sdfSalida = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = sdfSalida.format(fecha);
                json.addProperty("fecha", fechaFormateada);
                json.addProperty("postulante_dni", rs.getString("postulante_dni"));
                json.addProperty("nombre", rs.getString("nombre"));
                json.addProperty("nombre2", rs.getString("nombre2"));
                json.addProperty("apellido", rs.getString("apellido"));
            }
            return json;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (cn.isConected()) {
                    cn.getConecction().close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    private static Timestamp convertirAFechaTimestamp(String fechaString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date fecha = dateFormat.parse(fechaString);
            return new Timestamp(fecha.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
