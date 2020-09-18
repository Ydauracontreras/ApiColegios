package ada.com.api.colegios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import ada.com.api.colegios.entidades.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
