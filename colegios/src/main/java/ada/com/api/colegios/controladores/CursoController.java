package ada.com.api.colegios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ada.com.api.colegios.entidades.Curso;
import ada.com.api.colegios.model.request.AsignarProfesorRequest;
import ada.com.api.colegios.model.request.CursoRequest;
import ada.com.api.colegios.model.request.InscripcionAlumno;
import ada.com.api.colegios.model.response.GenericResponse;
import ada.com.api.colegios.services.CursoService;

@RestController
public class CursoController {
    @Autowired
    CursoService cursoService;

    @PostMapping("/api/cursos")
    public ResponseEntity<?> crearUnCurso(@RequestBody CursoRequest curso) {
        GenericResponse r = new GenericResponse();
        Curso cursoNuevo = cursoService.creaCurso(curso.nombre, curso.cupoMaximo);
        if (cursoNuevo == null) {
            r.isOk = false;
            r.message = "No se pudo crear el curso";
            return ResponseEntity.badRequest().body(r);

        } else {

            r.isOk = true;
            r.id = cursoNuevo.getCursoId();
            r.message = "Creaste el curso con exito";
            return ResponseEntity.ok(r);

        }

    }

    // /api/cursos GET Consultar todos los cursos

    @GetMapping("/api/cursos")
    public ResponseEntity<?> listarTodosLosCursos() {
        return ResponseEntity.ok(cursoService.listarTodosLosCursos());
    }

    // /api/cursos/1 GET Consultar los cursos con id 1

    @GetMapping("/api/cursos/{id}")
    public ResponseEntity<?> buscarCursoSegunId(@PathVariable Integer id) {
        Curso curso = cursoService.obtenerCurso(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);

    }

    /// api/alumno/1/cursos GET Consultar los cursos del alumno con id 1

    @PostMapping("api/cursos/{id}/alumnos")
    public ResponseEntity<?> obtenerCursosPorAlumno(@PathVariable Integer id, @RequestBody InscripcionAlumno alumno) {
        GenericResponse r = new GenericResponse();
        if (cursoService.asignarCurso(id, alumno.alumnoId)) {
            r.isOk = true;
            r.message = "Alumno inscrito con exito al curso " + cursoService.obtenerCurso(id).getNombre();
            return ResponseEntity.ok(r);
        }

        else {
            r.isOk = false;
            r.message = "No se pudo asignar al curso indicado";
            return ResponseEntity.badRequest().body(r);

        }

    }

    @PostMapping("api/cursos/{id}/profesores")
    public ResponseEntity<?> obtenerCursosPorProfesor(@PathVariable Integer id,
            @RequestBody AsignarProfesorRequest profesor) {
        GenericResponse r = new GenericResponse();
        if (cursoService.asignarCursoProfesor(id, profesor.profesorId)) {
            r.isOk = true;
            r.message = "Se asigno con exito al curso " + cursoService.obtenerCurso(id).getNombre();
            return ResponseEntity.ok(r);
        }

        else {
            r.isOk = false;
            r.message = "No se pudo asignar al curso indicado";
            return ResponseEntity.badRequest().body(r);

        }

    }

}
