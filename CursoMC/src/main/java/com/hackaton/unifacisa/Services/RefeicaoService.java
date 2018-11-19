package com.hackaton.unifacisa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.unifacisa.Services.exception.ObjectNotFoundException;
import com.hackaton.unifacisa.domain.Refeicao;
import com.hackaton.unifacisa.repositories.RefeicaoRepository;

@Service
public class RefeicaoService {
	
	@Autowired
	private RefeicaoRepository refeicaoRepository;
	
	public Refeicao find(Integer id) {
		Optional<Refeicao> obj = refeicaoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Refeicao.class.getName()));
	}
	
	public List<Refeicao> findAll() {
		return refeicaoRepository.findAll();
	}
	
	public Refeicao insert(Refeicao obj) {
		obj.setId(null);
		obj = refeicaoRepository.save(obj);
		return obj;
	}

}
