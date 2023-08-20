package DAO;

import BD.conexion;
import java.sql.SQLException;
import Model.BuscadorPostulante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Buscadorpostulantecontr {

    String sql = "";
    ResultSet rs = null;
    conexion cn = new conexion();
    private String sql_command = "";
    private PreparedStatement pst = null;

    public BuscadorPostulante Listabuscadorpostulantecontr(String cedula) {
        BuscadorPostulante newbuscarp = new BuscadorPostulante();
        pst = null;
        rs = null;
        try {
            sql_command = "select postulante_dni,postulante_tipo_dni, postulante_primer_nombre, postulante_segundo_nombre, \n"
                    + "postulante_apellido_paterno, postulante_apellido_materno,postulante_fnacimiento,\n"
                    + "postulante_convencional,postulante_telefono, postulante_provincia,postulante_canton, postulante_parroquia,\n"
                    + "postulante_direccion, postulante_genero,postulante_estado_civil, postulante_social,postulante_nacionalidad, postulantegrupo,\n"
                    + "postulante_cargo,postulante_correoelectronico from postulante where postulante_dni ='" + cedula + "'";
            pst = cn.getConecction().prepareStatement(sql_command);
            rs = pst.executeQuery();
            while (rs.next()) {
                newbuscarp.setPostulante_dni(String.valueOf(rs.getString("postulante_dni")));
                newbuscarp.setPostulante_tipo_dni(String.valueOf(rs.getString("postulante_tipo_dni")));
                newbuscarp.setPostulante_primernombre(String.valueOf(rs.getString("postulante_primer_nombre")));
                newbuscarp.setPostulante_segundonombre(String.valueOf(rs.getString("postulante_segundo_nombre")));
                newbuscarp.setPostulante_primerapellido(String.valueOf(rs.getString("postulante_apellido_paterno")));
                newbuscarp.setPostulante_segundoapellido(String.valueOf(rs.getString("postulante_apellido_materno")));
                newbuscarp.setPostulante_fechanacimiento(String.valueOf(rs.getString("postulante_fnacimiento")));
                newbuscarp.setPostulante_convencional(String.valueOf(rs.getString("postulante_convencional")));
                newbuscarp.setPostulante_telefono(String.valueOf(rs.getString("postulante_telefono")));
                newbuscarp.setPostulante_provincia(String.valueOf(rs.getString("postulante_provincia")));
                newbuscarp.setPostulante_canton(String.valueOf(rs.getString("postulante_canton")));
                newbuscarp.setPostulante_parroquia(String.valueOf(rs.getString("postulante_parroquia")));
                newbuscarp.setPostulante_direccion(String.valueOf(rs.getString("postulante_direccion")));
                newbuscarp.setPostulante_genero(String.valueOf(rs.getString("postulante_genero")));
                newbuscarp.setPostulante_estadocivil(String.valueOf(rs.getString("postulante_estado_civil")));
                newbuscarp.setPostulante_social(String.valueOf(rs.getString("postulante_social")));
                newbuscarp.setPostulante_nacionalidad(String.valueOf(rs.getString("postulante_nacionalidad")));
                newbuscarp.setPostulante_grupo(String.valueOf(rs.getString("postulante_grupo")));
                newbuscarp.setPostulante_cargo(String.valueOf(rs.getString("postulante_cargo")));
                newbuscarp.setPostulante_correoelectronico(String.valueOf(rs.getString("postulante_correoelectronico")));

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
        return newbuscarp;
    }

    public BuscadorPostulante Listabuscadorpostulantecontr(String apellido, String nombre) {
        BuscadorPostulante newbuscarp = new BuscadorPostulante();
        pst = null;
        rs = null;
        try {
            sql_command = "select postulante_dni,postulante_tipo_dni, postulante_primer_nombre, postulante_segundo_nombre, \n"
                    + "postulante_apellido_paterno, postulante_apellido_materno,postulante_fnacimiento,\n"
                    + "postulante_convencional,postulante_telefono, postulante_provincia,postulante_canton, postulante_parroquia,\n"
                    + "postulante_direccion, postulante_genero,postulante_estado_civil, postulante_social,postulante_nacionalidad, postulante_grupo,\n"
                    + "postulante_cargo,postulante_correoelectronico from postulante where CONCAT(postulante_primer_nombre, ' ',postulante_segundo_nombre) like '%" + nombre + "%' AND CONCAT(postulante_apellido_paterno, ' ',postulante_apellido_materno) like '%" + apellido + "%'";
            pst = cn.getConecction().prepareStatement(sql_command);
            rs = pst.executeQuery();
            while (rs.next()) {
                newbuscarp.setPostulante_dni(String.valueOf(rs.getString("postulante_dni")));
                newbuscarp.setPostulante_tipo_dni(String.valueOf(rs.getString("postulante_tipo_dni")));
                newbuscarp.setPostulante_primernombre(String.valueOf(rs.getString("postulante_primer_nombre")));
                newbuscarp.setPostulante_segundonombre(String.valueOf(rs.getString("postulante_segundo_nombre")));
                newbuscarp.setPostulante_primerapellido(String.valueOf(rs.getString("postulante_apellido_paterno")));
                newbuscarp.setPostulante_segundoapellido(String.valueOf(rs.getString("postulante_apellido_materno")));
                newbuscarp.setPostulante_fechanacimiento(String.valueOf(rs.getString("postulante_fnacimiento")));
                newbuscarp.setPostulante_convencional(String.valueOf(rs.getString("postulante_convencional")));
                newbuscarp.setPostulante_telefono(String.valueOf(rs.getString("postulante_telefono")));
                newbuscarp.setPostulante_provincia(String.valueOf(rs.getString("postulante_provincia")));
                newbuscarp.setPostulante_canton(String.valueOf(rs.getString("postulante_canton")));
                newbuscarp.setPostulante_parroquia(String.valueOf(rs.getString("postulante_parroquia")));
                newbuscarp.setPostulante_direccion(String.valueOf(rs.getString("postulante_direccion")));
                newbuscarp.setPostulante_genero(String.valueOf(rs.getString("postulante_genero")));
                newbuscarp.setPostulante_estadocivil(String.valueOf(rs.getString("postulante_estado_civil")));
                newbuscarp.setPostulante_social(String.valueOf(rs.getString("postulante_social")));
                newbuscarp.setPostulante_nacionalidad(String.valueOf(rs.getString("postulante_nacionalidad")));
                newbuscarp.setPostulante_grupo(String.valueOf(rs.getString("postulante_grupo")));
                newbuscarp.setPostulante_cargo(String.valueOf(rs.getString("postulante_cargo")));
                newbuscarp.setPostulante_correoelectronico(String.valueOf(rs.getString("postulante_correoelectronico")));

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
        return newbuscarp;
    }
}
