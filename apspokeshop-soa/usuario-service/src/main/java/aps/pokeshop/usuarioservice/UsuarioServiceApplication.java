package aps.pokeshop.usuarioservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import aps.pokeshop.usuarioservice.Usuario.IRepositorioUsuarios;
import aps.pokeshop.usuarioservice.Usuario.Usuario;

@SpringBootApplication
@EnableEurekaClient
public class UsuarioServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioServiceApplication.class, args);
	}

	@Autowired
	private IRepositorioUsuarios iCadastroUsuarios;

	@Override
	public void run(String... args) throws Exception {
		Usuario usr = new Usuario(1l, "alpvj@cin.ufpe.br", "senha123");
		this.iCadastroUsuarios.save(usr);
	}
}
