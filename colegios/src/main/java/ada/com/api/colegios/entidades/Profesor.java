package ada.com.api.colegios.entidades;

public class Profesor {
    private String nombre;
    private String apellido;
    private Integer antiguedad;
    private Integer codigoProfesor;

    public boolean equals(Object profesor) {
        Profesor p = (Profesor) profesor;
        return this.getCodigoProfesor().equals(p.getCodigoProfesor());
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the antiguedad
     */
    public Integer getAntiguedad() {
        return antiguedad;
    }

    /**
     * @param antiguedad the antiguedad to set
     */
    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    /**
     * @return the codigoProfesor
     */
    public Integer getCodigoProfesor() {
        return codigoProfesor;
    }

    /**
     * @param codigoProfesor the codigoProfesor to set
     */
    public void setCodigoProfesor(Integer codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

}