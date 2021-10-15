package br.com.alura.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;

@Service
public class CrudCargoService {
  
  private final CargoRepository cargoRepository;
  private Boolean system = true;

  public CrudCargoService(CargoRepository cargoRepository) {
    this.cargoRepository = cargoRepository;
  }

  public void inicial(Scanner scanner) {
    while(system) {
      System.out.println("Qual ação executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Att");
			System.out.println("3 - Fetch All");
			System.out.println("4 - Deletar");

      int action = scanner.nextInt();
      switch (action) {
        case 1:
          salvar(scanner);
          break;
        case 2:
          update(scanner);
          break;
        case 3:
          fetch();
          break;
        case 4:
          delete(scanner);
          break;
        default:
          system = false;
          break;
      }
    }
  }

  private void salvar(Scanner scanner) {
    System.out.println("Descricao cargo");
    scanner.useDelimiter("\n");
    String descricao = scanner.next();
    Cargo cargo = new Cargo();
    cargo.setDescricao(descricao);
    cargoRepository.save(cargo);
    System.out.println("Salvo");
  }
  
  private void update(Scanner scanner) {
    scanner.useDelimiter("\n");
    System.out.println("ID antigo");
    int id = scanner.nextInt();
    System.out.println("Descricao do cargo");
    String descricao = scanner.next();
    Cargo cargo = new Cargo();
    cargo.setId(id);
    cargo.setDescricao(descricao);
    cargoRepository.save(cargo);
    System.out.println("Atualizado");
  }

  private void fetch() {
    Iterable<Cargo> cargos = cargoRepository.findAll();
    cargos.forEach(cargo -> System.out.println(cargo));
  }

  private void delete(Scanner scanner){
    scanner.useDelimiter("\n");
    System.out.println("ID antigo");
    int id = scanner.nextInt();
    cargoRepository.deleteById(id);
    System.out.println("Deletado!");
  }

}
