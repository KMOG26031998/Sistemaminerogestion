package Model;

import java.sql.Timestamp;

public class Anticipo {
 private String id_anticiposueldo, personal_id, postulante_id, created_at, montoanticipado;
   
    public Anticipo() {
    }

    public Anticipo(String id_anticiposueldo, String personal_id, String postulante_id, String created_at, String montoanticipado) {
        this.id_anticiposueldo = id_anticiposueldo;
        this.personal_id = personal_id;
        this.postulante_id = postulante_id;
        this.created_at = created_at; 
         this.montoanticipado = montoanticipado; 
    }

    public String getId_anticiposueldo() {
        return id_anticiposueldo;
    }

    public void setId_anticiposueldo(String id_anticiposueldo) {
        this.id_anticiposueldo = id_anticiposueldo;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getMontoanticipado() {
        return montoanticipado;
    }

    public void setMontoanticipado(String montoanticipado) {
        this.montoanticipado = montoanticipado;
    }
 
}
