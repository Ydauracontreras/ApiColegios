package ada.com.api.colegios.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ada.com.api.colegios.entidades.Profesor;
import ada.com.api.colegios.model.request.ProfesorRequest;
import ada.com.api.colegios.model.response.GenericResponse;
import ada.com.api.colegios.repositorio.ProfesorRepository;
import ada.com.api.colegios.services.ProfesorService;

@RestController
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("/api/profesores")
    public ResponseEntity<?> crearUnAlumno(@RequestBody ProfesorRequest profesor) {
        GenericResponse r = new GenericResponse();
        Profesor nuevo = profesorService.crearUnProfesor(profesor.nombre, profesor.apellido);
        if (nuevo == null) {
            r.isOk = false;
            r.message = "No se pudo crear";
            return ResponseEntity.badRequest().body(r);
        } else {
            r.isOk = true;
            r.id = nuevo.getProfesorId();
            r.message = "Nuevo profesor creado con exito!";
            return ResponseEntity.ok(r);
        }

    }

    @GetMapping("api/profesores")
    public List<Profesor> getProfesor() {
        return profesorService.listaProfesores();
    }

    @GetMapping("api/profesores/{id}")
    public ResponseEntity<?> buscarProfesor(@PathVariable Integer id) {
        Profesor profesor = profesorService.obtenerProfesorId(id);
        if (profesor == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(profesor);
        }

    }

}
