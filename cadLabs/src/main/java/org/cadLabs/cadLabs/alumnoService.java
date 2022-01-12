package org.cadLabs.cadLabs;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.cadLabs.cadLabs.model.alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class alumnoService {
	
	private final alumnoRepository alumnoRepository;

	@Autowired
	public alumnoService(alumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}//AlumnosService
	
	public List<alumno> getAllalumnos(){
		return alumnoRepository.findAll();
	}//getAllalumnos
	
	public alumno getAlumno(Long id) {
		return alumnoRepository.findById(id).
				orElseThrow(()-> new IllegalStateException("El ALumno con el id [ " + id + " ] no exíste."));
	}//getAlumno
	
	public void deleteAlumno(Long id) {
		if(alumnoRepository.existsById(id)) {
			alumnoRepository.deleteById(id);
		}else {
			throw new IllegalStateException("El alumno con el id [ "+ id + " ] no exíste.");
		}//else
	}//deleteAlumno
	
	public void addAlumno(alumno alumno) {
		Optional<alumno> alumnoName = alumnoRepository.findByName(alumno.getNombre());
		if(alumnoName.isPresent()) {
			throw new IllegalStateException("El alumno con el nombre [ "+ alumno.getNombre() + " ] ya exíste");
		}
		alumnoRepository.save(alumno);
	}//deleteAlumno
	
	@Transactional
	public void updateAlumno(Long id, String nombre, Long edad, String grupo, Double calificacion) {
		alumno alumno = alumnoRepository.findById(id)
				.orElseThrow(()-> new IllegalStateException("El alumno con el id [ "+ id + " ] no exíste."));
		
		if(nombre != null)
			if((!nombre.equals(alumno.getNombre())) && (!nombre.isEmpty()) && (!nombre.contains("[0-9]"))) {
				alumno.setNombre(nombre);
			}//ifNombre
		
		if(edad !=null)
			if((edad > 0 && edad < 100) && (!edad.equals(alumno.getEdad()))) {
				alumno.setEdad(edad);
			}//ifEdad
		
		if(grupo !=null)
			if((!grupo.equals(alumno.getGrupo())) && (!grupo.isEmpty())) {
				alumno.setGrupo(grupo);;
			}//ifGrupo
		
		if(calificacion != null)
			if((!calificacion.equals(alumno.getCalificacion()) && (calificacion >= 0 ) && (!calificacion.isNaN()))) {
				alumno.setCalificacion(calificacion);
			}//ifCalificación
	}//updateAlumno
	
}//alumnoService
