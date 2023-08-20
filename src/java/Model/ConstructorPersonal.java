
package Model;

public class ConstructorPersonal {

    String personal_tipo_dni, personal_dni, personal_apellido_paterno,
           personal_primer_nombre, personal_telefono, personal_direccion, created_at,
            personal_user, personal_pass, personal_apellido_materno,
            personal_segundo_nombre, personal_provincia, personal_canton, personal_parroquia,
            personal_estado, personal_correoelectronico;
    String gpersonal_departamento;

    public ConstructorPersonal(String personal_tipo_dni, String personal_dni, String personal_apellido_paterno, String personal_primer_nombre, String personal_telefono, String personal_direccion, String created_at, String personal_user, String personal_pass, String personal_apellido_materno, String personal_segundo_nombre, String personal_provincia, String personal_canton, String personal_parroquia, String personal_estado, String gpersonal_departamento, String personal_correoelectronico) {
        this.personal_tipo_dni = personal_tipo_dni;
        this.personal_dni = personal_dni;
        this.personal_apellido_paterno = personal_apellido_paterno;
        this.personal_primer_nombre = personal_primer_nombre;
        this.personal_telefono = personal_telefono;
        this.personal_direccion = personal_direccion;
        this.created_at = created_at;
        this.personal_user = personal_user;
        this.personal_pass = personal_pass;
        this.personal_apellido_materno = personal_apellido_materno;
        this.personal_segundo_nombre = personal_segundo_nombre;
        this.personal_provincia = personal_provincia;
        this.personal_canton = personal_canton;
        this.personal_parroquia = personal_parroquia;
        this.personal_estado = personal_estado;
        this.gpersonal_departamento = gpersonal_departamento;
        this.personal_correoelectronico = personal_correoelectronico;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPersonal_tipo_dni() {
        return personal_tipo_dni;
    }

    public void setPersonal_tipo_dni(String personal_tipo_dni) {
        this.personal_tipo_dni = personal_tipo_dni;
    }

    public String getPersonal_dni() {
        return personal_dni;
    }

    public void setPersonal_dni(String personal_dni) {
        this.personal_dni = personal_dni;
    }

    public String getPersonal_apellido_paterno() {
        return personal_apellido_paterno;
    }

    public void setPersonal_apellido_paterno(String personal_apellido_paterno) {
        this.personal_apellido_paterno = personal_apellido_paterno;
    }

    public String getPersonal_primer_nombre() {
        return personal_primer_nombre;
    }

    public void setPersonal_primer_nombre(String personal_primer_nombre) {
        this.personal_primer_nombre = personal_primer_nombre;
    }

    public String getPersonal_telefono() {
        return personal_telefono;
    }

    public void setPersonal_telefono(String personal_telefono) {
        this.personal_telefono = personal_telefono;
    }

    public String getPersonal_direccion() {
        return personal_direccion;
    }

    public void setPersonal_direccion(String personal_direccion) {
        this.personal_direccion = personal_direccion;
    }

    public String getPersonal_user() {
        return personal_user;
    }

    public void setPersonal_user(String personal_user) {
        this.personal_user = personal_user;
    }

    public String getPersonal_pass() {
        return personal_pass;
    }

    public void setPersonal_pass(String personal_pass) {
        this.personal_pass = personal_pass;
    }

    public String getPersonal_apellido_materno() {
        return personal_apellido_materno;
    }

    public void setPersonal_apellido_materno(String personal_apellido_materno) {
        this.personal_apellido_materno = personal_apellido_materno;
    }

    public String getPersonal_segundo_nombre() {
        return personal_segundo_nombre;
    }

    public void setPersonal_segundo_nombre(String personal_segundo_nombre) {
        this.personal_segundo_nombre = personal_segundo_nombre;
    }

    public String getPersonal_provincia() {
        return personal_provincia;
    }

    public void setPersonal_provincia(String personal_provincia) {
        this.personal_provincia = personal_provincia;
    }

    public String getPersonal_canton() {
        return personal_canton;
    }

    public void setPersonal_canton(String personal_canton) {
        this.personal_canton = personal_canton;
    }

    public String getPersonal_parroquia() {
        return personal_parroquia;
    }

    public void setPersonal_parroquia(String personal_parroquia) {
        this.personal_parroquia = personal_parroquia;
    }

    public String getPersonal_estado() {
        return personal_estado;
    }

    public void setPersonal_estado(String personal_estado) {
        this.personal_estado = personal_estado;
    }

    public String getPersonal_correoelectronico() {
        return personal_correoelectronico;
    }

    public void setPersonal_correoelectronico(String personal_correoelectronico) {
        this.personal_correoelectronico = personal_correoelectronico;
    }

    public String getGpersonal_departamento() {
        return gpersonal_departamento;
    }

    public void setGpersonal_departamento(String gpersonal_departamento) {
        this.gpersonal_departamento = gpersonal_departamento;
    }

@Override
    public String toString() {
        return "Personal{" +
                "personal_tipo_dni='" + personal_tipo_dni + '\'' +
                ", personal_dni='" + personal_dni + '\'' +
                ", personal_apellido_paterno='" + personal_apellido_paterno + '\'' +
                ", personal_primer_nombre='" + personal_primer_nombre + '\'' +
                ", personal_telefono='" + personal_telefono + '\'' +
                ", personal_direccion='" + personal_direccion + '\'' +
                ", created_at=" + created_at +
                ", personal_user='" + personal_user + '\'' +
                ", personal_pass='" + personal_pass + '\'' +
                ", personal_apellido_materno='" + personal_apellido_materno + '\'' +
                ", personal_segundo_nombre='" + personal_segundo_nombre + '\'' +
                ", personal_provincia='" + personal_provincia + '\'' +
                ", personal_canton='" + personal_canton + '\'' +
                ", personal_parroquia='" + personal_parroquia + '\'' +
                ", personal_estado='" + personal_estado + '\'' +
                ", personal_correoelectronico='" + personal_correoelectronico + '\'' +
                ", gpersonal_departamento='" + gpersonal_departamento + '\'' +
                '}';
    }
}
