package org.spark.forum.repository;

import java.util.List;

import org.spark.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

  List<Topico> findByCurso_Nome(String nomeCurso);
  
}
