package ada.com.api.colegios.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private int profesorId;
    private String nombre;
    private String apellido;
    private Integer antiguedad;
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Curso> cursos = new ArrayList<>();

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
     * @return the profesorId
     */
    public int getProfesorId() {
        return profesorId;
    }

    /**
     * @param profesorId the profesorId to set
     */
    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    /**
     * @return the cursos
     */
    public List<Curso> getCursos() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}