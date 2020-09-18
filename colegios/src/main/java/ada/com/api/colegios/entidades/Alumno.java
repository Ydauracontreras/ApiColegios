package ada.com.api.colegios.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_alumno")
  private Integer alumnoId;
  private String nombre;
  private String apellido;
  @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
   * @return the alumnoId
   */
  public Integer getAlumnoId() {
    return alumnoId;
  }

  /**
   * @param alumnoId the alumnoId to set
   */
  public void setAlumnoId(Integer alumnoId) {
    this.alumnoId = alumnoId;
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
