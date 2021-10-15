package org.spark.forum.repository;

import org.spark.forum.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long>{

  Curso findByNome(String nomeCurso);
  
}
