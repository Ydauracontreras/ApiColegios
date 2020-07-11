package ada.com.api.colegios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ada.com.api.colegios.entidades.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

}