 
package DAO;

import BD.conexion;

import Model.ConstructorPersonal;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

 
public class InsertAddPersonal {
public static boolean agregarPersonal(ConstructorPersonal personal) {
    boolean agregado = false;
         

    try {
        conexion c = new conexion();
        Connection con = c.getConecction();

        if (con != null) {
            String query = "INSERT INTO public.personal(\n"
                    + "            personal_tipo_dni, personal_dni, personal_apellido_paterno, \n"
                    + "            personal_primer_nombre, personal_telefono, personal_direccion, created_at, \n"
                    + "            personal_user, personal_pass, personal_apellido_materno, \n"
                    + "            personal_segundo_nombre, personal_provincia, personal_canton, personal_parroquia, \n"
                    + "            personal_estado, gpersonal_departamento, personal_correoelectronico)\n"
                    + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, md5(?), ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, personal.getPersonal_tipo_dni());
            ps.setString(2, personal.getPersonal_dni());
            ps.setString(3, personal.getPersonal_apellido_paterno());
            ps.setString(4, personal.getPersonal_primer_nombre());
            ps.setString(5, personal.getPersonal_telefono());
            ps.setString(6, personal.getPersonal_direccion());
         
            ps.setTimestamp(7,convertirAFechaTimestamp((personal.getCreated_at())));
            ps.setString(8, personal.getPersonal_user());
            ps.setString(9, personal.getPersonal_pass());
            ps.setString(10, personal.getPersonal_apellido_materno());
            ps.setString(11, personal.getPersonal_segundo_nombre());
            ps.setString(12, personal.getPersonal_provincia());
            ps.setString(13, personal.getPersonal_canton());
            ps.setString(14, personal.getPersonal_parroquia());
            ps.setString(15, personal.getPersonal_estado());
            ps.setInt(16,Integer.parseInt(personal.getGpersonal_departamento()));
            ps.setString(17, personal.getPersonal_correoelectronico());
String persona=personal.toString();

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

/*
    public static boolean agregarPersonal(ConstructorPersonal personal) {
        boolean agregado = false;
        try {
            conexion c = new conexion();
            Connection con = c.getConecction();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                st.executeUpdate("INSERT INTO public.personal(\n"
                        + "            personal_tipo_dni, personal_dni, personal_apellido_paterno, \n"
                        + "            personal_primer_nombre, personal_telefono, personal_direccion, created_at, \n"
                        + "            personal_user, personal_pass, personal_apellido_materno, \n"
                        + "            personal_segundo_nombre, personal_provincia, personal_canton, personal_parroquia, \n"
                        + "            personal_estado, gpersonal_departamento, personal_correoelectronico)\n"
                        + "    VALUES ('" + personal.getPersonal_tipo_dni() + "', '" + personal.getPersonal_dni() + "', '" + personal.getPersonal_apellido_paterno() + "', \n"
                        + "            '" + personal.getPersonal_primer_nombre() + "', '" + personal.getPersonal_telefono() + "', '" + personal.getPersonal_direccion() + "', '" + personal.getCreated_at() + "', \n"
                        + "            '" + personal.getPersonal_user() + "', md5('" + personal.getPersonal_pass() + "'), '" + personal.getPersonal_apellido_materno() + "', \n"
                        + "            '" + personal.getPersonal_segundo_nombre() + "', '" + personal.getPersonal_provincia() + "', '" + personal.getPersonal_canton() + "', '" + personal.getPersonal_parroquia() + "', \n"
                        + "            '" + personal.getPersonal_estado() + "', '" + personal.getGpersonal_departamento() + "', '" + personal.getPersonal_correoelectronico() + "');");
                agregado = true;
                st.close();
            }
            c.isConected();
        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }
*/


}
