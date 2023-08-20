package DAO;

import BD.conexion;
import Model.ControladorPostulante;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertAddPostulante {

    public static boolean agregarUsuario(ControladorPostulante usuario) {
        boolean agregado = false;
        try {
            conexion c = new conexion();
            Connection con = c.getConecction();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                st.executeUpdate("INSERT INTO postulante(postulante_tipo_dni, postulante_dni, postulante_apellido_paterno, \n"
                        + "            postulante_primer_nombre, postulante_fnacimiento, postulante_direccion, \n"
                        + "            postulante_telefono, postulante_genero, postulante_grupo, postulante_social, \n"
                        + "            postulante_apellido_materno, paciente_segundo_nombre, \n"
                        + "            postulante_provincia, postulante_canton, postulante_parroquia, \n"
                        + "            postulante_nacionalidad, postulante_estado_civil, postulante_convencional, \n"
                        + "            postulante_cargo,postulante_correoelectronico)VALUES ('" + usuario.getPostulante_tipo_dni() + "','" + usuario.getPostulante_dni() + "','" + usuario.getPostulante_apellido_paterno()
                        + "','" + usuario.getPostulante_primer_nombre() + "','" + usuario.getPostulante_fnacimiento() + "','" + usuario.getPostulante_direccion()
                        + "','" + usuario.getPostulante_telefono() + "','" + usuario.getPostulante_genero() + "','" + usuario.getPostulante_grupo()
                        + "','" + usuario.getPostulante_social() + "','" + usuario.getPostulante_apellido_materno()
                        + "','" + usuario.getPostulante_segundo_nombre() + "','" + usuario.getPostulante_provincia()
                        + "','" + usuario.getPostulante_canton() + "','" + usuario.getPostulante_parroquia() + "','" + usuario.getPostulante_nacionalidad()
                        + "','" + usuario.getPostulante_estado_civil() + "','" + usuario.getPostulante_convencional() + "','" + usuario.getPostulante_cargo()
                        + "','" + usuario.getPostulante_email() + "')");
                agregado = true;
                st.close();
            }
            c.isConected();
        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

}
