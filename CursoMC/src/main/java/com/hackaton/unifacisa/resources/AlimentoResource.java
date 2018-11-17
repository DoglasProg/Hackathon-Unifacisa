package com.hackaton.unifacisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hackaton.unifacisa.Services.AlimentoService;
import com.hackaton.unifacisa.domain.Alimento;

public class AlimentoResource {
	
	@Autowired
	private AlimentoService alimentoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Alimento> find(@PathVariable Integer id) {
		Alimento obj = alimentoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Alimento>> findAll() {
		List<Alimento> list = alimentoService.findAll();
		return ResponseEntity.ok().body(list);
	}

}
