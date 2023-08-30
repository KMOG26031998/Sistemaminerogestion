package DAO;
import BD.conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Model.BuscadorPostulante;
import Model.ConstructorPersonal;
import Model.Constructorasistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Insertarasistencia {

    String sql = "";
    ResultSet rs = null;
    conexion cn = new conexion();
    private String sql_command = "";
    private PreparedStatement pst = null;

    public BuscadorPostulante Listbuscarpostulante1(String cedula) {
        BuscadorPostulante newbuscar = new BuscadorPostulante();
        pst = null;
        rs = null;
        try {
            sql_command = "select postulante_id,CONCAT(postulante_primer_nombre, ' ',postulante_segundo_nombre,' ',postulante_apellido_paterno, ' ',postulante_apellido_materno)as nombres\n"
                    + "  from postulante  where postulante_dni = '" + cedula + "'";
            pst = cn.getConecction().prepareStatement(sql_command);
            rs = pst.executeQuery();
            while (rs.next()) { 
                newbuscar.setNombrescompleto(String.valueOf(rs.getString("nombres") + "-" + rs.getString("postulante_id")));
                System.out.println(String.valueOf(rs.getString("postulante_id") + rs.getString("nombres")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (cn.isConected()) {
                    cn.getConecction().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return newbuscar;
    }

    /*public Constructorasistencia Listbuscarm(String user) {
        Constructorasistencia newbuscarm = new Constructorasistencia();
        pst = null;
        rs = null;
        try {
            sql_command = "select personal_id,CONCAT(personal_primer_nombre, ' ',personal_segundo_nombre,' ',personal_apellido_paterno, ' ', personal_apellido_materno) as nombrepersonal \n"
                    + "  from personal where personal_user =  '" + user + "'";
            pst = cn.getConecction().prepareStatement(sql_command);
            rs = pst.executeQuery();
            while (rs.next()) {
                //newbuscarm.setpersonalid(Integer.valueOf(rs.getString("personal_id")));
                newbuscarm.setNombrespersonal(String.valueOf(rs.getString("nombrepersonal") + "-" + rs.getString("personal_id")));
                System.out.println(String.valueOf(rs.getString("nombrepersonal")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (cn.isConected()) {
                    cn.getConecction().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return newbuscarm;
    }*/

    public void mostrarasistencia(int idasist, int idpersonal,int idpostulante,String fecha, String observacion) {

        try {
            conexion c = new conexion();
            Connection con = c.getConecction();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                st.executeUpdate("select * from detalle_asistencia(" + idasist + "," + idpersonal + "," + idpostulante + ",'" + fecha + "','" + observacion + "')");
                st.close();
            }
            c.isConected();
        } catch (SQLException e) {
        }
    }

    public static boolean agregarAsistencia(Constructorasistencia asistencia) {
    boolean agregado = false;
    try {
        conexion c = new conexion();
        Connection con = c.getConecction();

        if (con != null) {
            String query = "INSERT INTO public.asistencia(\n"
                    + "            personal_dni, postulante_id, \n"
                    + "            fecha, \n"
                    + "            actividadobservacion)\n"
                    + "    VALUES (?, ?, ?, ?);";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, asistencia.getPersonalid());
            ps.setInt(2, asistencia.getPostulanteid());
            ps.setTimestamp(3,convertirAFechaTimestamp((asistencia.getFecha()))); 
            ps.setString(4, asistencia.getObservacion()); 
         
            String persona=asistencia.toString();

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                agregado = true;
            }

            ps.close();
            c.isConected();
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage().toString());
        agregado = false;
    }

    return agregado;
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
