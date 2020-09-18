package ada.com.api.colegios.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ada.com.api.colegios.entidades.Alumno;
import ada.com.api.colegios.entidades.Curso;
import ada.com.api.colegios.entidades.Profesor;
import ada.com.api.colegios.repositorio.CursoRepository;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    AlumnoService alumnoService;

    @Autowired
    ProfesorService profesorService;

    // Crea un nuevo curso
    public boolean grabar(Curso curso) {
        cursoRepository.save(curso);
        return true;
    }

    public Curso creaCurso(String nombre, Integer cupoMaximo) {
        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.setCupoMaximo(cupoMaximo);
        boolean cursoNuevo = grabar(curso);
        if (cursoNuevo)
            return curso;
        else
            return null;
    }

    // /api/cursos GET Consultar todos los cursos
    public List<Curso> listarTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCurso(Integer id) {
        /*
         * Optional<Curso> c = cursoRepository.findById(id); return (c.isPresent() ?
         * c.get() : null);
         */
        Optional<Curso> curso = this.listarTodosLosCursos().stream().filter(c -> id.equals(c.getCursoId())).findFirst();
        return (curso.isPresent() ? curso.get() : null);
    }

    public List<Curso> consultarCusosPorAlumno(Integer id) {
        return this.listarTodosLosCursos().stream().filter(c -> c.getAlumno().getCursos().size() > 0)
                .collect(Collectors.toList());
        // return alumnoService.obtenerAlumnoId(id).getCursos();
    }

    // Inscribir un Alumno al Curso
    public boolean asignarCurso(Integer cursoId, Integer alumnoId) {
        Curso curso = this.obtenerCurso(cursoId);
        Alumno alumno = alumnoService.obtenerAlumnoId(alumnoId);
        alumno.getCursos().add(curso);
        curso.setAlumno(alumno);
        this.alumnoService.grabar(alumno);
        return (grabar(curso) ? true : false);

    }

    // Asignar un profesor al Curso

    public boolean asignarCursoProfesor(Integer cursoId, Integer profesorId) {
        Curso curso = this.obtenerCurso(cursoId);
        Profesor profesor = profesorService.obtenerProfesorId(profesorId);
        profesor.getCursos().add(curso);
        curso.setProfesor(profesor);
        this.profesorService.grabar(profesor);
        return (grabar(curso) ? true : false);

    }

}
