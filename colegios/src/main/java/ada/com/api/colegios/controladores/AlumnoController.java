package ada.com.api.colegios.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import ada.com.api.colegios.services.AlumnoService;

@RestController
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

}