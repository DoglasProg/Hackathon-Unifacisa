package com.hackaton.unifacisa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hackaton.unifacisa.domain.Alimento;
import com.hackaton.unifacisa.domain.Usuario;
import com.hackaton.unifacisa.repositories.AlimentoRepository;
import com.hackaton.unifacisa.repositories.UsuarioRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AlimentoRepository alimentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Alimento ali1 = new Alimento(null, "batata", 5, 7, 2, 9, 15, 15);
		Alimento ali2 = new Alimento(null, "mamão", 1, 8, 0, 5, 1, 10);
		
		alimentoRepository.saveAll(Arrays.asList(ali1,ali2));
		
		Usuario user = new Usuario(null, "Abella","987654321", "abella@gmail.com",pe.encode("123"), 40, 100, 90);
		Usuario user1 = new Usuario(null, "Maria","987654000", "Maria@gmail.com", pe.encode("123"), 25, 115, 50);
		
		usuarioRepository.saveAll(Arrays.asList(user,user1));
		
	}


	
	
}
