package ada.com.api.colegios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ada.com.api.colegios.entidades.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}