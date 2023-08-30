package Model;

import java.sql.Timestamp;

public class Constructoranticiposueldo {

    private int personalid, postulanteid;
    private int montoanticipado;
    private Timestamp created_at ;
    public Constructoranticiposueldo() {
    }

    public Constructoranticiposueldo(int montoanticipado,int personalid, int postulanteid ) {
        this.personalid = personalid;
        this.postulanteid = postulanteid; 
 this.montoanticipado = montoanticipado; 
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

    public int getMontoanticipado() {
        return montoanticipado;
    }

    public void setMontoanticipado(int montoanticipado) {
        this.montoanticipado = montoanticipado;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    
}
