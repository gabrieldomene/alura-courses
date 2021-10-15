package org.spark.forum.config.validacao;

import lombok.Getter;

public class ErroDeFormularioDto {
  
  @Getter private String campo;
  @Getter private String erro;

  public ErroDeFormularioDto(String campo, String erro) {
    this.campo = campo;
    this.erro = erro;
  }
}
