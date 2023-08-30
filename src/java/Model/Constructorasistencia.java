package Model;

public class Constructorasistencia {

    private int personalid, postulanteid, id_asistencia;
    private String fecha,observacion;

    public Constructorasistencia() {
    }

    public Constructorasistencia(int id_asistencia,int personalid, int postulanteid,String fecha,String observacion) {
        this.personalid = personalid;
        this.postulanteid = postulanteid;
        this.fecha = fecha;
        this.observacion = observacion;
        this.id_asistencia = id_asistencia;
    }

    public Constructorasistencia(String personalid, String postulanteid, String Fecha, String actividadobservacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public int getPersonalid() {
        return personalid;
    }

    public void setPersonalid(int personalid) {
        this.personalid = personalid;
    }

    public int getPostulanteid() {
        return postulanteid;
    }

    public void setPostulanteid(int postulanteid) {
        this.postulanteid = postulanteid;
    } 

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    } 

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
 
}
