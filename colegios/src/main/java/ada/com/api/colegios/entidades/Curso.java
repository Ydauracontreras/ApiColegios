package ada.com.api.colegios.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer cursoId;
    private String nombre;
    private Integer cupoMaximo;
    @OneToMany(mappedBy = "alumnos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Alumno> alumnos = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    private Profesor profesor;

    /**
     * @return the cursoId
     */
    public Integer getCursoId() {
        return cursoId;
    }

    /**
     * @param cursoId the cursoId to set
     */
    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
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
     * @return the cupoMaximo
     */
    public Integer getCupoMaximo() {
        return cupoMaximo;
    }

    /**
     * @param cupoMaximo the cupoMaximo to set
     */
    public void setCupoMaximo(Integer cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
        this.profesor.getListaDeCursos().add(this);
    }

    /**
     * @return the alumnos
     */
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * @param alumnos the alumnos to set
     */
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

}