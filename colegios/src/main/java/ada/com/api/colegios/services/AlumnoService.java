package ada.com.api.colegios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ada.com.api.colegios.entidades.Alumno;
import ada.com.api.colegios.repositorio.AlumnoRepository;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    CursoService cursoService;

    public boolean grabar(Alumno alumno) {
        alumnoRepository.save(alumno);
        return true;
    }

    public Alumno crearUnAlumno(String nombre, String apellido) {
        Alumno alumnoNuevo = new Alumno();
        alumnoNuevo.setNombre(nombre);
        alumnoNuevo.setApellido(apellido);
        boolean nuevo = grabar(alumnoNuevo);
        return (nuevo ? alumnoNuevo : null);
    }

    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno obtenerAlumnoId(Integer id) {
        // Optional<Alumno> a = alumnoRepository.findById(id);
        Optional<Alumno> a = this.listarAlumnos().stream().filter(al -> id.equals(al.getAlumnoId())).findFirst();
        return (a.isPresent() ? a.get() : null);
    }

}