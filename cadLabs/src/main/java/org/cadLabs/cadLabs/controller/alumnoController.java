package org.cadLabs.cadLabs.controller;

import java.util.List;
import org.cadLabs.cadLabs.alumnoService;
import org.cadLabs.cadLabs.model.alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controlEscolar")
@CrossOrigin("*")
public class alumnoController {
	
	private final alumnoService alumnoService;

	@Autowired
	public alumnoController(alumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}//AlumnoControllerConstructor
	
	
	@GetMapping
	public List<alumno> getAllalumnos() {
		return alumnoService.getAllalumnos();
	}//getAllalumnos
	
	@PostMapping
	public void altaAlumno(@RequestBody alumno alumno) {
		alumnoService.addAlumno(alumno);
	}//altaAlumno
	
	@GetMapping(path = "{id}")
	public alumno getAlumno(@PathVariable("id") Long id) {
		return alumnoService.getAlumno(id);
	}//getAlumno
	
	@DeleteMapping(path = "{id}")
	public void bajaAlumno(@PathVariable("id") Long id) {
		alumnoService.deleteAlumno(id);
	}//bajaAlumno
	
	@PutMapping(path = "{id}")
	public void updateAlumno(@PathVariable("id") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) Long edad,
			@RequestParam(required = false) String grupo,
			@RequestParam(required = false) Double calificacion) {
		alumnoService.updateAlumno(id, nombre, edad, grupo, calificacion);
	}//updateAlumno
	
	
	
	

}//alumnoController
