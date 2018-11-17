package com.hackaton.unifacisa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackaton.unifacisa.Services.exception.ObjectNotFoundException;
import com.hackaton.unifacisa.domain.Alimento;
import com.hackaton.unifacisa.domain.Categoria;
import com.hackaton.unifacisa.repositories.AlimentoRepository;

public class AlimentoService {
	
	@Autowired
	private AlimentoRepository alimentoRepository;
	
	public Alimento find(Integer id) {
		Optional<Alimento> obj = alimentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Categoria.class.getName()));
	}
	
	public List<Alimento> findAll() {
		return alimentoRepository.findAll();
	}
}
