package aps.pokeshop.apspokeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import aps.pokeshop.apspokeshop.Oferta.ICadastroOfertas;
import aps.pokeshop.apspokeshop.Usuario.ICadastroUsuarios;
import aps.pokeshop.apspokeshop.Usuario.Usuario;

@SpringBootApplication
public class ApspokeshopApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApspokeshopApplication.class, args);
	}

	@Autowired
	private ICadastroUsuarios iCadastroUsuarios;
	@Autowired
	private ICadastroOfertas iCadastroOfertas;

	@Override
	public void run(String... args) throws Exception {
		Usuario usr = new Usuario(1l, "alpvj@cin.ufpe.br", "senha123");
		this.iCadastroUsuarios.save(usr);
	}

}
