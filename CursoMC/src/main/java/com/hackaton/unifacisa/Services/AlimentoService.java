package com.hackaton.unifacisa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hackaton.unifacisa.Services.exception.ObjectNotFoundException;
import com.hackaton.unifacisa.domain.Alimento;
import com.hackaton.unifacisa.repositories.AlimentoRepository;

@Service
public class AlimentoService {
	
	@Autowired
	private AlimentoRepository alimentoRepository;
	
	public Alimento find(Integer id) {
		Optional<Alimento> obj = alimentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Alimento.class.getName()));
	}
	
	public List<Alimento> findAll() {
		return alimentoRepository.findAll();
	}
	
	public Alimento insert(Alimento obj) {
		obj.setId(null);
		obj = alimentoRepository.save(obj);
		return obj;
	}
	
	public Alimento update(Alimento obj) {
		find(obj.getId());
		return alimentoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			alimentoRepository.deleteById(id); 
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityViolationException("Não é possivel excluir");
		}
	}
}
