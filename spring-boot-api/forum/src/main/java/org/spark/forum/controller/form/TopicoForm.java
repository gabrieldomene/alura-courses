package org.spark.forum.controller.form;

import org.spark.forum.modelo.Curso;
import org.spark.forum.modelo.Topico;
import org.spark.forum.repository.CursoRepository;

import lombok.Getter;

public class TopicoForm {
  
  @Getter private String titulo;

  @Getter private String mensagem;

  @Getter private String nomeCurso;

  public Topico converter(CursoRepository CursoRepository) {
    Curso curso = CursoRepository.findByNome(nomeCurso);
    return new Topico(titulo, mensagem, curso);
  }

}
