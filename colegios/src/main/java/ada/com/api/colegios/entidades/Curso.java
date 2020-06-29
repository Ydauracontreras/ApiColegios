package ada.com.api.colegios.entidades;

public class Curso {
    private String nombre;
    private String codigoCurso;

    public boolean equals(Object c) {
        Curso curso = (Curso) c;
        return this.getCodigoCurso().equals(curso.getCodigoCurso());
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
     * @return the codigoCurso
     */
    public String getCodigoCurso() {
        return codigoCurso;
    }

    /**
     * @param codigoCurso the codigoCurso to set
     */
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

}