package org.cadLabs.cadLabs;

import java.util.Optional;

import org.cadLabs.cadLabs.model.alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface alumnoRepository extends JpaRepository<alumno, Long>{

	@Query("SELECT a FROM alumno a WHERE a.nombre=?1")
	Optional<alumno>findByName(String nombre);
}
