package com.hackaton.unifacisa.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.unifacisa.domain.Refeicao;

@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao, Integer>{

	List<Refeicao> findByData(Date data);
}
