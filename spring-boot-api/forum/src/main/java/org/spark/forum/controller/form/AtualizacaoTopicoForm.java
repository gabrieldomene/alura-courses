package org.spark.forum.controller.form;

import org.spark.forum.modelo.Topico;
import org.spark.forum.repository.TopicoRepository;

import lombok.Getter;

public class AtualizacaoTopicoForm {
  

  @Getter private String titulo;
  @Getter private String mensagem;

  public Topico atualizar(Long id, TopicoRepository topicoRepository) {
    
    Topico topico = topicoRepository.getOne(id);

    topico.setTitulo(this.titulo);
    topico.setMensagem(this.mensagem);

    return topico;
  }
}
