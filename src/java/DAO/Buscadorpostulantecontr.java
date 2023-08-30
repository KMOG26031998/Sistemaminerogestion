package DAO;

import BD.conexion;
import java.sql.SQLException;
import Model.BuscadorPostulante;
import Model.BuscadorPostulantePersonal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buscadorpostulantecontr {

    String sql = "";
    ResultSet rs = null;
    conexion cn = new conexion();
    private String sql_command = "";
    private PreparedStatement pst = null;

    public BuscadorPostulante ListabuscadorpostulanteId(String id) {
        BuscadorPostulante newbuscarp = null;
        pst = null;
        rs = null;
        try {

            sql_command = "select * from postulante p where p.postulante_id  =" + id;
            pst = cn.getConecction().prepareStatement(sql_command);
            rs = pst.executeQuery();
            while (rs.next()) {
                newbuscarp = new BuscadorPostulante();
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

    public BuscadorPostulante Listabuscadorpostulantecontr(String cedula) {
        BuscadorPostulante newbuscarp = null;
        pst = null;
        rs = null;
        try {
            sql_command = "select * from postulante where postulante_dni ='" + cedula + "'";
            pst = cn.getConecction().prepareStatement(sql_command);
            rs = pst.executeQuery();
            while (rs.next()) {
                newbuscarp = new BuscadorPostulante();
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

    public List<BuscadorPostulante> obtenerListaPostulantes() {
        List<BuscadorPostulante> listaPostulantes = new ArrayList<>();
        String query = "SELECT * FROM postulante p where p.postulante_estado in ('Activo','ACTIVO')  ";
        try {
            pst = cn.getConecction().prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                BuscadorPostulante postulante = new BuscadorPostulante();
                postulante.setPostulanteid(rs.getString("postulante_id"));
                postulante.setPostulante_tipo_dni(rs.getString("postulante_tipo_dni"));
                postulante.setPostulante_dni(rs.getString("postulante_dni"));
                postulante.setPostulante_primerapellido(rs.getString("postulante_apellido_paterno"));
                postulante.setPostulante_primernombre(rs.getString("postulante_primer_nombre"));
                postulante.setPostulante_fechanacimiento(rs.getString("postulante_fnacimiento"));
                postulante.setPostulante_direccion(rs.getString("postulante_direccion"));
                postulante.setPostulante_telefono(rs.getString("postulante_telefono"));
                postulante.setPostulante_genero(rs.getString("postulante_genero"));
                postulante.setPostulante_grupo(rs.getString("postulante_grupo"));
                postulante.setPostulante_social(rs.getString("postulante_social"));
                postulante.setCreated_at(rs.getTimestamp("created_at"));
                postulante.setPostulante_segundoapellido(rs.getString("postulante_apellido_materno"));
                postulante.setPostulante_segundonombre(rs.getString("postulante_segundo_nombre"));
                postulante.setPostulante_estado(rs.getString("postulante_estado"));
                postulante.setPostulante_provincia(rs.getString("postulante_provincia"));
                postulante.setPostulante_canton(rs.getString("postulante_canton"));
                postulante.setPostulante_parroquia(rs.getString("postulante_parroquia"));
                postulante.setPostulante_nacionalidad(rs.getString("postulante_nacionalidad"));
                postulante.setPostulante_estadocivil(rs.getString("postulante_estado_civil"));
                postulante.setPostulante_convencional(rs.getString("postulante_convencional"));
                postulante.setPostulante_cargo(rs.getString("postulante_cargo"));
                postulante.setPostulante_correoelectronico(rs.getString("postulante_correoelectronico"));
                listaPostulantes.add(postulante);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Buscadorpostulantecontr.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPostulantes;
    }

    public void ActualizaEstadoPsotulante(String id) {
        pst = null;
        rs = null;
        try {
            sql_command = "UPDATE public.postulante "
                    + "SET postulante_estado ='In-activo'"
                    + "WHERE postulante_id= ?;";
            pst = cn.getConecction().prepareStatement(sql_command);
            pst.setInt(1, Integer.parseInt(id));
            rs = pst.executeQuery();

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

    public BuscadorPostulantePersonal  asistencia(String cedula) {
        BuscadorPostulantePersonal newbuscarp = null;
        pst = null;
        rs = null;
        try {

            sql_command = "select pos.postulante_id,p.personal_id,concat(pos.postulante_primer_nombre,' ',pos.postulante_apellido_paterno) as Postulante,\n" +
            "concat (p.personal_primer_nombre,' ',p.personal_apellido_paterno) as Personal, p.personal_dni\n" +
            "from personalcontratado pc, postulante  pos, personal p where pos.postulante_dni = '"+cedula+"' \n" +
            "and pos.postulante_dni = pc.postulante_dni and pc.personal_user = p.personal_user ";
            pst = cn.getConecction().prepareStatement(sql_command);
            rs = pst.executeQuery();
            while (rs.next()) {
                newbuscarp = new BuscadorPostulantePersonal(); 

                newbuscarp.setPostulante_id(Integer.valueOf(rs.getString("postulante_id")));
                newbuscarp.setPersonal_id(Integer.valueOf(rs.getString("personal_id")));
                newbuscarp.setPostulante(String.valueOf(rs.getString("postulante"))); 
                newbuscarp.setPersonal(String.valueOf(rs.getString("personal")));
                newbuscarp.setPersonal_dni(Integer.valueOf(rs.getString("personal_dni")));
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
