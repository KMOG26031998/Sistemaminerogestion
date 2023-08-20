package DAO;

import BD.conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Model.BuscadorPostulante;
import Model.Constructorasistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                // newbuscar.setPostulanteid(String.valueOf(rs.getString("postulante_id")));
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

    public Constructorasistencia Listbuscarm(String user) {
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
    }

    public int agregarasistenciaencabezado(String personalid, String postulanteid, String fecha) {
        int aux = -1;
        try {
            conexion c = new conexion();
            Connection con = c.getConecction();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from encabezado('" + personalid + "','" + postulanteid + "','" + fecha + "')");
                rs.next();
                aux = rs.getInt(1);
                st.close();
            }
            c.isConected();
        } catch (SQLException e) {
            System.err.println(e);
            aux = -1;
        }
        return aux;
    }

    public void agregarasistenciadetalle(int idasist, String actividad, String observacion) {

        try {
            conexion c = new conexion();
            Connection con = c.getConecction();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                st.executeUpdate("select * from detalle_asistencia(" + idasist + ",'" + actividad + "','" + observacion + "')");
                st.close();
            }
            c.isConected();
        } catch (SQLException e) {
        }
    }
}
