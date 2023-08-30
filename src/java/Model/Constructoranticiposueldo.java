package Model;

public class Constructorasistencia {

    private int personalid, postulanteid;
    private String nombrespersonal,fecha, id_asistencia, asistencia, observacion;

    public Constructorasistencia() {
    }

    public Constructorasistencia(int personalid, int postulanteid, String nombrespersonal,String fecha, String asistencia, String observacion) {
        this.personalid = personalid;
        this.postulanteid = postulanteid;
        this.fecha = fecha;
        this.asistencia = asistencia;
        this.observacion = observacion;
        this.nombrespersonal = nombrespersonal;
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

    public String getNombrespersonal() {
        return nombrespersonal;
    }

    public void setNombrespersonal(String nombrespersonal) {
        this.nombrespersonal = nombrespersonal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(String id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
 
}
