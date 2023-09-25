
package Model;

public class Asistencia {
    
    private String id_asistencia, personal_id, postulante_id, fecha, actividadobservacion;

    public Asistencia() {
    }

    public Asistencia(String id_asistencia, String personal_id, String postulante_id, String fecha, String actividadobservacion) {
        this.id_asistencia = id_asistencia;
        this.personal_id = personal_id;
        this.postulante_id = postulante_id;
        this.fecha = fecha;
        this.actividadobservacion = actividadobservacion;
    }

    public String getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(String id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public String getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    public String getPostulante_id() {
        return postulante_id;
    }

    public void setPostulante_id(String postulante_id) {
        this.postulante_id = postulante_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getActividadobservacion() {
        return actividadobservacion;
    }

    public void setActividadobservacion(String actividadobservacion) {
        this.actividadobservacion = actividadobservacion;
    }

    
    
}
