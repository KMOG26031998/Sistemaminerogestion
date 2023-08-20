package Model;

public class BuscadorPostulante {

    private String postulanteid, postulante_cargo, postulante_estadocivil, postulante_parroquia, postulante_fechanacimiento, postulante_canton, postulante_tipo_dni, postulante_primernombre, postulante_segundonombre, postulante_primerapellido, postulante_segundoapellido, nombrescompleto, postulante_social, postulante_dni, postulante_primer_segundo_nombre, postulante_grupo, postulante_primer_segundo_apellido, postulante_direccion, postulante_provincia, postulante_nacionalidad, postulante_genero, postulante_correoelectronico, postulante_telefono, postulante_convencional;
     public BuscadorPostulante() {
    }

    public BuscadorPostulante(String postulante_tipo_dni, String postulante_cargo, String postulante_estadocivil, String postulante_parroquia, String postulante_canton, String postulante_fechanacimiento, String postulanteid, String postulante_primernombre, String postulante_segundonombre, String postulante_primerapellido, String postulante_segundoapellido, String nombrescompletos, String postulante_dni, String postulante_primer_segundo_nombre, String postulante_primer_segundo_apellido, String postulante_direccion, String postulante_provincia, String postulante_nacionalidad, String postulante_genero, String postulante_correoelectronico, String postulante_social, String postulante_telefono, String postulante_convencional, String postulante_grupo) {
        this.postulante_cargo = postulante_cargo;
        this.postulante_estadocivil = postulante_estadocivil;
        this.postulante_fechanacimiento = postulante_fechanacimiento;
        this.postulante_parroquia = postulante_parroquia;
        this.postulante_canton = postulante_canton;
        this.postulante_tipo_dni = postulante_tipo_dni;
        this.postulanteid = postulanteid;
        this.nombrescompleto = nombrescompletos;
        this.postulante_dni = postulante_dni;
        this.postulante_primer_segundo_nombre =postulante_primer_segundo_nombre;
        this.postulante_primer_segundo_apellido = postulante_primer_segundo_apellido;
        this.postulante_direccion = postulante_direccion;
        this.postulante_provincia = postulante_provincia;
        this.postulante_nacionalidad = postulante_nacionalidad;
        this.postulante_genero = postulante_genero;
        this.postulante_correoelectronico = postulante_correoelectronico;
        this.postulante_social = postulante_social;
        this.postulante_telefono = postulante_telefono;
        this.postulante_convencional = postulante_convencional;
        this.postulante_grupo = postulante_grupo;
        this.postulante_primernombre = postulante_primernombre;
        this.postulante_segundonombre = postulante_segundonombre;
        this.postulante_primerapellido = postulante_primerapellido;
        this.postulante_segundoapellido = postulante_segundoapellido;
    }
 
    public String getNombrescompleto() {
        return nombrescompleto;
    }

    public void setNombrescompleto(String nombrescompleto) {
        this.nombrescompleto = nombrescompleto;
    }

    public String getPostulanteid() {
        return postulanteid;
    }

    public void setPostulanteid(String postulanteid) {
        this.postulanteid = postulanteid;
    }

    public String getPostulante_cargo() {
        return postulante_cargo;
    }

    public void setPostulante_cargo(String postulante_cargo) {
        this.postulante_cargo = postulante_cargo;
    }

    public String getPostulante_estadocivil() {
        return postulante_estadocivil;
    }

    public void setPostulante_estadocivil(String postulante_estadocivil) {
        this.postulante_estadocivil = postulante_estadocivil;
    }

    public String getPostulante_parroquia() {
        return postulante_parroquia;
    }

    public void setPostulante_parroquia(String postulante_parroquia) {
        this.postulante_parroquia = postulante_parroquia;
    }

    public String getPostulante_fechanacimiento() {
        return postulante_fechanacimiento;
    }

    public void setPostulante_fechanacimiento(String postulante_fechanacimiento) {
        this.postulante_fechanacimiento = postulante_fechanacimiento;
    }

