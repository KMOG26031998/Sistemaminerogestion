package Model;

import java.sql.Timestamp;

public class BuscadorPostulantePersonal {

    private Integer postulante_id; 
    private String postulante; 
    private Integer personal_id; 
    private Integer personal_dni;
    private String personal; 
    public BuscadorPostulantePersonal() {
    }

    public BuscadorPostulantePersonal(
        String postulante, String personal, 
        Integer postulante_id, Integer personal_id,Integer personal_dni) {
        this.postulante = postulante; 
        this.personal = personal; 
        this.postulante_id = postulante_id; 
        this.personal_id = personal_id; 
        this.personal_dni = personal_dni;  
}
 

    public Integer getPostulante_id() {
        return postulante_id;
    }

    public void setPostulante_id(Integer postulante_id) {
        this.postulante_id = postulante_id;
    }

    public String getPostulante() {
        return postulante;
    }

    public void setPostulante(String postulante) {
        this.postulante = postulante;
    }

    public Integer getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(Integer personal_id) {
        this.personal_id = personal_id;
    }

    public Integer getPersonal_dni() {
        return personal_dni;
    }

    public void setPersonal_dni(Integer personal_dni) {
        this.personal_dni = personal_dni;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    } 
}