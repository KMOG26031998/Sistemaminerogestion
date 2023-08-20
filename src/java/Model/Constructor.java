
package Model;

public class Constructor {

    private int personal_id;
    private String personal_user, personal_pass, personal_dni, personal_primer_nombre, personal_telefono, personal_direccion, personal_segundo_nombre, personal_provincia, personal_canton, personal_parroquia, personal_correoelectronico;

    public Constructor() {
    }

    public Constructor(int personal_id, String personal_user, String personal_pass, String personal_dni, String personal_primer_nombre, String personal_telefono, String personal_direccion, String personal_segundo_nombre, String personal_provincia, String personal_canton, String personal_parroquia, String personal_correoelectronico) {
        this.personal_id = personal_id;
        this.personal_user = personal_user;
        this.personal_pass = personal_pass;
        this.personal_dni = personal_dni;
        this.personal_primer_nombre = personal_primer_nombre;
        this.personal_telefono = personal_telefono;
        this.personal_direccion = personal_direccion;
        this.personal_segundo_nombre = personal_segundo_nombre;
        this.personal_provincia = personal_provincia;
        this.personal_canton = personal_canton;
        this.personal_parroquia = personal_parroquia;
        this.personal_correoelectronico = personal_correoelectronico;
    }

    public Constructor(String personal_user, String personal_pass) {
        this.personal_user = personal_user;
        this.personal_pass = personal_pass;
    }

    public int getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(int personal_id) {
        this.personal_id = personal_id;
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

    public String getPersonal_dni() {
        return personal_dni;
    }

    public void setPersonal_dni(String personal_dni) {
        this.personal_dni = personal_dni;
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

    public String getGaleno_direccion() {
        return personal_direccion;
    }

    public void setPersonal_direccion(String personal_direccion) {
        this.personal_direccion = personal_direccion;
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

    public String getPersonal_correoelectronico() {
        return personal_correoelectronico;
    }

    public void setPersonal_correoelectronico(String personal_correoelectronico) {
        this.personal_correoelectronico = personal_correoelectronico;
    }

}
