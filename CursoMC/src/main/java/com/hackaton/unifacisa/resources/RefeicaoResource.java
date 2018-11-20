package com.hackaton.unifacisa.resources;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hackaton.unifacisa.Services.RefeicaoService;
import com.hackaton.unifacisa.domain.Refeicao;
import com.hackaton.unifacisa.dto.RefeicaoDTO;

@RequestMapping(value="/refeicoes")
@RestController
public class RefeicaoResource {
	
	@Autowired
	private RefeicaoService refeicaoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Refeicao> find(@PathVariable Integer id) {
		Refeicao obj = refeicaoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Refeicao>> findAll() {
		List<Refeicao> list = refeicaoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody RefeicaoDTO refeicaoDTO){
		Refeicao refeicao = refeicaoService.fromDTo(refeicaoDTO);
		refeicaoService.insert(refeicao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(refeicao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		refeicaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody RefeicaoDTO refeicaoDTO, @PathVariable Integer id){
		Refeicao refeicao = refeicaoService.fromDTo(refeicaoDTO);
		refeicao.setId(id);
		refeicaoService.update(refeicao);
		return ResponseEntity.noContent().build();
	}
	

}
