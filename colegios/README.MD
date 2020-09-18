# Colegios-SpringBoot

En este proyecto de práctica, se permite crear un profesor o un alumno, asignarlos a un curso y listar el contenido de una base de datos SQL.

## Estructura de la Base 📦

Tabla: ALUMNO
Columnas: ID_ALUMNO, NOMBRE, APELLIDO

Tabla: PROFESOR
Columnas: ID_PROFESOR, NOMBRE, APELLIDO, ANTIGUEDAD

Tabla: CURSOS
Columnas: ID_CURSO, NOMBRE, CUPO_MAXIMO, ID_ALUMNO, ID_PROFESOR

## Listado de Métodos ⌨️

**- alta()**

### /api/cursos

Método de tipo POST que permite mediante un request con el nombre y cupoMaximo de un curso, crear un nuevo registro dentro de la base de datos generando un id.

### /api/profesores

Método de tipo POST que permite mediante un request con el nombre y apellido de un profesor, crear un nuevo registro dentro de la base de datos generando un id.

### /api/alumnos

Método de tipo POST que permite mediante un request con el nombre y apellido de un estudiante, crear un nuevo registro dentro de la base de datos generando un id.

**- modificacion()**
Método de tipo PUT que toma como parametro un id, busca a la persona en la base, muestra los datos de la persona, pide que el usuario seleccione el dato que desea modificar, solicita el nuevo dato y luego lo persiste en la base.

**- baja()**
Método de tipo DELETE que toma como parametro un id, busca a la persona en la base, muestra los datos de la persona, pide confirmación del usuario y luego borra los datos de la base.

**- listado()**
Método de tipo GET que muestra un listado de todos los datos presentes en la base.

**- buscarXnombre()**
Método de tipo GET que le solicita al usuario que ingrese un nombre o las primeras letras del mismo y trae un listado de todas las personas de la base con las que encuentra correspondencia.

**- mostrarPorID()**
Método de tipo GET que recibe como parámetro un id, realiza la consulta a la base y devuelve los datos de la persona correspondiente.

**- calcularEdad()**
Método de utilización interna que toma como parámetro una fechadenacimiento y utiliza la fecha actual para realizar el cálculo y devolver la edad de la persona.

**- mostrarMenu()**
Método de utilización interna que muestra por pantalla el menu, solicita al usuario que ingrese una opcion, la guarda en una variable y la devuelve.

COLEGIOS APIREST

Ruta Método Funcionalidad
GET Consultar todos los cursos
/api/cursos/1 GET Consultar los cursos con id 1
/api/alumno/1/cursos GET Consultar los cursos del alumno con id 1
/api/profesor/1/cursos GET Consultar los cursos del profesor con id 1
/api/alumno/1/profesor/2/cursos POST Registrar el curso enviado con profesorId = 1 y profesorId = 2
/api/alumno/1/profesor/2/curso/1 PUT Actualizar el curso enviado con cursoId=1, alumnoId = 1 y profesorId = 2
/api/cursos/2 DELETE Eliminar el curso con 2
