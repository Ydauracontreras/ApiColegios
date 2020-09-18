package ada.com.api.colegios.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ada.com.api.colegios.entidades.Alumno;
import ada.com.api.colegios.model.request.AlumnoRequest;
import ada.com.api.colegios.model.response.GenericResponse;
import ada.com.api.colegios.services.AlumnoService;

@RestController
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @PostMapping("/api/alumnos")
    public ResponseEntity<?> crearUnAlumno(@RequestBody AlumnoRequest alumno) {
        GenericResponse r = new GenericResponse();
        Alumno nuevo = alumnoService.crearUnAlumno(alumno.nombre, alumno.apellido);
        if (nuevo == null) {
            r.isOk = false;
            r.message = "No se pudo crear";
            return ResponseEntity.badRequest().body(r);
        } else {
            r.isOk = true;
            r.id = nuevo.getAlumnoId();
            r.message = "Nuevo alumno creado con exito!";
            return ResponseEntity.ok(r);
        }

    }

    @GetMapping("api/alumnos")
    public List<Alumno> getAlumnos() {
        return alumnoService.listarAlumnos();
    }

    @GetMapping("api/alumnos/{id}")
    public ResponseEntity<?> buscarAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoService.obtenerAlumnoId(id);
        if (alumno == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(alumno);
        }

    }

}