    public String getPostulante_canton() {
        return postulante_canton;
    }

    public void setPostulante_canton(String postulante_canton) {
        this.postulante_canton = postulante_canton;
    }

    public String getPostulante_tipo_dni() {
        return postulante_tipo_dni;
    }

    public void setPostulante_tipo_dni(String postulante_tipo_dni) {
        this.postulante_tipo_dni = postulante_tipo_dni;
    }

    public String getPostulante_primernombre() {
        return postulante_primernombre;
    }

    public void setPostulante_primernombre(String postulante_primernombre) {
        this.postulante_primernombre = postulante_primernombre;
    }

    public String getPostulante_segundonombre() {
        return postulante_segundonombre;
    }

    public void setPostulante_segundonombre(String postulante_segundonombre) {
        this.postulante_segundonombre = postulante_segundonombre;
    }

    public String getPostulante_primerapellido() {
        return postulante_primerapellido;
    }

    public void setPostulante_primerapellido(String postulante_primerapellido) {
        this.postulante_primerapellido = postulante_primerapellido;
    }

    public String getPostulante_segundoapellido() {
        return postulante_segundoapellido;
    }

    public void setPostulante_segundoapellido(String postulante_segundoapellido) {
        this.postulante_segundoapellido = postulante_segundoapellido;
    }

    public String getPostulante_social() {
        return postulante_social;
    }

    public void setPostulante_social(String postulante_social) {
        this.postulante_social = postulante_social;
    }

    public String getPostulante_dni() {
        return postulante_dni;
    }

    public void setPostulante_dni(String postulante_dni) {
        this.postulante_dni = postulante_dni;
    }

    public String getPostulante_primer_segundo_nombre() {
        return postulante_primer_segundo_nombre;
    }

    public void setPostulante_primer_segundo_nombre(String postulante_primer_segundo_nombre) {
        this.postulante_primer_segundo_nombre = postulante_primer_segundo_nombre;
    }

    public String getPostulante_grupo() {
        return postulante_grupo;
    }

    public void setPostulante_grupo(String postulante_grupo) {
        this.postulante_grupo = postulante_grupo;
    }

    public String getPostulante_primer_segundo_apellido() {
        return postulante_primer_segundo_apellido;
    }

    public void setPostulante_primer_segundo_apellido(String postulante_primer_segundo_apellido) {
        this.postulante_primer_segundo_apellido = postulante_primer_segundo_apellido;
    }

    public String getPostulante_direccion() {
        return postulante_direccion;
    }

    public void setPostulante_direccion(String postulante_direccion) {
        this.postulante_direccion = postulante_direccion;
    }

    public String getPostulante_provincia() {
        return postulante_provincia;
    }

    public void setPostulante_provincia(String postulante_provincia) {
        this.postulante_provincia = postulante_provincia;
    }

    public String getPostulante_nacionalidad() {
        return postulante_nacionalidad;
    }

    public void setPostulante_nacionalidad(String postulante_nacionalidad) {
        this.postulante_nacionalidad = postulante_nacionalidad;
    }

    public String getPostulante_genero() {
        return postulante_genero;
    }

    public void setPostulante_genero(String postulante_genero) {
        this.postulante_genero = postulante_genero;
    }

    public String getPostulante_correoelectronico() {
        return postulante_correoelectronico;
    }

    public void setPostulante_correoelectronico(String postulante_correoelectronico) {
        this.postulante_correoelectronico = postulante_correoelectronico;
    }

    public String getPostulante_telefono() {
        return postulante_telefono;
    }

    public void setPostulante_telefono(String postulante_telefono) {
        this.postulante_telefono = postulante_telefono;
    }

    public String getPostulante_convencional() {
        return postulante_convencional;
    }

    public void setPostulante_convencional(String postulante_convencional) {
        this.postulante_convencional = postulante_convencional;
    }

    
}
