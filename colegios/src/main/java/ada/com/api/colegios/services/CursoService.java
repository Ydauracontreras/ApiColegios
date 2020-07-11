package ada.com.api.colegios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ada.com.api.colegios.repositorio.CursoRepository;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

}