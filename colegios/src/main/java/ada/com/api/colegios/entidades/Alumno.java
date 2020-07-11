package ada.com.api.colegios.entidades;

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
  @ManyToOne
  @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
  private Curso curso;

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
   * @return the curso
   */
  public Curso getCurso() {
    return curso;
  }

  /**
   * @param curso the curso to set
   */
  public void setCurso(Curso curso) {
    this.curso = curso;
    this.curso.getAlumnos().add(this);
  }

}
