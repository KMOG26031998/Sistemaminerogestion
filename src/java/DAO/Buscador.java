package DAO;
import BD.conexion;
import java.sql.SQLException;
import Model.BuscadorPostulante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Buscador {

    String sql = ""; 
    ResultSet rs = null;
    conexion cn = new conexion();
    private String sql_command = "";
    private PreparedStatement pst = null;

    public BuscadorPostulante Listbuscarpostulante(String cedula) {
        BuscadorPostulante newbuscar = new BuscadorPostulante();
        pst = null;
        rs = null;
        try {
            sql_command = "select postulante_dni, CONCAT(postulante_primer_nombre, ' ',postulante_segundo_nombre) as nombre,"
                    + "CONCAT(postulante_apellido_paterno, ' ',postulante_apellido_materno)as apellido,postulante_grupo,"
                    + "postulante_convencional,postulante_telefono,postulante_provincia,postulante_direccion,\n"
                    + " postulante_genero, postulante_social,postulante_nacionalidad, "
                    + "postulante_correoelectronico from postulante "
                    + "where postulante_dni = '" + cedula + "'";
            pst = cn.getConecction().prepareStatement(sql_command);
            rs = pst.executeQuery();
            while (rs.next()) {

                newbuscar.setPostulante_dni(String.valueOf(rs.getString("postulante_dni")));
                newbuscar.setPostulante_primer_segundo_nombre(String.valueOf(rs.getString("nombre")));
                newbuscar.setPostulante_primer_segundo_apellido(String.valueOf(rs.getString("apellido")));
                newbuscar.setPostulante_grupo(String.valueOf(rs.getString("postulante_grupo")));
                newbuscar.setPostulante_convencional(String.valueOf(rs.getString("postulante_convencional")));
                newbuscar.setPostulante_telefono(String.valueOf(rs.getString("postulante_telefono")));
                newbuscar.setPostulante_provincia(String.valueOf(rs.getString("postulante_provincia")));
                newbuscar.setPostulante_direccion(String.valueOf(rs.getString("postulante_direccion")));
                newbuscar.setPostulante_genero(String.valueOf(rs.getString("postulante_genero")));
                newbuscar.setPostulante_social(String.valueOf(rs.getString("postulante_social")));
                newbuscar.setPostulante_nacionalidad(String.valueOf(rs.getString("postulante_nacionalidad")));
                newbuscar.setPostulante_correoelectronico(String.valueOf(rs.getString("postulante_correoelectronico")));

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

    public BuscadorPostulante Listbuscarpostulante(String apellido, String nombre) {
        BuscadorPostulante newbuscar = new BuscadorPostulante();
        pst = null;
        rs = null;
        try {
            sql_command = "Select * from (select postulante_dni,\n"
                    + "	   CONCAT(postulante_primer_nombre, ' ',\n"
                    + "	   postulante_segundo_nombre) as nombre,\n"
                    + "	   CONCAT(postulante_apellido_paterno, ' ',\n"
                    + "	   postulante_apellido_materno)as apellido,postulante_grupo,\n"
                    + "	   postulante_convencional,\n"
                    + "	   postulante_telefono,\n"
                    + "	   postulante_provincia,\n"
                    + "	   postulante_direccion,\n"
                    + "	   postulante_genero,\n"
                    + "	   postulante_social,\n"
                    + "	   postulante_nacionalidad,\n"
                    + "	   postulante_correoelectronico from postulante) as T1\n"
                    + "	   where apellido = '" + apellido + "' AND nombre = '" + nombre + "'";
            pst = cn.getConecction().prepareStatement(sql_command);
            rs = pst.executeQuery();
            while (rs.next()) {

                newbuscar.setPostulante_dni(String.valueOf(rs.getString("postulante_dni")));
                newbuscar.setPostulante_primer_segundo_nombre(String.valueOf(rs.getString("nombre")));
                newbuscar.setPostulante_primer_segundo_apellido(String.valueOf(rs.getString("apellido")));
                newbuscar.setPostulante_grupo(String.valueOf(rs.getString("postulante_grupo")));
                newbuscar.setPostulante_convencional(String.valueOf(rs.getString("postulante_convencional")));
                newbuscar.setPostulante_telefono(String.valueOf(rs.getString("postulante_telefono")));
                newbuscar.setPostulante_provincia(String.valueOf(rs.getString("postulante_provincia")));
                newbuscar.setPostulante_direccion(String.valueOf(rs.getString("postulante_direccion")));
                newbuscar.setPostulante_genero(String.valueOf(rs.getString("postulante_genero")));
                newbuscar.setPostulante_social(String.valueOf(rs.getString("postulante_ayudasocial")));
                newbuscar.setPostulante_nacionalidad(String.valueOf(rs.getString("postulante_nacionalidad")));
                newbuscar.setPostulante_correoelectronico(String.valueOf(rs.getString("postulante_correoelectronico")));

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

}
