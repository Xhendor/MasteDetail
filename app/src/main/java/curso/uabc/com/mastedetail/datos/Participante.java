package curso.uabc.com.mastedetail.datos;

/**
 * Created by xhendor on 5/4/15.
 */
public class Participante{


    private String nombres;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String aQueTeDedicas;
    public String id;


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getaQueTeDedicas() {
        return aQueTeDedicas;
    }

    public void setaQueTeDedicas(String aQueTeDedicas) {
        this.aQueTeDedicas = aQueTeDedicas;
    }


    @Override
    public String toString() {
        return getNombres()+" "+getApellidoPaterno()+" "+getApellidoMaterno();
    }
}
