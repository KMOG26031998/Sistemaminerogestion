package Model;

public class IngresoPersonalcontratado {

    private int postulante_id;
    private String experiencialaboral,refenciapersonal,referencialaboral,cursosrealizados,habilidades,actitudes,estudioprimario,estudiosecundario,estudiotercernivel,estudiaactual,fechaingreso, motivoingreso,estadotrabajo,observacion,cargararchivocv;

    public IngresoPersonalcontratado() {
    }

    public IngresoPersonalcontratado(int postulante_id, String experiencialaboral, String refenciapersonal, String referencialaboral, String cursosrealizados, String habilidades, String actitudes, String estudioprimario, String estudiosecundario, String estudiotercernivel, String estudiaactual, String fechaingreso, String motivoingreso, String estadotrabajo, String observacion, String cargararchivocv) {
        this.postulante_id = postulante_id;
        this.experiencialaboral = experiencialaboral;
        this.refenciapersonal = refenciapersonal;
        this.referencialaboral = referencialaboral;
        this.cursosrealizados=cursosrealizados;
        this.habilidades = habilidades;
        this.actitudes = actitudes; 
        this.estudioprimario = estudioprimario;
        this.estudiosecundario = estudiosecundario;
        this.estudiotercernivel = estudiotercernivel;
        this.estudiaactual = estudiaactual;
        this.fechaingreso = fechaingreso;
        this.motivoingreso = motivoingreso;
        this.estadotrabajo = estadotrabajo;
        this.observacion = observacion;
        this.cargararchivocv = cargararchivocv;
    }

    public int getPostulante_id() {
        return postulante_id;
    }

    public void setPostulante_id(int postulante_id) {
        this.postulante_id = postulante_id;
    }

    public String getExperiencialaboral() {
        return experiencialaboral;
    }

    public void setExperiencialaboral(String experiencialaboral) {
        this.experiencialaboral = experiencialaboral;
    }

    public String getRefenciapersonal() {
        return refenciapersonal;
    }

    public void setRefenciapersonal(String refenciapersonal) {
        this.refenciapersonal = refenciapersonal;
    }

    public String getReferencialaboral() {
        return referencialaboral;
    }

    public void setReferencialaboral(String referencialaboral) {
        this.referencialaboral = referencialaboral;
    }

    public String getCursosrealizados() {
        return cursosrealizados;
    }

    public void setCursosrealizados(String cursosrealizados) {
        this.cursosrealizados = cursosrealizados;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getActitudes() {
        return actitudes;
    }

    public void setActitudes(String actitudes) {
        this.actitudes = actitudes;
    }

    public String getEstudioprimario() {
        return estudioprimario;
    }

    public void setEstudioprimario(String estudioprimario) {
        this.estudioprimario = estudioprimario;
    }

    public String getEstudiosecundario() {
        return estudiosecundario;
    }

    public void setEstudiosecundario(String estudiosecundario) {
        this.estudiosecundario = estudiosecundario;
    }

    public String getEstudiotercernivel() {
        return estudiotercernivel;
    }

    public void setEstudiotercernivel(String estudiotercernivel) {
        this.estudiotercernivel = estudiotercernivel;
    }

    public String getEstudiaactual() {
        return estudiaactual;
    }

    public void setEstudiaactual(String estudiaactual) {
        this.estudiaactual = estudiaactual;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getMotivoingreso() {
        return motivoingreso;
    }

    public void setMotivoingreso(String motivoingreso) {
        this.motivoingreso = motivoingreso;
    }

    public String getEstadotrabajo() {
        return estadotrabajo;
    }

    public void setEstadotrabajo(String estadotrabajo) {
        this.estadotrabajo = estadotrabajo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCargararchivocv() {
        return cargararchivocv;
    }

    public void setCargararchivocv(String cargararchivocv) {
        this.cargararchivocv = cargararchivocv;
    }

  
}
