package com.hackaton.unifacisa.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hackaton.unifacisa.domain.Alimento;
import com.hackaton.unifacisa.domain.Refeicao;
import com.hackaton.unifacisa.domain.Usuario;
import com.hackaton.unifacisa.domain.enums.Perfil;
import com.hackaton.unifacisa.domain.enums.TipoRefeicao;
import com.hackaton.unifacisa.repositories.AlimentoRepository;
import com.hackaton.unifacisa.repositories.RefeicaoRepository;
import com.hackaton.unifacisa.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AlimentoRepository alimentoRepository;
	
	@Autowired
	private RefeicaoRepository refeicaoRepository;
	

	public void instantiateTestDatabase() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Refeicao ref1 = new Refeicao(null, sdf.parse("30/09/2017"), 10, TipoRefeicao.ALMOCO);
		Refeicao ref2 = new Refeicao(null, sdf.parse("30/09/2017"), 20, TipoRefeicao.JANTAR);
		Refeicao ref3 = new Refeicao(null, sdf.parse("30/09/2017"), 20, TipoRefeicao.DESJEJUN);
		Refeicao ref4 = new Refeicao(null, sdf.parse("30/09/2017"), 20, TipoRefeicao.LANCHEMANHA);
		Refeicao ref5 = new Refeicao(null, sdf.parse("30/09/2017"), 20, TipoRefeicao.LANCHETARDE);
		
		
		Refeicao ref6 = new Refeicao(null, sdf.parse("31/09/2017"), 20, TipoRefeicao.ALMOCO);
		Refeicao ref7 = new Refeicao(null, sdf.parse("31/09/2017"), 20, TipoRefeicao.JANTAR);
		Refeicao ref8 = new Refeicao(null, sdf.parse("31/09/2017"), 20, TipoRefeicao.LANCHEMANHA);
		Refeicao ref9 = new Refeicao(null, sdf.parse("31/09/2017"), 20, TipoRefeicao.LANCHETARDE);
		Refeicao ref10 = new Refeicao(null, sdf.parse("31/09/2017"), 20, TipoRefeicao.DESJEJUN);

		Alimento ali1 = new Alimento(null, "batata", 5, 7, 2, 9, 15, 15);
		Alimento ali2 = new Alimento(null, "mamão", 1, 8, 0, 5, 1, 18);
		Alimento ali3 = new Alimento(null, "limao", 2, 8, 0, 5, 1, 16);
		Alimento ali4 = new Alimento(null, "coco", 9, 8, 0, 5, 1, 17);
		Alimento ali5 = new Alimento(null, "alface", 8, 8, 0, 5, 1, 12);
		Alimento ali6 = new Alimento(null, "capin", 7, 8, 0, 5, 1, 18);
		Alimento ali7 = new Alimento(null, "ervas", 3, 8, 0, 5, 1, 11);
		Alimento ali8 = new Alimento(null, "canabis", 2, 8, 0, 5, 1, 13);

		Usuario user1 = new Usuario(null, "Abella", "987654321", "abella@gmail.com", pe.encode("123"), 40, 100, 90);
		Usuario user2 = new Usuario(null, "Maria", "987654000", "maria@gmail.com", pe.encode("123"), 25, 115, 50);
		Usuario user3 = new Usuario(null, "Caralo", "987654111", "carol@gmail.com", pe.encode("123"), 25, 115, 50);
		Usuario user4 = new Usuario(null, "Roberto", "987654888", "roberto@gmail.com", pe.encode("123"), 25, 115, 50);
		Usuario user5 = new Usuario(null, "Flavia", "987654333", "flavia@gmail.com", pe.encode("123"), 25, 115, 50);
		user5.addPerfis(Perfil.ADMIN);;

		alimentoRepository.saveAll(Arrays.asList(ali1, ali2,ali3,ali4,ali5,ali6,ali7,ali8));
		
		ref2.getAlimentos().add(ali1);
		ref1.getAlimentos().add(ali1);
		

		refeicaoRepository.saveAll(Arrays.asList(ref1, ref2));

		user1.getRefeicoes().add(ref2);
		user2.getRefeicoes().add(ref1);

		usuarioRepository.saveAll(Arrays.asList(user1, user2,user3,user4,user5));
	}

}
