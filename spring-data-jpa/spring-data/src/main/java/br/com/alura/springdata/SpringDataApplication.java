package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private Boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
		System.out.println("online");
	}

	@Override
	public void run(String ...args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Ação?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");

			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.inicial(scanner);
			} else if (action == 2) {
				system = false;
			}
		}
	}

}
