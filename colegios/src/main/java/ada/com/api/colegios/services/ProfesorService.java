package ada.com.api.colegios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ada.com.api.colegios.entidades.Profesor;
import ada.com.api.colegios.repositorio.ProfesorRepository;

@Service
public class ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;

    public boolean grabar(Profesor profesor) {
        profesorRepository.save(profesor);
        return true;
    }

    public Profesor crearUnProfesor(String nombre, String apellido) {
        Profesor profesorNuevo = new Profesor();
        profesorNuevo.setNombre(nombre);
        profesorNuevo.setApellido(apellido);
        profesorNuevo.setAntiguedad(0);
        boolean nuevo = grabar(profesorNuevo);
        return (nuevo ? profesorNuevo : null);
    }

    public List<Profesor> listaProfesores() {
        return profesorRepository.findAll();
    }

    public Profesor obtenerProfesorId(Integer id) {
        // Optional<Alumno> a = alumnoRepository.findById(id);
        Optional<Profesor> p = this.listaProfesores().stream().filter(pr -> id.equals(pr.getProfesorId())).findFirst();
        return (p.isPresent() ? p.get() : null);
    }

}
