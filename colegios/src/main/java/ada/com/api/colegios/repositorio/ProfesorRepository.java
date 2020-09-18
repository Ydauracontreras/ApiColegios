package ada.com.api.colegios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import ada.com.api.colegios.entidades.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

}
