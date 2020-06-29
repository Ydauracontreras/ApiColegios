package ada.com.api.colegios.entidades;

public class Alumno {
  private String nombre;
  private String apellido;
  private Integer codigoAlumno;

  /**
   * @param nombre
   * @param apellido
   * @param codigoAlumno
   */
  public Alumno(String nombre, String apellido, Integer codigoAlumno) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.codigoAlumno = codigoAlumno;
  }

  public boolean equals(Object alumno) {
    Alumno a = (Alumno) alumno;
    return this.getCodigoAlumno().equals(a.getCodigoAlumno());

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
   * @return the codigoAlumno
   */
  public Integer getCodigoAlumno() {
    return codigoAlumno;
  }

  /**
   * @param codigoAlumno the codigoAlumno to set
   */
  public void setCodigoAlumno(Integer codigoAlumno) {
    this.codigoAlumno = codigoAlumno;
  }

}
