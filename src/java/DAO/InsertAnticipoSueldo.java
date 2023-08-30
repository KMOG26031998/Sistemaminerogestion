package DAO;
import BD.conexion;
import Model.Constructoranticiposueldo;  
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertAnticipoSueldo {

public static boolean agregarAnticipoSueldo(Constructoranticiposueldo AnticipoSueldo) {
        boolean agregado = false;
        try {
            conexion c = new conexion();
            Connection con = c.getConecction();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                String sql="INSERT INTO anticiposueldo(personal_id, postulante_id,montoanticipado, \n"
                        + "            created_at )VALUES ('" + AnticipoSueldo.getPersonalid() + "','" + AnticipoSueldo.getPostulanteid() 
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
