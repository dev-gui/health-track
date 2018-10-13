package br.com.fiap;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.domain.Peso;
import br.com.fiap.domain.Usuario;
import br.com.fiap.repository.PesoRepository;
import br.com.fiap.repository.UsuarioRepository;

@SpringBootApplication
public class HealthTrack2Application implements CommandLineRunner{

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UsuarioRepository usuario;
	
	@Autowired
	private PesoRepository peso;
	
	public static void main(String[] args) {
		SpringApplication.run(HealthTrack2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario(null, "Guilherme", "Tavares", 'M', 1.80f, sdf.parse("18/01/1988"), "gt.guilherme@gmail.com", "1234");
		usuario.save(user1);
		
		Peso p1 = new Peso(null, 70f, sdf.parse("29/09/2018"), user1);
		Peso p2 = new Peso(null, 71f, sdf.parse("30/09/2018"), user1);
		Peso p3 = new Peso(null, 72f, sdf.parse("09/10/2018"), user1);
		Peso p4 = new Peso(null, 69f, sdf.parse("10/10/2018"), user1);
		Peso p5 = new Peso(null, 70f, sdf.parse("11/10/2018"), user1);
		Peso p6 = new Peso(null, 73f, sdf.parse("12/10/2018"), user1);
		Peso p7 = new Peso(null, 75f, sdf.parse("13/10/2018"), user1);
		Peso p8 = new Peso(null, 71f, sdf.parse("14/10/2018"), user1);
		
		peso.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
	}
}
