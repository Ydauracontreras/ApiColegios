package ada.com.api.colegios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ada.com.api.colegios.entidades.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}