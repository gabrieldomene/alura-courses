package br.com.alura.springdata.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cargos")
public class Cargo {
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter @Setter private Integer id;
  @Getter @Setter private String descricao;

  @Override
  public String toString() {
    return "Cargo [id=" + id + ", descrição=" + descricao + "]";
  }

}
