package com.hackaton.unifacisa.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hackaton.unifacisa.Services.exception.ObjectNotFoundException;
import com.hackaton.unifacisa.domain.Alimento;
import com.hackaton.unifacisa.domain.Refeicao;
import com.hackaton.unifacisa.domain.enums.TipoRefeicao;
import com.hackaton.unifacisa.dto.RefeicaoDTO;
import com.hackaton.unifacisa.repositories.RefeicaoRepository;

@Service
public class RefeicaoService {

	@Autowired
	private RefeicaoRepository refeicaoRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AlimentoService AlimentoService;

	public Refeicao find(Integer id) {
		Optional<Refeicao> obj = refeicaoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Refeicao.class.getName()));
	}

	public List<Refeicao> findAll() {
		return refeicaoRepository.findAll();
	}

	public List<Refeicao> findByData(Date data) {
		return refeicaoRepository.findByData(data);
	}

	
	public Refeicao insert(Refeicao obj) {
		obj.setId(null);
		obj = refeicaoRepository.save(obj);
		usuarioService.insertRefeicaoUser(obj);
		return obj;
	}

	public List<Refeicao> findByDate(Date data) {
		return refeicaoRepository.findByData(data);

	}

	public Refeicao update(Refeicao obj) {
		find(obj.getId());
		return refeicaoRepository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {

			refeicaoRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir");
		}
	}

	public Refeicao fromDTo(RefeicaoDTO refeicaoDTO) {
		Alimento alimento = AlimentoService.find(refeicaoDTO.getIdAlimento());
		Refeicao refeicao = new Refeicao(null, refeicaoDTO.getData(), refeicaoDTO.getQuantidade(),
				TipoRefeicao.toEnum(refeicaoDTO.getTipoRefeicao()));
		refeicao.setAlimentos(alimento);
		return refeicao;
	}

}
