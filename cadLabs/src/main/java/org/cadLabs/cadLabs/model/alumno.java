package org.cadLabs.cadLabs.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" ,unique = true, nullable = false)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "edad")
	private Long edad;
	@Column(name = "grupo")
	private String grupo;
	@Column(name = "calificacion")
	private Double calificacion;
	
	public alumno(Long id, String nombre, Long edad, String grupo, Double calificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.grupo = grupo;
		this.calificacion = calificacion;
	}//ConstructorAlumno
	
	public alumno() {}//ContructorAlumnoEmpty

	public Long getId() {
		return id;
	}//getId

	public void setId(Long id) {
		this.id = id;
	}//setId

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public Long getEdad() {
		return edad;
	}//getEdad

	public void setEdad(Long edad) {
		this.edad = edad;
	}//setEdad

	public String getGrupo() {
		return grupo;
	}//getGrupo

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}//setGrupo

	public Double getCalificacion() {
		return calificacion;
	}//getCalificacion

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}//setCalificacion
	
}//Alumno

